import java.util.ArrayList;
import java.util.List;

public class Typer {
    static int currentRoom = 0;
    
    // Separates each word of a command
    public static List<String> getCommand(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        
        for (char c : chars) {
            if (Character.isWhitespace(c) && !sb.isEmpty()) {
                // If this character is white space, and the string builder has no new characters
                words.add(sb.toString());
                sb = new StringBuilder();
            } else if (!Character.isWhitespace(c)) {
                // If the character is not white space
                sb.append(c);
            }
        }

        if (!sb.isEmpty()) {
            words.add(sb.toString());
        }

        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).toLowerCase());
        }

        return words;
    }

    public static boolean command(String input) {
        List<String> command = getCommand(input);
        
        if (command.get(0).equalsIgnoreCase("quit")) {
            // If the player wants to quit
            System.out.println();
            System.exit(0);
        } else if (command.get(0).equalsIgnoreCase("move")) {
            // If the player wants to move in a direction
            if (command.size() > 1) {
                // If the player gave a direction
                int direction = MoveRooms.getDirection(command.get(1));
                boolean isLegal = moveChecker.checkMoveIsLegal(currentRoom, direction);

                if (direction >= 0 && isLegal) {
                    // If the direction is valid
                    currentRoom = MoveRooms.move(currentRoom, direction);

                    System.out.printf(roomdescription.room_description(currentRoom));
                } else if (direction >= 0 && !isLegal) {
                    System.out.println("You cannot move in this directon.");
                }
            } else {
                // If the player didn't give a direction
                System.out.println("You must specify a direction.");
            }
        } else if (command.get(0).equalsIgnoreCase("inspect")) {
            // If the player wants to inspect something
        } else if (command.get(0).equalsIgnoreCase("pick") && command.get(1).equalsIgnoreCase("up")) {
            // If the player wants to pick up an object
        } else if (command.get(0).equalsIgnoreCase("drop")) {
            // If the player wants to drop an object
        } else if (command.get(0).equalsIgnoreCase("list")) {
            // If the player wants to list their picked-up objects
        } else if (command.get(0).equalsIgnoreCase("help")) {
            // If the player wants to get some help
            System.out.println("Commands available:");
            System.out.println("'help': Lists all available commands");
            System.out.println("'drop <object>': Removes the specified object from your inventory, and leaves it in the current room");
            System.out.println("'inspect <object>': Provides a description of the given room or object");
            System.out.println("'list': Lists all objects currently in your inventory");
            System.out.println("'move <direction>': Moves you either north, east, south, west, up, or down, when specified");
            System.out.println("'pick up <object>': Stores a specified object in your inventory, and removes it from the room");
            System.out.println("'quit': Quits the game");
        }
        
        System.out.println("");
        return completegame.IsGameComplete(currentRoom);
    }
}
