public class Inventory {
    public static boolean hasHelmet = false;
    public static boolean hasKey = false;
    public static boolean hasMap = false;
    public static boolean hasRope = false;

    public static boolean pickUp(int currentRoom, String itemString) {
        if (currentRoom == MoveRooms.lowerChamber && itemString.equalsIgnoreCase("key") && !hasKey) {
            System.out.println("You pick up the key. It says, \"Gate To Shaft Bottom\" on its label.");
            hasKey = true;
            return true;
        } else if (currentRoom == MoveRooms.windingRoom && (itemString.equalsIgnoreCase("map") || itemString.equalsIgnoreCase("old")) & !hasMap) {
            System.out.println("You pick up the old map. It contains a layout of the entire mine.");
            hasMap = true;
            return true;
        } else if (currentRoom == MoveRooms.toolStore && itemString.equalsIgnoreCase("rope") & !hasRope) {
            System.out.println("You pick up the rope. It looks long enough to reach the Shaft Top.");
            hasRope = true;
            return true;
        } else if (currentRoom == MoveRooms.entrance && (itemString.equalsIgnoreCase("helmet") || itemString.equalsIgnoreCase("lamp")) && !hasHelmet) {
            System.out.println("You pick up the spare helmet lamp. It seems that this could be given to someone.");
            hasHelmet = true;
            return true;
        } else {
            return false;
        }
    }

    public static boolean drop(String itemString) {
        if (itemString.equalsIgnoreCase("key") && hasKey) {
            hasKey = false;
            return true;
        } else if (itemString.equalsIgnoreCase("helmet") && hasHelmet) {
            hasHelmet = false;
            return true;
        } else if (itemString.equalsIgnoreCase("lamp") && hasHelmet) {
            hasHelmet = false;
            return true;
        } else if (itemString.equalsIgnoreCase("rope") && hasRope) {
            hasRope = false;
            return true;
        } else if (itemString.equalsIgnoreCase("old") && hasMap) {
            hasMap = false;
            return true;
        } else if (itemString.equalsIgnoreCase("map") && hasMap) {
            hasMap = false;
            return true;
        }

        return false;
    }
}
