import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoveRoomsTest {

    @Test
    // Verify that moving north from the Entrance reaches the Main Tunnel.
    void entranceNorthGoesToMainTunnel() {
        assertEquals(MoveRooms.mainTunnel,
                MoveRooms.move(MoveRooms.entrance, MoveRooms.north));
    }

    @Test
    // Verify that moving south from the Main Tunnel returns to the Entrance.
    void mainTunnelSouthGoesToEntrance() {
        assertEquals(MoveRooms.entrance,
                MoveRooms.move(MoveRooms.mainTunnel, MoveRooms.south));
    }

    @Test
    // Verify that moving east from the Main Tunnel reaches the Tool Store.
    void mainTunnelEastGoesToToolStore() {
        assertEquals(MoveRooms.toolStore,
                MoveRooms.move(MoveRooms.mainTunnel, MoveRooms.east));
    }

    @Test
    // Verify that moving east from the Entrance is not possible.
    void entranceEastIsInvalid() {
        assertEquals(-1,
                MoveRooms.move(MoveRooms.entrance, MoveRooms.east));
    }

    @Test
    // Verify that moving north from the Shaft Top is not possible.
    void shaftTopNorthIsInvalid() {
        assertEquals(-1,
                MoveRooms.move(MoveRooms.shaftTop, MoveRooms.north));
    }

    @Test
    // Verify that an invalid room number returns -1.
    void invalidRoomReturnsMinusOne() {
        assertEquals(-1,
                MoveRooms.move(99, MoveRooms.north));
    }

    @Test
    // Verify that an invalid direction returns -1.
    void invalidDirectionReturnsMinusOne() {
        assertEquals(-1,
                MoveRooms.move(MoveRooms.entrance, 99));
    }

    @Test
    // Verify that moving north then south returns to the original room.
    void entranceNorthThenSouthReturnsToEntrance() {
        int room = MoveRooms.move(MoveRooms.entrance, MoveRooms.north);
        room = MoveRooms.move(room, MoveRooms.south);

        assertEquals(MoveRooms.entrance, room);
    }

    @Test
    // Verify that moving down then up returns to the original room.
    void windingRoomDownThenUpReturnsToWindingRoom() {
        int room = MoveRooms.move(MoveRooms.windingRoom, MoveRooms.down);
        room = MoveRooms.move(room, MoveRooms.up);

        assertEquals(MoveRooms.windingRoom, room);
    }

    @Test
    // Verify that each room has six possible direction slots.
    void everyRoomHasSixDirections() {
        for (int[] room : MoveRooms.exits) {
            assertEquals(6, room.length);
        }
    }

    @Test 
    // Verify that each direction returns the correct integer
    void checkGetDirection() {
       assertEquals(MoveRooms.north, MoveRooms.getDirection("north"));
       assertEquals(MoveRooms.east, MoveRooms.getDirection("east"));
       assertEquals(MoveRooms.south, MoveRooms.getDirection("south"));
       assertEquals(MoveRooms.west, MoveRooms.getDirection("west"));
       assertEquals(MoveRooms.up, MoveRooms.getDirection("up"));
       assertEquals(MoveRooms.down, MoveRooms.getDirection("down"));
       
       assertEquals(-1, MoveRooms.getDirection("wrong"));
    }
}