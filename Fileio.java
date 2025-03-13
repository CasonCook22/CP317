import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Fileio {
    /*
    public static void Writefile (String fname,Inventory[]Inventory) throws Exception{
        PrintWriter outputFile;
        FileOutputStream fileHandle = new FileOutputStream(fname);//file named student2 is created
        outputFile = new PrintWriter(fileHandle);
        for (int i = 0; i < Inventory.length;i++){
            outputFile.print(Inventory[i]);//prints array to file
        }
        outputFile.close();
    }

     */
    public static void ReadSupplier(String Supplierfname,ArrayList<Supplier> SupplierList) throws Exception{
        try {
            // Pointer to file
            BufferedReader SupplierPointer = new BufferedReader(new InputStreamReader(new FileInputStream(Supplierfname)));
            while (SupplierPointer.ready()) {
                String dataItem = SupplierPointer.readLine();// Takes a look at what is there
                String[] input = (dataItem).split(",");// Splits input into array
                Supplier NewSupplier = new Supplier(Integer.parseInt(input[0]),input[1],input[2],input[3],input[4]);// uses array to make supplier obj
                SupplierList.add(NewSupplier);
            } // end while
        } // end of try
        catch (FileNotFoundException e) {
            System.out.println("Error - this file does not exist");
        } catch (IOException e) {
            System.out.println("Error - Opps" + e.toString());
        }
    }
    public static void ReadProduct(String Productfname,ArrayList<Product> ProductsList) throws Exception{
        try {
            // Pointer to file
            BufferedReader FilePointer = new BufferedReader(new InputStreamReader(new FileInputStream(Productfname)));
            while (FilePointer.ready()) {
                String dataItem = FilePointer.readLine();// Takes a look at what is there
                String[] input = (dataItem).split(",");// Splits input into array
                Product NewProduct = new Product(Integer.parseInt(input[0]),input[1],input[2],Double.parseDouble(input[3]),Integer.parseInt(input[4]),input[5],Integer.parseInt(input[6]));// uses array to make supplier obj
                ProductsList.add(NewProduct);
            } // end while
        } // end of try
        catch (FileNotFoundException e) {
            System.out.println("Error - this file does not exist");
        } catch (IOException e) {
            System.out.println("Error - Opps" + e.toString());
        }
    }
}
