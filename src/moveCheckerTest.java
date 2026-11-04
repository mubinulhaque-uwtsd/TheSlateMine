import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class moveCheckerTest {


    @Test 
    void checkIsMoveLegal() throws Exception {

    // Tests to verify illegal moves between rooms - all should fail as the player 
    // cannot move in the direction given from each room. 
    assertEquals(false, moveChecker.checkMoveIsLegal(0, 4));
    assertEquals(false, moveChecker.checkMoveIsLegal(1, 4));
    assertEquals(false, moveChecker.checkMoveIsLegal(2, 2));
    assertEquals(false, moveChecker.checkMoveIsLegal(3, 5));
    assertEquals(false, moveChecker.checkMoveIsLegal(4, 4));
    assertEquals(false, moveChecker.checkMoveIsLegal(5, 1));
    assertEquals(false, moveChecker.checkMoveIsLegal(6, 4));
    
    // Tests to verify legal moves between rooms - all should pass as the direction 
    // for each room is a valid exit to another room. 
    assertEquals(true, moveChecker.checkMoveIsLegal(0, 0));
    assertEquals(true, moveChecker.checkMoveIsLegal(1, 2));
    assertEquals(true, moveChecker.checkMoveIsLegal(2, 5));
    assertEquals(true, moveChecker.checkMoveIsLegal(3, 4));
    assertEquals(true, moveChecker.checkMoveIsLegal(4, 3));
    assertEquals(true, moveChecker.checkMoveIsLegal(5, 4));
    assertEquals(true, moveChecker.checkMoveIsLegal(6, 5));

    }
    
}
