public class Arktis extends Room {

    public Arktis(int rumNummer, String Klimat, String Yta, boolean bokatRum, Animal gäst) {
        super(rumNummer, Klimat, Yta, bokatRum, gäst);

    }

    //subklassens konstruktor
    public Arktis(int rumNummer, String Klimat, String Yta, boolean bokatRum) {
        super(rumNummer, Klimat, Yta, bokatRum);
    }

    //overridear metoden Describe från klassen superklassen Room.
    @Override
    public void describe() {
        super.describe();
        System.out.println("Rummet Arktis är designat för isbjörnar.");
    }


}
