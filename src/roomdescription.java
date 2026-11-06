import java.util.Scanner;

public class roomdescription {
    public static Scanner stdin = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    
}

public static String room_description(int room)
{
    String description = "";
    if(room == MoveRooms.entrance)
    {
        description = "You are standing at the entrance. It is dim and damp. You see a main tunnel ahead."; 
        if (!Inventory.hasHelmet) {
            description += " There is a dusty helmet lamp on the floor.";
        }
    }
    else if(room == MoveRooms.mainTunnel)
    {
        description = "You are standing at the main tunnel. The tunnel branches into different paths, a winding room to the left, and what looks like a storage room to the right. A bottom of a shaft is visible in front of you.";
    }
    else if(room == MoveRooms.lowerChamber)
    {
        description = "After climbing down the winding room, you arrive in a dark lower chamber. Seems like it doesn't go any further. There is an old miner here.";
        
        if (!Inventory.hasKey) {
            description += " There is a key in his hand, shining.";
        }
    }
    else if(room == MoveRooms.windingRoom)
    {
        description = "You are standing in the winding room. A hole in the ground leads down below.";

        if (!Inventory.hasMap) {
            description += " There is an old map here.";
        }
    }
    else if(room == MoveRooms.toolStore)
    {
        description = "You are standing in a tool store.";

        if (!Inventory.hasRope) {
            description += " There is a rope here.";
        }
    }
    else if(room == MoveRooms.shaftBottom)
    {
        description = "You are standing at a shaft bottom. Looking up, you see the top of the shaft.";
    }
    else if(room == MoveRooms.shaftTop)
    {
        description = "You are standing at the top of the shaft. Light peaks through.";
    }
    return description;
}

    public static void PrintDescription(int room)
    {

        System.out.printf("%s",room);

    }


}






