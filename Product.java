public class Product {
    private int ProductID;
    private String ProductName;
    private String ProductDescription;
    private double ProductPrice;
    private int ProductQuantity;
    private String ProductStatus;
    private int SupplierID;
    public Product(int ProductID, String ProductName, String ProductDescription, double ProductPrice, int ProductQuantity, String ProductStatus, int SupplierID) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductDescription = ProductDescription;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
        this.ProductStatus = ProductStatus;
        this.SupplierID = SupplierID;
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

    public String getProductStatus() {
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

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    public void setSupplierID(int supplierID) {
        SupplierID = supplierID;
    }
}
