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

    // ALL POSSIBLE LEGAL MOVES

    // All legal Moves for entrance
    assertEquals(true, moveChecker.checkMoveIsLegal(0, 0));

    // All legal mmoves for main tunnel
    assertEquals(true, moveChecker.checkMoveIsLegal(1, 0));
    assertEquals(true, moveChecker.checkMoveIsLegal(1, 1));
    assertEquals(true, moveChecker.checkMoveIsLegal(1, 2));
    assertEquals(true, moveChecker.checkMoveIsLegal(1, 3));

    // All legal moves for winding room 
    assertEquals(true, moveChecker.checkMoveIsLegal(2, 5));
    assertEquals(true, moveChecker.checkMoveIsLegal(2, 1));

    // All legal moves for lower chamber 
    assertEquals(true, moveChecker.checkMoveIsLegal(3, 4));
    
    // All legal moves for tool store
    assertEquals(true, moveChecker.checkMoveIsLegal(4, 3));

    // All legal moves for shaft bottom
    assertEquals(true, moveChecker.checkMoveIsLegal(5, 4));
    assertEquals(true, moveChecker.checkMoveIsLegal(5, 2));

    // All legal moves for shaft top 
    assertEquals(true, moveChecker.checkMoveIsLegal(6, 5));

    }

    @Test
    void testUnlockShaftBottomWithKey() {

        // Give player a key
        Inventory.hasKey = true;

        // Attempt to unlock shaft
        boolean result = moveChecker.unlockShaftBottom();

        // Verify unlock succeeded
        assertTrue(result);
        assertTrue(moveChecker.isShaftBottomUnlocked());
    }

    @Test
    void testUnlockShaftBottomWithoutKey() {

        // Ensure player has no key
        Inventory.hasKey = false;

        // Attempt to unlock shaft
        boolean result = moveChecker.unlockShaftBottom();

        // Verify unlock failed
        assertFalse(result);
    }

    @Test
    void testUseKeyCommandUnlocksShaft() {

        // Reset shaft state
        moveChecker.resetShaftBottomUnlocked();

        // Give player a key
        Inventory.hasKey = true;

        // Use the key
        Typer.command("use key");

        // Verify shaft was unlocked
        assertTrue(moveChecker.isShaftBottomUnlocked());
    }

    @Test
    void testUseKeyWithoutHavingKey() {

        // Reset shaft state
        moveChecker.resetShaftBottomUnlocked();

        // Ensure player has no key
        Inventory.hasKey = false;

        // Attempt to use key
        Typer.command("use key");

        // Verify shaft remains locked
        assertFalse(moveChecker.isShaftBottomUnlocked());
    }

    @Test
    void testUseMapCommandStillWorks() {

        // Verify map command does not crash
        assertDoesNotThrow(() -> {
            Typer.command("use map");
        });
    }

    @Test
    void testUseUnknownItem() {

        // Verify invalid item does not crash
        assertDoesNotThrow(() -> {
            Typer.command("use banana");
        });
    }

    @Test
    void testUseWithoutItem() {

        // Verify missing item is handled
        assertDoesNotThrow(() -> {
            Typer.command("use");
        });
    }

    @Test
    void testUnlockCalledTwice() {

        // Give player a key
        Inventory.hasKey = true;

        // Unlock twice
        moveChecker.unlockShaftBottom();
        moveChecker.unlockShaftBottom();

        // Verify shaft stays unlocked
        assertTrue(moveChecker.isShaftBottomUnlocked());
    }
}
