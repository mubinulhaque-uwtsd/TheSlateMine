public class MoveRooms {

    // Direction constants used as indexes in the exits array.
    public static final int north = 0;
    public static final int east = 1;
    public static final int south = 2;
    public static final int west = 3;
    public static final int up = 4;
    public static final int down = 5;

    // Room constants used to identify each room in the cave.
    public static final int entrance = 0;
    public static final int mainTunnel = 1;
    public static final int windingRoom = 2;
    public static final int lowerChamber = 3;
    public static final int toolStore = 4;
    public static final int shaftBottom = 5;
    public static final int shaftTop = 6;

    // Stores the available exits for each room.

    // Row = room
    // Column = direction (N, E, S, W, U, D).

    // A value of -1 indicates that no exit exists in that direction.
    static int[][] exits = {
        // N  E  S  W  U  D
        { 1,-1,-1,-1,-1,-1 }, // Entrance
        { 5, 4, 0, 2,-1,-1 }, // Main Tunnel
        {-1, 1,-1,-1,-1, 3 }, // Winding Room
        {-1,-1,-1,-1, 2,-1 }, // Lower Chamber
        {-1,-1,-1, 1,-1,-1 }, // Tool Store
        {-1,-1, 1,-1, 6,-1 }, // Shaft Bottom
        {-1,-1,-1,-1,-1, 5 }  // Shaft Top
    };

    /**
     * Returns the room reached by moving in the specified direction.
     * Returns -1 if the room number or direction is invalid.
     */
    public static int move(int room, int direction) {

        // Make sure the supplied room number exists.
        if (room < 0 || room >= exits.length) {
            return -1;
        }

        // Make sure the supplied direction is valid.
        if (direction < 0 || direction >= exits[room].length) {
            return -1;
        }

        // Return the destination room for the chosen direction.
        return exits[room][direction];
    }
}
