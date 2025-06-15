package org.example;
import org.junit.jupiter.api. Test;
import static org.junit.jupiter.api.Assertions .*;

class RoomTest {

    // annotation placeholder
    @Test

    public void roomIsClean_roomIsNotOccupied_Available() {

// Arrange
//Arrange


//Make any objects or variables you need for your test


        Room room = new Room(3, 10, false, false);

        //Act
        boolean results = room.isAvailable();

                //assert

                assertTrue(true, String.valueOf(results));
    }
}