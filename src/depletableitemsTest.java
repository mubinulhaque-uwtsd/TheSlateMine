
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class depletableitemsTest {
    
    @Test
    void KeyShouldBeDepleted() throws Exception {
        boolean result = depletableitems.depletable_items("key");

        assertTrue(result);
        assertFalse(depletableitems.haskey);
    }

    @Test
    void RopeShouldBeDepleted() throws Exception {
        boolean result = depletableitems.depletable_items("rope");

        assertTrue(result);
        assertFalse(depletableitems.hasrope);
    }

    @Test
    void BothShouldBeDepleted() throws Exception {
        depletableitems.haskey = true;
        depletableitems.hasrope = true;
        boolean result = depletableitems.depletable_items("key");
        boolean result2 = depletableitems.depletable_items("rope");
        assertTrue(result);
        assertTrue(result2);

    }

    @Test
    void InvalidItemShouldReturnFalse() throws Exception {
        boolean result = depletableitems.depletable_items("torch");

        assertFalse(result);
      
    }


}


