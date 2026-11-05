import java.util.Scanner;

public class App {
    static final Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Intro
        System.out.println("A rockfall has sealed you inside an old slate mine in Eryri. The only way out is up the ventilation shaft, behind a gate.");
        System.out.println(roomdescription.room_description(0));
        boolean hasWon = false;

        // Main game loop
        while (!hasWon) {
            hasWon = Typer.command(stdin.nextLine());
        }

        // Outro
        System.out.println("After climbing the rope, you can feel the fresh air on your face. You are finally free.");
    }

    // Reset every variable to its default state
    public static void newGame() {
        // Empty the player's inventory
        Inventory.hasHelmet = false;
        Inventory.hasKey = false;
        Inventory.hasMap = false;
        Inventory.hasRope = false;

        // Move the player back to the entrance
        Typer.currentRoom = MoveRooms.entrance;

        // Reset the locked rooms
        moveChecker.resetShaftBottomUnlocked();
        moveChecker.resetShaftTopAccessible();
    }
}
