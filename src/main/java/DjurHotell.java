import java.util.ArrayList;
import java.util.Scanner;

public class DjurHotell {

    // Vi skapar en arraylist av klassen Room.
    ArrayList<Room> rooms = new ArrayList<Room>();

    public void start() {
        // Vi skapar ett objekt av varje rum och lägger i array-listen rooms.
        Skog rum1 = new Skog(101, "Skog", "75 m^2", false);
        rooms.add(rum1);

        Hav rum2 = new Hav(102, "Hav", "1000 m^3", false);
        rooms.add(rum2);

        Arktis rum3 = new Arktis(103, "Arktis", "150 m^2", false);
        rooms.add(rum3);


        boolean runProgram = true;

        //while-loop som gör att vårat program fortsätter köra tills vi väljer att sätta den till false.
        while (runProgram) {

            printMenu();
            int menyval = getUserInt();

            //switch sats till menyn. Till exempel om användaren väljer "1" så gör programmet det som ligger i case 1.
            switch (menyval) {
                case 1:
                    checkInDjur();
                    break;

                case 2:
                    checkaUt();
                    break;

                case 3:
                    uppdateraBokning();
                    break;

                case 4:
                    visaBoknigen();
                    break;

                case 5:
                    listaAllaBokningar();
                    break;

                case 6:
                    filtreraBokning();
                    break;

                case 7:
                    System.out.println("Programmet har avslutats.");
                    runProgram = false;
                    break;

                default:
                    System.out.println("Felaktigt menyval, försök igen!");
            }
        }
    }

    //Denna metod används när användaren ska checka in sitt djur.
    public void checkInDjur() {
        System.out.println("Vilket djur vill du checka in?");
        System.out.println("1. Fågel");
        System.out.println("2. Isbjörn");
        System.out.println("3. Delfin");
        int userChoice = getUserInt();

        //Värden av konstruktorn (namn, mat, aktivitet) skrivs av användaren.
        System.out.println("Djurets namn?");
        String namn = getUserString();
        System.out.println("Djurets favoritmat?");
        String mat = getUserString();
        System.out.println("Djurets favoritaktivitet?");
        String aktivitet = getUserString();

        Animal valtObjekt = null;

        switch (userChoice) {
            case 1:

                // Vi skapar objekt av klassen Fågel och anropar konstruktorn som är ärvt från klassen Animal.
                Fågel fågel = new Fågel(namn, mat, aktivitet);
                valtObjekt = fågel;
                break;

            case 2:
                // Vi skapar objekt av klassen Delfin
                Delfin delfin = new Delfin(namn, mat, aktivitet);
                valtObjekt = delfin;
                break;

            case 3:
                // Vi skapar objekt av klassen Isbjörn
                Isbjörn isbjörn = new Isbjörn(namn, mat, aktivitet);
                valtObjekt = isbjörn;
                break;
        }

        System.out.println("Vi har tre olika rum: ");
        //for-loop som loopar igenom alla våra tre rum och visar rummens namn och storlek till användaren.
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.println((i + 1) + ". " + room.getKlimat() + ", " + room.getYta());
        }

        System.out.print("Välj ett passande rum => ");
        //Användaren får välja rum genom att skriva 1-3, när användaren valt rum så sätts gästen in i det rum som användaren valt.
        userChoice = getUserInt();
        rooms.get(userChoice - 1).setGäst(valtObjekt);
        rooms.get(userChoice - 1).setBokatRum(true);
    }

    //Denna metod används när användaren vill checka ut sitt djur.
    public void checkaUt() {
        // Här sätter man setGäst(null) för att kunna ta bort de sparade informationen i getGäst, då
        // angiven namn av användaren stämmer med det som är sparat i getGäst.
        System.out.println("Djurets namn?");
        String djuretsNamn = getUserString();


        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getGäst() != null && djuretsNamn.equals(rooms.get(i).getGäst().getNamn())) {
                System.out.println("Hej " + djuretsNamn + "! Du har checkat ut.");
                rooms.get(i).setGäst(null);
                rooms.get(i).setBokatRum(false);

                // setBokatRum är skriven till false för att spara att det inte är någon gäst i rummet.
            }
        }
    }

    //Denna metod används när användaren vill se hela sin bokning (rumsnummer, rumsbeskrivning, namn, favoritmat, och favoritaktivitet)
    public void visaBoknigen() {
        //Användaren får skriva in djurets namn
        System.out.println("Djurets namn?");
        String djuretsNamn;
        System.out.print("=> ");
        djuretsNamn = getUserString();

        boolean resultathittat = false;
        //for-loop som loopar igenom alla rum och letar efter namnet på djuret som användaren nyss skrivit in.
        for (int i = 0; i < rooms.size(); i++) {

            if (rooms.get(i).getGäst() != null && djuretsNamn.equals(rooms.get(i).getGäst().getNamn())) {
                System.out.println("Hej " + djuretsNamn + "! \n" + "Du har bokat rum " + rooms.get(i).getrumNummer());
                System.out.println("Favoritmat: " + rooms.get(i).getGäst().getFavoritmat());
                System.out.println("Favoritaktivitet: " + rooms.get(i).getGäst().getFavoritaktivitet());
                rooms.get(i).describe();

                //Om djurets namn hittas så skrivs hela bokningen ut (rumsnummer, rumsbeskrivning, namn, favoritmat, och favoritaktivitet)
                resultathittat = true;
            }
        }   //Om djurets namn inte hittas så sätter vi våran boolean(resultathittat) till false och användaren kommer få ett meddelande om att djuret inte är bokat hos oss.
        if (!resultathittat) {
            System.out.println("Ditt djur är inte bokat hos oss");
        }
    }

    //Denna metod används för att lista namn och rumsnummer på alla djur som är incheckade på hotellet.
    public void listaAllaBokningar() {
        //for loop som loopar igenom alla rum och letar efter rum som är bokade. Programmet kommer skriva ut djurets namn och rumsnummer på alla bokade gäster.
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getbokatRum()) {
                System.out.println("Namn: " + rooms.get(i).getGäst().getNamn() + ", Rumsnummer: " + rooms.get(i).getrumNummer());
            }
        }
    }

    //Den här metoden används när man ska filtrera sökningen efter djurets namn (tex om ett djur heter bubba, så ska man hitta djuret genom att skriva bu)
    public void filtreraBokning() {

        System.out.println("Djurets namn?");
        String djuretsNamn;
        System.out.print("=> ");
        djuretsNamn = getUserString();

        boolean resultathittat = false;
        //for-loop som loopar igenom alla rum och letar efter namnet på djuret som användaren nyss skrivit in.
        for (int i = 0; i < rooms.size(); i++) {
            // Om det finns gäster i rummen och om gästernas namn innehåller dessa bokstäver som är skrivna av användaren, printas allt i blocket ut .
            if (rooms.get(i).getGäst() != null && rooms.get(i).getGäst().getNamn().contains(djuretsNamn)) {
                System.out.println(rooms.get(i).getGäst().getNamn());

                resultathittat = true;
            }
        }
        //Om djurets namn inte hittas så sätter vi våran boolean(resultathittat) till false och användaren kommer få ett meddelande om att djuret inte är bokat hos oss.
        if (!resultathittat) {
            System.out.println("Ditt djur är inte bokat hos oss");
        }
    }

    //Denna metod används om man vill uppdatera sin bokning, man kan ändra namn, rum, favoritmat och favoritaktivitet.
    public void uppdateraBokning() {
        System.out.println("Vad vill du ändra?");
        System.out.println("1. Djurets namn");
        System.out.println("2. Djurets rum");
        System.out.println("3. Favoritmat");
        System.out.println("4. Favoritaktivitet");
        int uppdatering = getUserInt();

        System.out.println("Skriv djurets namn");
        System.out.print("=> ");
        String djuretsNamn = getUserString();
        //for loop går genom alla rummen och om det finns gäster med namnet användaren har skrivit får man uppdatera sina information.
        for (int i = 0; i < rooms.size(); i++) {

            if (rooms.get(i).getGäst() != null && djuretsNamn.equals(rooms.get(i).getGäst().getNamn())) {
                System.out.println("Hej " + djuretsNamn);


                switch (uppdatering) {

                    case 1:
                        // Här kan användaren ändra sitt namn genom att anropa setter-metoden och sätta ett nytt värde.
                        System.out.println("Skriv det nya namnet ");
                        System.out.print("=> ");
                        String nyNamn = getUserString();
                        rooms.get(i).getGäst().setNamn(nyNamn);
                        System.out.println("Du har ändrat ditt namn till " + nyNamn + ". ");
                        break;
                    case 2:

                        System.out.println("Vi har tre olika rum: ");

                        for (i = 0; i < rooms.size(); i++) {
                            //Koden blir lättare att läsa mhv variabeln room.
                            Room room = rooms.get(i);
                            System.out.println((i + 1) + ". " + room.getKlimat() + ", " + room.getYta());
                            // Här hämtar man hårdkodade informationen från klassen Room.
                        }
                        // Här kan man byta sitt rum.
                        System.out.println("Välj ett alternativ ");
                        System.out.print("=> ");
                        int nyttRum = getUserInt();
                        rooms.get(i).setRumNummer(nyttRum);
                        System.out.println("Du har ändrat favoritmaten till " + nyttRum + ". ");
                        break;

                    case 3:
                        // Här kan man ändra informationen av favoritmat.
                        System.out.println("Skriv den nya favoritmaten ");
                        System.out.print("=> ");
                        String nyFavoritmat = getUserString();
                        rooms.get(i).getGäst().setFavoritmat(nyFavoritmat);
                        System.out.println("Du har ändrat favoritmaten till " + nyFavoritmat + ". ");
                        break;

                    case 4:
                        // Här kan man ändra informationen av favoritaktivitet.
                        System.out.println("Skriv det nya favoritaktiviteten ");
                        System.out.print("=> ");
                        String nyFavoritaktivitet = getUserString();
                        rooms.get(i).getGäst().setFavoritaktivitet(nyFavoritaktivitet);
                        System.out.println("Du har ändrat favoritmaten till " + nyFavoritaktivitet + ". ");

                        break;

                    default:
                        System.out.println(" Felaktigt menyval. Försök igen.");
                }
            }
        }
    }

    //metod med alla menyval
    public void printMenu() {
        //Detta är menyvalen som användaren får upp i programmet.
        System.out.println("  ");
        System.out.println("Hej! Välkommen till Djurhotellet!");
        System.out.println("Vad vill du göra?");
        System.out.println("1. Jag vill checka in mitt djur.");
        System.out.println("2. Jag vill checka ut  mitt djur.");
        System.out.println("3. Jag vill uppdatera min bokning.");
        System.out.println("4. Jag vill se min bokning.");
        System.out.println("5. Lista alla bokningar");
        System.out.println("6. Filtrera bokningar");
        System.out.println("7. Avsluta programmet.");
        System.out.print("Ange ett nummer av ovanstående alternativen =>");

    }

    //int scanner
    public int getUserInt() {
        Scanner scan = new Scanner(System.in);

        int myInt;

        while (true) {
            try {
                myInt = Integer.parseInt(scan.nextLine());
                //   myInt = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Felaktigt menyval, försök igen!");
            }
        }
        return myInt;
    }

    //String scanner
    public String getUserString() {
        Scanner scan = new Scanner(System.in);

        String myString = (scan.nextLine());

        return myString;

    }
}

