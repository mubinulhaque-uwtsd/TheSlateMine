public class itemtype {

   public static void Printitems() {
    
        if (Inventory.hasKey) {
            System.out.println("Key - label says gate to shaft bottom");
            
        }

        if (Inventory.hasMap) {
            System.out.println("Old map");
        }

        if (Inventory.hasHelmet) {
            System.out.println("Helmet lamp");
        }

        if(Inventory.hasRope){
            System.out.println("Rope - Seems strong enough to reach the top of the shaft");
        }
   }
    
}
