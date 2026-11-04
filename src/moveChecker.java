

public class moveChecker {

    /*

    The checkMoveIsLegal function checks whether the player has made a valid move
    between rooms or not - if they haven't, false is returned to the move function, 
    else the move is valid and true is returned instead. 

    */

    public static boolean checkMoveIsLegal(int currentRoom, int direction) {

        // -1 indicates an invalid exit
        if (MoveRooms.exits[currentRoom][direction] == -1)
        {
            return false;
        }

        return true;
    }

}