

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

        // Sets the lock mechanism for rooms that require the player to use items to move between them,
        // so the player cannot proceed without the required items. 
        if (currentRoom == MoveRooms.mainTunnel && direction == MoveRooms.getDirection("north") && !shaftBottomUnlocked)
        {
            System.out.println("The door to the shaft bottom is locked. Perhaps an item can open it ..?");
            return shaftBottomUnlocked;
        }
        else if (currentRoom == MoveRooms.shaftBottom && direction == MoveRooms.getDirection("up") && !shaftTopAccessible)
        {
           System.out.println("The shaft top is very high up. You'll need an item to climb this shaft!");
           return shaftTopAccessible;
        }

        return true;
        

    }

    public static boolean shaftBottomUnlocked = false;

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

    public static boolean shaftTopAccessible = false;

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