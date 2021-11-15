public class Skog extends Room {

    public Skog(int rumNummer, String Klimat, String Yta, boolean bokatRum, Animal gäst) {
        super(rumNummer, Klimat, Yta, bokatRum, gäst);


    }

    //subklassens konstruktor
    public Skog(int rumNummer, String Klimat, String Yta, boolean bokatRum) {
        super(rumNummer, Klimat, Yta, bokatRum);


    }
    //Här overridear vi metoden describe från superklassen Room
    @Override
    public void describe() {
        super.describe();
        System.out.println("Rummet skog är designat för fåglar. ");
    }
}

