import java.util.ArrayList;
import java.util.List;

public class Typer {
    static final String[] commands = {
        "move",
        "inspect",
        "pick",
        "talk"
    };

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

        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).toLowerCase());
        }

        return words;
    }

    public static void command(String input) {
        List<String> command = getCommand(input);

        if (command.get(0).equalsIgnoreCase(commands[0])) {
            // If the player wants to move in a direction
        } else if (command.get(0).equalsIgnoreCase(commands[1])) {
            // If the player wants to inspect something
        } else if (command.get(0).equalsIgnoreCase(commands[2])) {
            // If the player wants to pick up an object
        } else if (command.get(0).equalsIgnoreCase(commands[3])) {
            // If the player wants to talk to someone
        }
    }
}
