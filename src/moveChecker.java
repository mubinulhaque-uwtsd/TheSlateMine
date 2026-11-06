

public class moveChecker {

    /*

    The checkMoveIsLegal function checks whether the player has made a valid move
    between rooms or not - if they haven't, false is returned to the move function, 
    else the move is valid and true is returned instead. 

    */

    public static boolean checkMoveIsLegal(int currentRoom, int direction) {

        // Checks whether the user's input is invalid - e.g. "left", "right" etc. 
        // instead of a legal direction
        if (direction < 0)
        {
            System.out.println("Your move was invalid - try again."); 
            return false;
        }
        // -1 indicates an invalid exit
        else if (MoveRooms.exits[currentRoom][direction] == -1)
        {
            return false;
        }// Checks whether the user moves to the locked Shaft Bottom
        else if (currentRoom == MoveRooms.mainTunnel && MoveRooms.exits[currentRoom][direction] == MoveRooms.shaftBottom && !shaftBottomUnlocked)
        {
            System.out.println("You rattle the gate, but it doesn't seem to budge. There seems to be a slot for a key, though.");
            return false;
        }
        // Checks whether the user moves to the Shaft Top without a rope attached
        else if (MoveRooms.exits[currentRoom][direction] == MoveRooms.shaftTop && !shaftTopAccessible)
        {
            System.out.println("The top of the shaft is too high up. That said, you could probably reach it with a rope of some kind.");
            return false;
        }

        return true;
    
    }

       

    private static boolean shaftBottomUnlocked = false;

    public static boolean unlockShaftBottom(int currentRoom) {
        if (Inventory.hasKey &&
            currentRoom == MoveRooms.mainTunnel) {

            shaftBottomUnlocked = true;
            return true;
        }
        return false;
    }

    public static boolean isShaftBottomUnlocked() {
        return shaftBottomUnlocked;
    }

    // reset method to prevent variable contamination during tests
    public static void resetShaftBottomUnlocked() {
    shaftBottomUnlocked = false;
    }

    private static boolean shaftTopAccessible = false;

    public static boolean useRopeOnShaftTop(int currentRoom) {
        if (Inventory.hasRope && currentRoom == MoveRooms.shaftBottom) {
            shaftTopAccessible = true;
            return true;
        }

        return false;
    }

    public static boolean isShaftTopAccessible() {
        return shaftTopAccessible;
    }

    public static void resetShaftTopAccessible() {
        shaftTopAccessible = false;
    }
}