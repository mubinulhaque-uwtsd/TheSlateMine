import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.Test;



public class completegameTest {
   
    @Test 
    void CheckIfGameIsCompleted() throws Exception {
        int room = MoveRooms.shaftTop;

        assertEquals(true, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsNotCompletedEntrance() throws Exception {
        int room = MoveRooms.entrance;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedMainTunnel() throws Exception {
        int room = MoveRooms.mainTunnel;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedLowerChamber() throws Exception {
        int room = MoveRooms.lowerChamber;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedWindingRoom() throws Exception {
        int room = MoveRooms.windingRoom;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedToolStore() throws Exception {
        int room = MoveRooms.toolStore;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedShaftBottom() throws Exception {
        int room = MoveRooms.shaftBottom;
        assertEquals(false, completegame.IsGameComplete(room));
    }
}
