import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static ArrayList<Inventory> ConvertToInventory(ArrayList<Supplier> SupplierList,ArrayList<Product> ProductsList) throws Exception{
        ArrayList<Inventory> InventoryList = new ArrayList<>();
        for (int i = 0; i < ProductsList.size(); i++) {
            Inventory NewInventory = new Inventory();
            //TODO: Fill in inventory object from Supplier and product objects from their arraylist and add Newinventory to InventoryList
        }
        return InventoryList;
    }



    public static void main(String[] args) {
        ArrayList<Supplier> SupplierList = new ArrayList<Supplier>();
        ArrayList<Product> ProductsList = new ArrayList<Product>();
        String Productfname = "ProductFile.txt";
        String Supplierfname = "SupplierFile.txt";
        String Inventoryfname = "InventoryFile.txt";
        try {
            Fileio.ReadProduct(Productfname,ProductsList);
            Fileio.ReadSupplier(Supplierfname,SupplierList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}