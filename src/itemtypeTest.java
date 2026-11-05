import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class itemtypeTest {
    @Test
    void CheckRopeInList() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasRope, result.contains("Rope"));
    }

    @Test
    void CheckKeyInList() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasKey, result.contains("Key"));
    }

    @Test
    void CheckOldmapInList() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasMap, result.contains("Old map"));
    }

     @Test
    void CheckHelmetlampInList() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        itemtype.Printitems();
        String result = output.toString();
        assertEquals(Inventory.hasHelmet, result.contains("Helmet lamp"));
    }






}
