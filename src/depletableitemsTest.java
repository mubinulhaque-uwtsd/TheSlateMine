
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class depletableitemsTest {
    
    @Test
    void KeyShouldBeDepleted() throws Exception {
        App.newGame();
        Inventory.hasKey = true;
        boolean result = depletableitems.depletable_items("key");

        assertTrue(result);
        assertFalse(Inventory.hasKey);
    }

    @Test
    void RopeShouldBeDepleted() throws Exception {
        App.newGame();
        Inventory.hasRope = true;
        boolean result = depletableitems.depletable_items("rope");
        
        assertTrue(result);
        assertFalse(Inventory.hasRope);
    }

    @Test
    void BothShouldBeDepleted() throws Exception {
        App.newGame();
        Inventory.hasKey = true;
        Inventory.hasRope = true;
        boolean result = depletableitems.depletable_items("key");
        boolean result2 = depletableitems.depletable_items("rope");
        assertTrue(result);
        assertTrue(result2);

    }

    @Test
    void InvalidItemShouldReturnFalse() throws Exception {
        App.newGame();
        boolean result = depletableitems.depletable_items("torch");

        assertFalse(result);
      
    }


}


