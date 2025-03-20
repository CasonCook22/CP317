public class Inventory {
    private int ProductID;
    private String Productname;
    private int Quantity;
    private double Price;
    private char Status;
    private String Suppliername;
    public Inventory(int Id,String Productname,int Quantity,double Price,char Status,String Suppliername) {
        this.ProductID = Id;
        this.Productname = Productname;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Status = Status;
        this.Suppliername = Suppliername;
    }
    public Inventory(){
        this.ProductID = 0;
        this.Productname = "";
        this.Quantity = 0;
        this.Price = 0.0;
        this.Status = '\0';
        this.Suppliername = "";
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setStatus(char status) {
        Status = status;
    }

    public void setSuppliername(String suppliername) {
        Suppliername = suppliername;
    }

    public double getPrice() {
        return Price;
    }

    public int getProductID() {
        return ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getProductname() {
        return Productname;
    }

    public char getStatus() {
        return Status;
    }

    public String getSuppliername() {
        return Suppliername;
    }
}
