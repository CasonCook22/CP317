import java.io.*;
import java.util.ArrayList;

/**
 * Fileio class to read and write data to and from text files
 */
public class Fileio {
    /**
     * Validates a Validatable object
     * @param item The object to validate
     * @throws Exception if the object is invalid
     */
    private static void validateItem(Validatable item) throws Exception {
        item.validate();
    }
    /**
     * Reads supplier data from txt file
     * @param Supplierfname The name of the file to read
     * @param SupplierList List of suppliers to add to
     * @return Inventory object containing supplier data
     * @throws Exception if file cannot be read
     */
    public static void ReadSupplier(String Supplierfname,ArrayList<Supplier> SupplierList) throws Exception{
        if (!Supplierfname.toLowerCase().endsWith(".txt")) {
            throw new Exception("Unsupported file type. Must be a text file (.txt).");
        }
        File file = new File(Supplierfname);
        if (!file.exists()) {
            throw new Exception("Supplier file not found: " + Supplierfname);
        }


        try (BufferedReader SupplierPointer = new BufferedReader(new InputStreamReader(new FileInputStream(Supplierfname)))) {
            // Pointer to file
            int lineNumber = 0;
            while (SupplierPointer.ready()) {
                String dataItem = SupplierPointer.readLine();// Takes a look at what is there
                String[] input = (dataItem).split(",");// Splits input into array
                if (input.length < 5) {
                    System.out.println("Warning: Skipping invalid supplier at line " + lineNumber);
                    continue;
                }
                try {
                    Supplier NewSupplier = new Supplier(Integer.parseInt(input[0]),input[1],input[2],input[3],input[4]);// uses array to make supplier obj
                    // Validate supplier data
                    try {
                        validateItem(NewSupplier);
                        SupplierList.add(NewSupplier);
                    } catch (Exception e) {
                        System.out.println("Warning: Skipping line. Invalid supplier data at line " + lineNumber + ": " + e.getMessage());
                    }
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Skipping line. Invalid supplier ID at line " + lineNumber + ": " + Integer.parseInt(input[0]) + " - " + e.getMessage()); 
                        continue;
                    }              
                lineNumber++;
            } // end while
            SupplierPointer.close();
        } // end of try
        catch (IOException e) {
            throw new Exception("Error reading supplier file: " + e.getMessage());
        }
    }


    /**
     * Reads product data from txt file
     * @param Productfname the name of product file to read
     * @param ProductsList List of produts to add to
     * @throws Exception if file there is an error reading file
     */
    public static void ReadProduct(String Productfname,ArrayList<Product> ProductsList) throws Exception{
        if (!Productfname.toLowerCase().endsWith(".txt")) {
            throw new Exception("Unsupported file type. Must be a text file (.txt).");
        }

        // Check if file exists
        File file = new File(Productfname);
        if (!file.exists()) {
            throw new Exception("Product file not found: " + Productfname);
        }

        try (BufferedReader ProductPointer = new BufferedReader(new InputStreamReader(new FileInputStream(Productfname)))) {
            // Pointer to file
            
            int lineNumber = 0;
            while (ProductPointer.ready()) {
                String dataItem = ProductPointer.readLine();// Takes a look at what is there
                if (dataItem.trim().isEmpty()) {
                    continue;
                }
                String[] input = (dataItem).split(",");// Splits input into array
                if (input.length < 7) {
                    System.out.println("Warning: Skipping invalid line at line " + lineNumber + ". Expected 7 fields, found " + input.length);
                    continue;
                }
                int ID = Integer.parseInt(input[0].trim());
                String name = input[1].trim();
                String Description = input[2].trim();
                String priceStr = input[3].trim().replace("$", "");
                double Price = Double.parseDouble(priceStr);
                int Quantity = Integer.parseInt(input[4].trim());
                char Status = input[5].trim().charAt(0);
                int SupplierID = Integer.parseInt(input[6].trim());
                Product NewProduct = new Product(ID,name,Description,Price,Quantity,Status,SupplierID);
                // Validate product data
                try {
                    validateItem(NewProduct);
                } catch (Exception e) {
                    System.out.println("Warning: Skipping line. Invalid product data at line " + lineNumber + ": " + e.getMessage());
                    continue;
                }
                ProductsList.add(NewProduct);
            } // end while
            lineNumber++;
            ProductPointer.close();
        } // end of try
         catch (IOException e) {
            System.out.println("Error - Opps" + e.toString());
        }
    }

    /*
     * @param SupplierList List of suppliers to convert to inventory
     * @param ProductsList List of products to convert to inventory
     * @return Inventory List containing Invetory data
     */
    public static ArrayList<Inventory> ConvertToInventory(ArrayList<Supplier> SupplierList,ArrayList<Product> ProductsList){
        ArrayList<Inventory> InventoryList = new ArrayList<>();
        for (int i = 0; i < ProductsList.size(); i++) {
            Inventory NewInventory = new Inventory();
            NewInventory.setProductID(ProductsList.get(i).getSupplierID());
            NewInventory.setProductname(ProductsList.get(i).getProductName());
            NewInventory.setPrice(ProductsList.get(i).getProductPrice());
            NewInventory.setQuantity(ProductsList.get(i).getProductQuantity());
            NewInventory.setStatus((ProductsList.get(i).getProductStatus()));
            for (int j = 0; j < SupplierList.size(); j++) {
                if (ProductsList.get(i).getSupplierID() == SupplierList.get(j).getSupplierid()) {
                    NewInventory.setSuppliername(SupplierList.get(j).getSupplierName());
                    InventoryList.add(NewInventory);
                }
            }
        }
        return InventoryList;
    }


     /**
     * Helper method to limit string length for formatting
     * @param input The string to limit
     * @param maxLength The maximum length of the string
     * @return The limited string
     */
    private static String limitString(String input, int maxLength) {
        if (input == null) {
            return "";
        }
        return input.length() <= maxLength ? input : input.substring(0, maxLength - 3) + "...";
    }  

    /**
     * Writes the inventory data to a text file in the required format
     * @param filename The name of the file to write
     * @param inventory ArrayList of The inventory containing individual products product and supplier information
     * @throws Exception If there is an error writing the file
     */
    public static void writeInventoryFile(String filename, ArrayList<Inventory> Inventory) throws Exception {
        // Verify file extension
        if (!filename.toLowerCase().endsWith(".txt")) {
            System.err.println("Error: Unsupported output file format. Only .txt files are supported.");
            filename = filename + ".txt";
            System.out.println("Using modified output filename: " + filename);
        }
        
        try {
            // Create the writer
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                // Write header row
                writer.printf("%-10s %-15s %-10s %-10s %-10s %-20s\n", 
                             "Product ID", "Product Name", "Quantity", "Price", "Status", "Supplier name");
                writer.println("-------------------------------------------------------------------------");
                
                // Write product data
                for (Inventory item : Inventory) {
                    // Get the supplier for this product
                    writer.printf("%-10d %-15s %-10d %-10.1f %-10c %-20s\n", 
                                item.getProductID(), 
                                limitString(item.getProductname(), 15), 
                                item.getQuantity(), 
                                item.getPrice(), 
                                item.getStatus(),
                                limitString(item.getSuppliername(), 20));
                }
            }
            
            System.out.println("Successfully wrote " + Inventory.size() + " products to " + filename);
            
        } catch (IOException e) {
            throw new Exception("Error writing inventory file: " + e.getMessage());
        }
    }
}
