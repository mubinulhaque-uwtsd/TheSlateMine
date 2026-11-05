public class OldMiner {
    // If the old miner has the spare helmet lamp
    public static boolean hasHelmet = false;

    // If you can talk to the old miner
    public static boolean talk(int currentRoom) {
        if (!hasHelmet && currentRoom == MoveRooms.lowerChamber) {
            System.out.println("The old miner points to the broken lamp on his head, and asks if you have a spare.");
            return true;
        } else if (currentRoom != MoveRooms.lowerChamber) {
            System.out.println("There is nobody like that in this room.");
        } else if (hasHelmet) {
            System.out.println("The old miner has no need to talk to you anymore.");
        }

        return false;
    }

    // If you can give the spare helmet lamp to the old miner
    public static boolean giveItem(String item, int currentRoom) {
        return false;
    }
}
