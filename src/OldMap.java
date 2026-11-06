public class OldMap {
    public static void printMap(int currentRoom) {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("                Old Mine Map");
        System.out.println("==========================================");
        System.out.println();
        System.out.println("                " + roomLabel(MoveRooms.shaftTop, currentRoom));
        System.out.println("                     ↑");
        System.out.println("                     |");
        System.out.println("               " + roomLabel(MoveRooms.shaftBottom, currentRoom));
        System.out.println("                     |");
        System.out.println("                     |");
        System.out.println(roomLabel(MoveRooms.windingRoom, currentRoom) + "--" + roomLabel(MoveRooms.mainTunnel, currentRoom) + "--" + roomLabel(MoveRooms.toolStore, currentRoom));
        System.out.println("       |             |");
        System.out.println("       ↓             |");
        System.out.println(roomLabel(MoveRooms.lowerChamber, currentRoom) + " " + roomLabel(MoveRooms.entrance, currentRoom));
        System.out.println();
        System.out.println("==========================================");
        System.out.println();
        System.out.printf("You are currently in: %s", roomLabel(currentRoom, currentRoom));
    }
    
    private static String roomLabel(int room, int currentRoom) {
        String roomName = MoveRooms.getRoom(room);
        return "[" + roomName + "]";
    }
}
