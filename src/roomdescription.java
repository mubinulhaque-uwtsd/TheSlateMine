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
        description = "You are standing at the entrance. It is dim and damp."; 
        if (!Inventory.hasHelmet) {
            description += " There is a helmet lamp here.";
        }
    }
    else if(room == MoveRooms.mainTunnel)
    {
        description = "You are standing at the main tunnel.";
    }
    else if(room == MoveRooms.lowerChamber)
    {
        description = "You are standing at the lower chamber. There is an old miner here.";
        
        if (!Inventory.hasKey) {
            description += " He is holding something shiny.";
        }
    }
    else if(room == MoveRooms.windingRoom)
    {
        description = "You are standing in the winding room.";

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
        description = "You are standing at a shaft bottom";
    }
    else if(room == MoveRooms.shaftTop)
    {
        description = "You are standing at the shaft top";
    }
    return description;
}

    public static void PrintDescription(int room)
    {

        System.out.printf("%s",room);

    }


}






