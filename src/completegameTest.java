import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class completegameTest {
   
    @Test 
    void CheckIfGameIsCompleted() throws Exception {
        App.newGame();

        int room = MoveRooms.shaftTop;

        assertEquals(true, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsNotCompletedEntrance() throws Exception {
        App.newGame();
        int room = MoveRooms.entrance;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedMainTunnel() throws Exception {
        App.newGame();
        int room = MoveRooms.mainTunnel;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedLowerChamber() throws Exception {
        App.newGame();
        int room = MoveRooms.lowerChamber;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedWindingRoom() throws Exception {
        App.newGame();
        int room = MoveRooms.windingRoom;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedToolStore() throws Exception {
        App.newGame();
        int room = MoveRooms.toolStore;
        assertEquals(false, completegame.IsGameComplete(room));
    }

    @Test
    void CheckIfGameIsCompletedShaftBottom() throws Exception {
        App.newGame();
        int room = MoveRooms.shaftBottom;
        assertEquals(false, completegame.IsGameComplete(room));
    }
}
