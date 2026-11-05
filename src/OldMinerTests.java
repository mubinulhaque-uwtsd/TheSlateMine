import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OldMinerTests {
    // Checks if the old miner wants to talk when he has no helmet lamp
    @Test 
    void checkMinerTalks() {
        OldMiner.hasHelmet = false;
        assertTrue(OldMiner.talk(MoveRooms.lowerChamber));
    }

    // Checks if you can't talk to the old miner in the wrong room
    @Test
    void checkMinerDoesntTalkInWrongRoom() {
        assertFalse(OldMiner.talk(MoveRooms.entrance));
        assertFalse(OldMiner.talk(MoveRooms.mainTunnel));
        assertFalse(OldMiner.talk(MoveRooms.toolStore));
        assertFalse(OldMiner.talk(MoveRooms.windingRoom));
        assertFalse(OldMiner.talk(MoveRooms.shaftBottom));
        assertFalse(OldMiner.talk(MoveRooms.shaftTop));
    }

    // Checks if the old miner has the helmet lamp after giving him it
    @Test 
    void checkMinerGetsHelmet() {
        OldMiner.giveItem("helmet", MoveRooms.lowerChamber);
        assertTrue(OldMiner.hasHelmet);
    }

    // Checks if the old miner stops talking after receiving the old helmet lamp
    @Test 
    void checkMinerStopsTalking() {
        OldMiner.giveItem("helmet", MoveRooms.lowerChamber);
        assertFalse(OldMiner.talk(MoveRooms.lowerChamber));
    }

    // Checks if the old miner rejects any item other than the helmet lamp
    @Test
    void checkMinerRejectsWrongItem() {
        assertFalse(OldMiner.giveItem("rope", MoveRooms.lowerChamber));
        assertFalse(OldMiner.giveItem("old", MoveRooms.lowerChamber));
        assertFalse(OldMiner.giveItem("map", MoveRooms.lowerChamber));
        assertFalse(OldMiner.giveItem("key", MoveRooms.lowerChamber));
    }

    // Checks if the old miner rejects the helmet lamp if the player doesn't have it
    @Test 
    void checkMinerRejectsMissingItem() {
        Inventory.hasHelmet = false;
        assertFalse(OldMiner.giveItem("helmet", MoveRooms.lowerChamber));
    }

    // Checks if the old miner rejects the helmet lamp if you're not in the same room as him
    @Test
    void checkMinerRejectsItemInWrongRoom() {
        Inventory.hasHelmet = true;

        assertFalse(OldMiner.giveItem("helmet", MoveRooms.entrance));
        assertFalse(OldMiner.giveItem("helmet", MoveRooms.mainTunnel));
        assertFalse(OldMiner.giveItem("helmet", MoveRooms.windingRoom));
        assertFalse(OldMiner.giveItem("helmet", MoveRooms.toolStore));
        assertFalse(OldMiner.giveItem("helmet", MoveRooms.shaftBottom));
        assertFalse(OldMiner.giveItem("helmet", MoveRooms.shaftTop));

        assertFalse(OldMiner.giveItem("lamp", MoveRooms.entrance));
        assertFalse(OldMiner.giveItem("lamp", MoveRooms.mainTunnel));
        assertFalse(OldMiner.giveItem("lamp", MoveRooms.windingRoom));
        assertFalse(OldMiner.giveItem("lamp", MoveRooms.toolStore));
        assertFalse(OldMiner.giveItem("lamp", MoveRooms.shaftBottom));
        assertFalse(OldMiner.giveItem("lamp", MoveRooms.shaftTop));
    }
}
