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
        OldMiner.giveItem("helmet");
        assertTrue(OldMiner.hasHelmet);
    }

    // Checks if the old miner stops talking after receiving the old helmet lamp
    @Test 
    void checkMinerStopsTalking() {
        OldMiner.giveItem("helmet");
        assertFalse(OldMiner.talk(MoveRooms.lowerChamber));
    }

    // Checks if the old miner rejects any item other than the helmet lamp
    @Test
    void checkMinerRejectsWrongItem() {
        assertFalse(OldMiner.giveItem("rope"));
    }

    // Checks if the old miner rejects the helmet lamp if the player doesn't have it
    @Test 
    void checkMinerRejectsMissingItem() {
        Inventory.hasHelmet = false;
        assertFalse(OldMiner.giveItem("helmet"));
    }
}
