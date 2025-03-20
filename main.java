import java.util.ArrayList;

public class Main {
    public static void Printinventory(ArrayList<Inventory> Inventory){
        //sorts by product id
        for (Inventory e:Inventory){
            System.out.println(e.getProductID() + " " + e.getProductname() + " " + e.getQuantity() + " " + e.getPrice() + " " + e.getStatus() + " " + e.getSuppliername());
        }  
    }
    public static void SortbyProductID(ArrayList<Inventory> Inventory){
        //sorts by product id
        Inventory.sort((Inventory1, Inventory2) -> Inventory2.getProductID() - Inventory1.getProductID());

    }
    public static void main(String[] args) {
        ArrayList<Supplier> SupplierList = new ArrayList<Supplier>();
        ArrayList<Product> ProductsList = new ArrayList<Product>();
        ArrayList<Inventory> Inventory = new ArrayList<Inventory>();
        String Productfname = "ProductFile.txt";
        String Supplierfname = "SupplierFile.txt";
        String Inventoryfname = "InventoryFile.txt";
        try {
            Fileio.ReadProduct(Productfname,ProductsList);
            Fileio.ReadSupplier(Supplierfname,SupplierList);
            Inventory = Fileio.ConvertToInventory(SupplierList,ProductsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        SortbyProductID(Inventory);
        try {
            Fileio.writeInventoryFile(Inventoryfname,Inventory);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}