import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String Productfname = "ProductFile.txt";
        String Supplierfname = "SupplierFile.txt";
        String Inventoryfname = "InventoryFile.txt";
        try {
            Fileio.ReadSupplier(Supplierfname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}