public class Inventory {
    public static boolean hasHelmet = false;
    public static boolean hasKey = false;
    public static boolean hasMap = false;
    public static boolean hasRope = false;

    public static boolean pickUp(int currentRoom, String itemString) {
         if (currentRoom == MoveRooms.windingRoom && (itemString.equalsIgnoreCase("map") || itemString.equalsIgnoreCase("old")) && !hasMap) {
            System.out.println("You pick up the old map. It contains a layout of the entire mine.");
            hasMap = true;
            return true;
        } else if (currentRoom == MoveRooms.toolStore && itemString.equalsIgnoreCase("rope") && !hasRope) {
            System.out.println("You pick up the rope. It looks long enough to reach the Shaft Top.");
            hasRope = true;
            return true;
        } else if (currentRoom == MoveRooms.entrance && (itemString.equalsIgnoreCase("helmet") || itemString.equalsIgnoreCase("lamp")) && !hasHelmet) {
            System.out.println("You pick up the spare helmet lamp. It seems that this could be given to someone.");
            hasHelmet = true;
            return true;
        } else {
            System.out.println("This item doesn't exist in this room.");
            return false;
        }
    }

    public static boolean drop(String itemString) {
        if (itemString.equalsIgnoreCase("key") && hasKey) {
            System.out.println("You decide not to drop the key, since the old miner entrusted it to you.");
            return false;
        } else if (itemString.equalsIgnoreCase("helmet") && hasHelmet) {
            System.out.println("You dropped the helmet lamp.");
            hasHelmet = false;
            return true;
        } else if (itemString.equalsIgnoreCase("lamp") && hasHelmet) {
            System.out.println("You dropped the helmet lamp.");
            hasHelmet = false;
            return true;
        } else if (itemString.equalsIgnoreCase("rope") && hasRope) {
            System.out.println("You dropped the rope.");
            hasRope = false;
            return true;
        } else if (itemString.equalsIgnoreCase("old") && hasMap) {
            System.out.println("You dropped the old map.");
            hasMap = false;
            return true;
        } else if (itemString.equalsIgnoreCase("map") && hasMap) {
            System.out.println("You dropped the old map.");
            hasMap = false;
            return true;
        }

        System.out.println("You aren't carrying an item like this.");
        return false;
    }
}
