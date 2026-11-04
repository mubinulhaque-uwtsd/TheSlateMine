public class depletableitems {
     
    public static boolean haskey = true;
    public static boolean hasrope = true;
    public static boolean depletable_items(String item) {
        if(item.equalsIgnoreCase("key")&& haskey)
        {
            haskey = false;
            return true;
        }
        else if(item.equalsIgnoreCase("rope")&& hasrope)
        {
            hasrope = false;
            return true;
        }
        return false;
    
        
    }
}
