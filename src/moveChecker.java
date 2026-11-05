

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
        if (MoveRooms.exits[currentRoom][direction] == -1)
        {
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