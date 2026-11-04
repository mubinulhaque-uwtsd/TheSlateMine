import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InventoryTests {
    // Verifies that the items can be picked up in the correct locations
    @Test
    void checkValidPickups() {
        assertEquals(true, Inventory.pickUp(MoveRooms.lowerChamber, "key"));
        assertEquals(true, Inventory.pickUp(MoveRooms.windingRoom, "old"));
        Inventory.hasMap = false; // We have to set this back to false, otherwise it fails the test, because the item has already been picked up and thus doesn't exist in the room anymore.
        assertEquals(true, Inventory.pickUp(MoveRooms.windingRoom, "map"));
        assertEquals(true, Inventory.pickUp(MoveRooms.toolStore, "rope"));
        assertEquals(true, Inventory.pickUp(MoveRooms.entrance, "helmet"));
        Inventory.hasHelmet = false; // We have to set this back to false, otherwise it fails the test, because the item has already been picked up and thus doesn't exist in the room anymore.
        assertEquals(true, Inventory.pickUp(MoveRooms.entrance, "lamp"));
    }

    // Verifies that the items cannot be picked up in the wrong locations
    @Test
    void checkInvalidPickups() {
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
}
