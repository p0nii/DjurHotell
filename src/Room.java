public class Room {

    String Klimat;
    String Yta;

public Room (){
    Klimat="Rummet är inte valt än!";
    Yta = "Rummet är inte valt än!";
}

public Room (String Klimat, String Yta){
    this.Klimat = Klimat;
    this.Yta = Yta;
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
}