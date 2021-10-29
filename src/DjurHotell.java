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

        switch(menyval){
            case 1:
                System.out.println("Namn på ditt djur:");
                dittDjur.add(getUserString());

                System.out.println("Djurets favoritmat?");
                dittDjur.add(getUserString());

                System.out.println("Djurets favoritaktivitet?");
                dittDjur.add(getUserString());




            case 2:

            case 3:

            case 4:
                runProgram = false;
                break;
        }

    }
    }
    public static void printMenu(){

        System.out.println("Hej! Välkommen till Djurhotellet");
        System.out.println("Vad vill du göra? ?????");
        System.out.println("1. Jag vill boka ett rum. ");
        System.out.println("2. Jag vill checka in mitt djur.");
        System.out.println("3. Jag vill checka ut  mitt djur.");
        System.out.println("4. Jag vill uppdatera min bokning.");
        System.out.println("5. Jag vill se min bokning.");
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

