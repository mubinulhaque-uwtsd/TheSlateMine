import java.util.ArrayList;
import java.util.List;

public class Typer {
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

        return words;
    }
}
