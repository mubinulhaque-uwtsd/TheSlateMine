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
        if (!hasHelmet && currentRoom == MoveRooms.lowerChamber && Inventory.hasHelmet && (item.equalsIgnoreCase("helmet") || item.equalsIgnoreCase("lamp"))) {
            // If you are in the same room as the old miner, and you are able to give him the helmet lamp that he wants
            System.out.println("You give him the spare helmet lamp. He thanks you, and in return, hands you a key. Its label says, \"Gate to Shaft Bottom\".");
            hasHelmet = true;
            Inventory.hasHelmet = false;
            Inventory.hasKey = true;
            return true;
        } else if (currentRoom != MoveRooms.lowerChamber) {
            // If you are not in the same room as the old miner
            System.out.println("There is nobody like this to give an item to.");
        } else if (!(item.equalsIgnoreCase("helmet") || item.equalsIgnoreCase("lamp"))) {
            // If you give him an item that the old miner doesn't want
            System.out.println("The old miner doesn't want this.");
        } else if (!Inventory.hasHelmet) {
            // If you give him a helmet lamp that you don't have
            System.out.println("You don't have an item like this to give.");
        } else if (hasHelmet) {
            // If the old miner already has the spare helmet lamp
            System.out.println("The old miner already has a working helmet lamp. He doesn't need a second.");
        }

        return false;
    }
}
