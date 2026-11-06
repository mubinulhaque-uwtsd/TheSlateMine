public class depletableitems {
     

    public static boolean depletable_items(String item) {
        if(item.equalsIgnoreCase("key") && Inventory.hasKey)
        {
            Inventory.hasKey = false;
            return true;
        }
        else if(item.equalsIgnoreCase("rope")&& Inventory.hasRope)
        {
            Inventory.hasRope = false;
            return true;
        }
        return false;
    
        
    }
}
