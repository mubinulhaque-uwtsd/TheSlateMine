import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class roomdescriptionTest {

    @Test
    void CheckIfCorrectDescriptionForEntrance() throws Exception {
        App.newGame();

        Inventory.hasHelmet = true;
        assertEquals(
            "You are standing at the entrance. It is dim and damp. You see a main tunnel ahead.",
            roomdescription.room_description(MoveRooms.entrance));

        Inventory.hasHelmet = false;
        assertEquals(
            "You are standing at the entrance. It is dim and damp. You see a main tunnel ahead. There is a dusty helmet lamp on the floor.",
            roomdescription.room_description(MoveRooms.entrance));
    }

    @Test
    void CheckIfCorrectDescriptionForMainTunnel() throws Exception {
        App.newGame();

        int room = MoveRooms.mainTunnel;
        assertEquals(
            "You are standing at the main tunnel. The tunnel branches into different paths, a winding room to the left, and what looks like a storage room to the right.",
            roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForLowerChamber() throws Exception {
        App.newGame();

        int room = MoveRooms.lowerChamber;

        Inventory.hasKey = true;
        assertEquals(
            "After climbing down the winding room, you arrive in a dark lower chamber. Seems like it doesn't go any furhter.",
            roomdescription.room_description(room));

        Inventory.hasKey = false;
        assertEquals(
            "After climbing down the winding room, you arrive in a dark lower chamber. Seems like it doesn't go any furhter. There is a key here, shining on the ground.",
            roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForWindingRoom() throws Exception {
        App.newGame();

        int room = MoveRooms.windingRoom;

        Inventory.hasMap = false;
        assertEquals(
            "You are standing in the winding room. A hole in the ground leads down below. There is an old map here.",
            roomdescription.room_description(room));

        Inventory.hasMap = true;
        assertEquals(
            "You are standing in the winding room. A hole in the ground leads down below.",
            roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForToolStore() throws Exception {
        App.newGame();

        int room = MoveRooms.toolStore;

        Inventory.hasRope = true;
        assertEquals(
            "You are standing in a tool store.",
            roomdescription.room_description(room));

        Inventory.hasRope = false;
        assertEquals(
            "You are standing in a tool store. There is a rope here.",
            roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForShaftBottom() throws Exception {
        App.newGame();

        int room = MoveRooms.shaftBottom;

        assertEquals(
            "You are standing at a shaft bottom. Looking up, you see the top of the shaft.",
            roomdescription.room_description(room));
    }

    @Test
    void CheckIfCorrectDescriptionForShaftTop() throws Exception {
        App.newGame();

        int room = MoveRooms.shaftTop;

        assertEquals(
            "You are standing at the top of the shaft. Light peaks through.",
            roomdescription.room_description(room));
    }
}