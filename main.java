import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            File InventoryFile = new File("InventoryFile.txt");
            File ProductFile = new File("ProductFile.txt");
            File SupplierFile = new File("SupplierFile.txt");
            Scanner InventoryReader = new Scanner(InventoryFile);
            Scanner ProductReader = new Scanner(ProductFile);
            Scanner SupplierReader = new Scanner(SupplierFile);


            InventoryReader.close();
            ProductReader.close();
            SupplierReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}