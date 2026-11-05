import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OldMapTest {

@Test // check whether map header is printed
public void testPrintMapShowsHeader() {
    App.newGame();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    OldMap.printMap(MoveRooms.entrance);

    String result = output.toString();

    assertTrue(result.contains("Old Mine Map"));
}

@Test // test to see if current room is displayed.
public void testPrintMapShowsCurrentRoom() {
        App.newGame();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    OldMap.printMap(MoveRooms.entrance);

    String result = output.toString();

    assertTrue(result.contains("You are currently in:"));
}

@Test // test to see if entrance room appears on map
public void testMapContainsEntrance() {
        App.newGame();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    OldMap.printMap(MoveRooms.entrance);

    String result = output.toString();

    assertTrue(result.contains("[Entrance]"));
}

@Test // test to see that all rooms are printed
public void testMapContainsAllRooms() {
        App.newGame();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    OldMap.printMap(MoveRooms.entrance);

    String result = output.toString();

    assertTrue(result.contains("[Entrance]"));
    assertTrue(result.contains("[Main Tunnel]"));
    assertTrue(result.contains("[Tool Store]"));
    assertTrue(result.contains("[Winding Room]"));
    assertTrue(result.contains("[Lower Chamber]"));
    assertTrue(result.contains("[Shaft Bottom]"));
    assertTrue(result.contains("[Shaft Top]"));
}

@Test // test to see if the current room changes.
public void testCurrentRoomChanges() {
        App.newGame();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    OldMap.printMap(MoveRooms.toolStore);

    String result = output.toString();

    assertTrue(result.contains("You are currently in: [Tool Store]"));
}
}