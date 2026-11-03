import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class TyperTests {
    @Test
    void checkGetCommand() {
        List<String> expected = new ArrayList<>();
        List<String> actual = Typer.getCommand("       move   dir  ");

        expected.add("move");
        expected.add("dir");
        
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }
}
