import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getKlimat() {
        Room rooms = new Room();
        rooms.setKlimat("Skog");
        assertTrue(rooms.getKlimat() == "Skog") ;
    }

    @Test
    void getYta() {
        Room rooms = new Room();
        rooms.setYta("75 m^2");
        assertTrue(rooms.getYta() == "75 m^2") ;
    }

    @Test
    void getrumNummer() {
        Room rooms = new Room();
        rooms.setRumNummer(101);
        assertTrue(rooms.getrumNummer() == 101) ;
    }
}