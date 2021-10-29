public class Skog extends Room {
    int rumNummer;

    public Skog (int rumNummer, String Klimat, String Yta) {
        super(Klimat, Yta);
        this.rumNummer = rumNummer;

    }

    public void setRumNummer(int rumNummer) {
        this.rumNummer = rumNummer;
    }
}

