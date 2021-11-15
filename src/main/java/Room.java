public class Room {
    //Attribut
    int rumNummer;
    String Klimat;
    String Yta;
    Animal gäst;
    boolean bokatRum;

    //Konstruktor
    public Room() {
        Klimat = "Rummet är inte valt än!";
        Yta = "Rummet är inte valt än!";
    }
    //konstruktor som används när man initierar ett objekt.
    public Room(int rumNummer, String Klimat, String Yta, boolean bokatRum, Animal gäst) {
        this.rumNummer = rumNummer;
        this.Klimat = Klimat;
        this.Yta = Yta;
        this.bokatRum = bokatRum;
        this.gäst = gäst;
    }

    public Room(int rumNummer, String Klimat, String Yta, boolean bokatRum) {
        this.rumNummer = rumNummer;
        this.Klimat = Klimat;
        this.Yta = Yta;
        this.bokatRum = bokatRum;

    }
    public void describe() {

        System.out.println("Rummets namn: " + this.Klimat + ". ");
        System.out.println("Rummets storlek: " + this.Yta + ". ");

    }

    // Setter och getter metoder
    public void setRumNummer(int rumNummer) {
        this.rumNummer = rumNummer;
    }

    public int getrumNummer() {
        return rumNummer;
    }

    public String getKlimat() {
        return Klimat;
    }

    public void setKlimat(String klimat) {
        Klimat = klimat;
    }

    public String getYta() {
        return Yta;
    }

    public void setYta(String yta) {
        Yta = yta;
    }

    public Animal getGäst() {
        return gäst;
    }

    public void setGäst(Animal gäst) {
        this.gäst = gäst;
    }

    public boolean getbokatRum() {
        return bokatRum;
    }

    public void setBokatRum(boolean bokatRum) {
        this.bokatRum = bokatRum;
    }


}