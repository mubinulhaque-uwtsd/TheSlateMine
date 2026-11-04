import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test;

public class roomdescriptionTest {
    @Test 
    void CheckIfCorrectDescriptionForEntrance() throws Exception {
        int room = MoveRooms.entrance;

        assertEquals("You are standing at the entrance. It is dim and damp.", roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForMainTunnel() throws Exception {
        int room = MoveRooms.mainTunnel;
        assertEquals("You are standing at the main tunnel", roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForLowerChamber() throws Exception {
        int room = MoveRooms.lowerChamber;
        assertEquals("You are standing at the lower chamber", roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForWindingRoom() throws Exception {
        int room = MoveRooms.windingRoom;
        assertEquals("You are standing in the winding room", roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForToolStore() throws Exception {
        int room = MoveRooms.toolStore;
        assertEquals("You are standing in a tool store", roomdescription.room_description(room));
    }



    @Test
    void CheckIfCorrectDescriptionForShaftBottom() throws Exception {
        int room = MoveRooms.shaftBottom;
        assertEquals("You are standing at a shaft bottom", roomdescription.room_description(room));
    }



    @Test
    void CheckIfCorrectDescriptionForShaftTop() throws Exception {
        int room = MoveRooms.shaftTop;
        assertEquals("You are standing at the shaft top", roomdescription.room_description(room));
    }
 
       
    }

