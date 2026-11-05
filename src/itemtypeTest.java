import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class itemtypeTest {
    @Test
    void CheckRopeInList() {
        App.newGame();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasRope, result.contains("Rope"));
    }

    @Test
    void CheckKeyInList() {
        App.newGame();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasKey, result.contains("Key"));
    }

    @Test
    void CheckOldmapInList() {
        App.newGame();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasMap, result.contains("Old map"));
    }

     @Test
    void CheckHelmetlampInList() {
        App.newGame();
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasHelmet, result.contains("Helmet lamp"));
    }






}
