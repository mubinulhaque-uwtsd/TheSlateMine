public class Inventory {
    public static boolean hasHelmet = false;
    public static boolean hasKey = false;
    public static boolean hasMap = false;
    public static boolean hasRope = false;

    public static boolean pickUp(int currentRoom, String itemString) {
        if (currentRoom == MoveRooms.lowerChamber && itemString == "key" && !hasKey) {
            System.out.println("You pick up the key. It says, \"Gate To Shaft Bottom\" on its label.");
            hasKey = true;
            return true;
        } else if (currentRoom == MoveRooms.windingRoom && (itemString == "map" || itemString == "old") && !hasMap) {
            System.out.println("You pick up the old map. It contains a layout of the entire mine.");
            hasMap = true;
            return true;
        } else if (currentRoom == MoveRooms.toolStore && itemString == "rope" && !hasRope) {
            System.out.println("You pick up the rope. It looks long enough to reach the Shaft Top.");
            hasRope = true;
            return true;
        } else if (currentRoom == MoveRooms.entrance && (itemString == "helmet" || itemString == "lamp") && !hasHelmet) {
            System.out.println("You pick up the spare helmet lamp. It seems that this could be given to someone.");
            hasRope = true;
            return true;
        } else {
            return false;
        }
    }
}
