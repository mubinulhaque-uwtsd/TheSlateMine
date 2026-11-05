import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class moveCheckerTest {


     // Test to check that invalid user input is handled
    @Test
    public void checkInvalidUserInput() {

    boolean result = moveChecker.checkMoveIsLegal(MoveRooms.mainTunnel,-1);

    assertFalse(result);
    
    }   

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

    // Test to check that invalid user input is handled
    
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
        boolean result = moveChecker.unlockShaftBottom(MoveRooms.mainTunnel);

        // Verify unlock succeeded
        assertTrue(result);
        assertTrue(moveChecker.isShaftBottomUnlocked());
    }

    @Test
    void testUnlockShaftBottomWithoutKey() {

        // Ensure player has no key
        Inventory.hasKey = false;

        // Attempt to unlock shaft
        boolean result = moveChecker.unlockShaftBottom(MoveRooms.shaftBottom);

        // Verify unlock failed
        assertFalse(result);
    }

    @Test
    void testUseKeyCommandUnlocksShaft() {

        // Reset shaft state
        moveChecker.resetShaftBottomUnlocked();

        // Give player a key
        Inventory.hasKey = true;

        // Move to main tunnel
        Typer.currentRoom = MoveRooms.mainTunnel;

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
        moveChecker.unlockShaftBottom(MoveRooms.mainTunnel);
        moveChecker.unlockShaftBottom(MoveRooms.mainTunnel);

        // Verify shaft stays unlocked
        assertTrue(moveChecker.isShaftBottomUnlocked());
    }

    @Test
    void testUseRopeWithRope() {

        // Reset shaft top state
        moveChecker.resetShaftTopAccessible();

        // Give player a rope
        Inventory.hasRope = true;

        // Use rope
        boolean result = moveChecker.useRopeOnShaftTop(MoveRooms.shaftBottom);

        // Verify access granted
        assertTrue(result);
        assertTrue(moveChecker.isShaftTopAccessible());
    }

    @Test
    void testUseRopeWithoutRope() {

        // Reset shaft top state
        moveChecker.resetShaftTopAccessible();

        // Ensure player has no rope
        Inventory.hasRope = false;

        // Attempt to use rope
        boolean result = moveChecker.useRopeOnShaftTop(MoveRooms.shaftBottom);

        // Verify access denied
        assertFalse(result);
        assertFalse(moveChecker.isShaftTopAccessible());
    }

    @Test
    void testUseRopeCommandGrantsAccess() {

        // Reset shaft top state
        moveChecker.resetShaftTopAccessible();

        // Give player a rope
        Inventory.hasRope = true;

        // Move to shaft bottom
        Typer.currentRoom = MoveRooms.shaftBottom;

        // Use rope command
        Typer.command("use rope");

        // Verify access granted
        assertTrue(moveChecker.isShaftTopAccessible());
    }

    @Test
    void testUseRopeCommandWithoutRope() {

        // Reset shaft top state
        moveChecker.resetShaftTopAccessible();

        // Ensure player has no rope
        Inventory.hasRope = false;

        // Attempt to use rope
        Typer.command("use rope");

        // Verify access denied
        assertFalse(moveChecker.isShaftTopAccessible());
    }
}
