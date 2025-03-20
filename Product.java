public class Product {
    private int ProductID;
    private String ProductName;
    private String ProductDescription;
    private double ProductPrice;
    private int ProductQuantity;
    private char ProductStatus;
    private int SupplierID;
    public Product(int ProductID, String ProductName, String ProductDescription, double ProductPrice, int ProductQuantity, char ProductStatus, int SupplierID) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductDescription = ProductDescription;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
        this.ProductStatus = ProductStatus;
        this.SupplierID = SupplierID;
    }
    public boolean validate() throws Exception {
        if (this.ProductID <= 0) {
           throw new Exception("Product ID must be a positive number");
        } else if (this.ProductName != null && !this.ProductName.trim().isEmpty()) {
           if (this.ProductPrice <= 0.0) {
              throw new Exception("Product price must be positive");
           } else if (this.ProductQuantity < 0) {
              throw new Exception("Product quantity cannot be negative");
           } else if (this.ProductStatus != 'A' && this.ProductStatus != 'B' && this.ProductStatus != 'C') {
              throw new Exception("Product quality must be A, B, or C");
           } else if (this.SupplierID <= 0) {
              throw new Exception("Supplier ID must be a positive number");
           } else {
              return true;
           }
        } else {
           throw new Exception("Product type cannot be empty");
        }
    }

    public int getProductID() {
        return ProductID;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public String getProductName() {
        return ProductName;
    }

    public char getProductStatus() {
        return ProductStatus;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public void setProductStatus(char productStatus) {
        ProductStatus = productStatus;
    }

    public void setSupplierID(int supplierID) {
        SupplierID = supplierID;
    }
}
