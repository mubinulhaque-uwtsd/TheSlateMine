public class depletableitems {
     

    public static boolean depletable_items(String item) {
        if(item.equalsIgnoreCase("key") && Inventory.hasKey)
        {
            Inventory.hasKey = false;
            System.out.printf("You cannot use the key anymore");
            return true;
        }
        else if(item.equalsIgnoreCase("rope")&& Inventory.hasRope)
        {
            Inventory.hasRope = false;
            System.out.printf("You cannot use the rope anymore");
            return true;
        }
        return false;
    
        
    }
}
