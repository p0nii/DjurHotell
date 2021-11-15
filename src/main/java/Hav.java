public class Hav extends Room {

    public Hav (int rumNummer,String Klimat, String Yta,boolean bokatRum, Animal gäst) {
        super(rumNummer, Klimat, Yta,bokatRum, gäst);


    }
    //subklassens konstruktor
    public Hav (int rumNummer,String Klimat, String Yta, boolean bokatRum) {
        super(rumNummer, Klimat, Yta, bokatRum);


    }
    @Override
    public void describe() {
        super.describe();
        System.out.println("Rummet hav är designat för delfiner. ");
    }


}
