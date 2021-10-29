import java.util.ArrayList;
import java.util.Scanner;
public class DjurHotell {

    static ArrayList<Animal> dittDjur = new ArrayList<Animal>();
    static ArrayList<Room> room = new ArrayList<Room>();






    public static void start() {
        Skog rum1 = new Skog(101, "Skog", "40 m^2" );
        room.add(rum1);

        Hav rum2 = new Hav(102,"Hav","3000 m^3");
        room.add(rum2);

        Arktis rum3 = new Arktis(103, "Arktis", "75 m^2");
        room.add(rum3);




        boolean runProgram = true;
        while (runProgram) {


            printMenu();
            int menyval = getUserInt();

            switch (menyval) {
                case 1:
                    rumFörslag();
                    bokadeRum();
                    break;


                case 2:
                    System.out.println("Namn på ditt djur:");


                    System.out.println("Djurets favoritmat?");


                    System.out.println("Djurets favoritaktivitet?");

                    break;


                case 3:

            break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                runProgram = false;
                break;


            }
        }
        }
    public static void rumFörslag () {



       /* Skog rum1 = new Skog(101, "Skog", "40 m^2" );

        Hav rum2 = new Hav(102,"Hav","3000 m^3");

        Arktis rum3 = new Arktis(103, "Arktis", "75 m^2");*/
        System.out.println("Vi har tre olika rum: ");

        for (int i = 0; i < room.size(); i++ ){
            System.out.println(i + " " + room.get(i).getKlimat() + ", " + room.get(i).getYta());

    }
        System.out.println("Välj ett anpassande rum =>");
       ////// Skog allaRum = new Skog(101, 102, 103);

       // room.add(rum2.rumNummer);
       // room.add(rum3.rumNummer);


       /* System.out.println("1. " + rum1.Klimat + ", " + rum1.Yta);
        System.out.println("2. " + rum2.Klimat + ", " + rum2.Yta);
        System.out.println("3. " + rum3.Klimat +  ", " + rum3.Yta);*/


    }
    public static void bokadeRum () {

        Skog rum1 = new Skog(101, "Skog", "40 m^2" );

        Hav rum2 = new Hav(102,"Hav","3000 m^3");

        Arktis rum3 = new Arktis(103, "Arktis", "75 m^2")

        for (int i = 0; i < room.size(); i++ ){
            System.out.println(i + " " + room.get(i).getrumNummer() + ", " + room.get(i).getYta());

        }
        int rumMeny = getUserInt();

        switch (rumMeny) {
            case 1:
                System.out.println("Du har bokat rummet " + rum1.rumNummer + ", " + rum1.Klimat);
                break;
            case 2:
                System.out.println("Du har bokat rummet " + rum2.rumNummer + ", " + rum2.Klimat);
                break;
            case 3:
                System.out.println("Du har bokat rummet " + rum3.rumNummer+ ", " + rum3.Klimat);
                break;
        }
    }


    public static void printMenu(){

        System.out.println("Hej! Välkommen till Djurhotellet!");
        System.out.println("Vad vill du göra?");
        System.out.println("1. Jag vill boka ett rum ");
        System.out.println("2. Jag vill checka in mitt djur.");
        System.out.println("3. Jag vill checka ut  mitt djur.");
        System.out.println("4. Jag vill uppdatera min bokning.");
        System.out.println("5. Jag vill se min bokning.");
        System.out.print("Ange ett nummer av ovanstående alternativen =>");

    }

    public static int getUserInt() {
        Scanner scan = new Scanner(System.in);

        int myInt;

        while (true) {
            try {
                myInt = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Felaktigt menyval, försök igen!");
            }
        }
        return myInt;
    }

    public static String getUserString() {
        Scanner scan = new Scanner (System.in);

        String myString = (scan.nextLine());

        return myString;

    }
}

