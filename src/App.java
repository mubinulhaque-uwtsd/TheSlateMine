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
}
