import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InventoryTests {
    // Verifies that the items can be picked up in the correct locations
    @Test
    void checkValidPickups() {
        App.newGame();

        assertEquals(true, Inventory.pickUp(MoveRooms.lowerChamber, "key"));
        assertEquals(true, Inventory.pickUp(MoveRooms.windingRoom, "old"));

        App.newGame();

        assertEquals(true, Inventory.pickUp(MoveRooms.windingRoom, "map"));
        assertEquals(true, Inventory.pickUp(MoveRooms.toolStore, "rope"));
        assertEquals(true, Inventory.pickUp(MoveRooms.entrance, "helmet"));

        App.newGame();

        assertEquals(true, Inventory.pickUp(MoveRooms.entrance, "lamp"));
    }

    // Verifies that the items cannot be picked up in the wrong locations
    @Test
    void checkInvalidPickups() {
        App.newGame();
        
        // Invalid tests for the rope item
        assertEquals(false, Inventory.pickUp(MoveRooms.entrance, "rope"));
        assertEquals(false, Inventory.pickUp(MoveRooms.lowerChamber, "rope"));
        assertEquals(false, Inventory.pickUp(MoveRooms.windingRoom, "rope"));
        assertEquals(false, Inventory.pickUp(MoveRooms.mainTunnel, "rope"));
        assertEquals(false, Inventory.pickUp(MoveRooms.shaftBottom, "rope"));

        // Invalid tests for the map item
        assertEquals(false, Inventory.pickUp(MoveRooms.entrance, "map"));
        assertEquals(false, Inventory.pickUp(MoveRooms.lowerChamber, "map"));
        assertEquals(false, Inventory.pickUp(MoveRooms.toolStore, "map"));
        assertEquals(false, Inventory.pickUp(MoveRooms.mainTunnel, "map"));
        assertEquals(false, Inventory.pickUp(MoveRooms.shaftBottom, "map"));

        // Invalid tests for the helmet item
        assertEquals(false, Inventory.pickUp(MoveRooms.toolStore, "helmet"));
        assertEquals(false, Inventory.pickUp(MoveRooms.lowerChamber, "helmet"));
        assertEquals(false, Inventory.pickUp(MoveRooms.windingRoom, "helmet"));
        assertEquals(false, Inventory.pickUp(MoveRooms.mainTunnel, "helmet"));
        assertEquals(false, Inventory.pickUp(MoveRooms.shaftBottom, "helmet"));

        // Invalid tests for the key item
        assertEquals(false, Inventory.pickUp(MoveRooms.entrance, "key"));
        assertEquals(false, Inventory.pickUp(MoveRooms.toolStore, "key"));
        assertEquals(false, Inventory.pickUp(MoveRooms.windingRoom, "key"));
        assertEquals(false, Inventory.pickUp(MoveRooms.mainTunnel, "key"));
        assertEquals(false, Inventory.pickUp(MoveRooms.shaftBottom, "key"));
    }

    // Verify that the player can drop items they are carrying
    @Test 
    void checkValidDrops() {
        App.newGame();

        Inventory.hasKey = true;
        assertTrue(Inventory.drop("key"));
        Inventory.hasHelmet = true;
        assertTrue(Inventory.drop("helmet"));
        Inventory.hasHelmet = true;
        assertTrue(Inventory.drop("helmet"));
        Inventory.hasMap = true;
        assertTrue(Inventory.drop("old"));
        Inventory.hasMap = true;
        assertTrue(Inventory.drop("map"));
        Inventory.hasRope = true;
        assertTrue(Inventory.drop("rope"));
    }

    // Verifies that the player cannot drop items they are not carrying
    @Test 
    void checkInvalidDrops() {
        App.newGame();

        assertFalse(Inventory.drop("key"));
        assertFalse(Inventory.drop("helmet"));
        assertFalse(Inventory.drop("lamp"));
        assertFalse(Inventory.drop("old"));
        assertFalse(Inventory.drop("map"));
        assertFalse(Inventory.drop("rope"));
    }

    // Verify that the player can drop items and then retrieve them again
    @Test 
    void checkDropAndGrab() {
        App.newGame();
        
        assertTrue(Inventory.pickUp(MoveRooms.toolStore, "rope"));
        assertTrue(Inventory.drop("rope"));
        assertTrue(Inventory.pickUp(MoveRooms.toolStore, "rope"));
    }
}
