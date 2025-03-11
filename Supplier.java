public class Supplier {
    private String supplierName;
    private int supplierid;
    private String address;
    private String phone;
    private String email;
    public Supplier(int id,String name,String Address,String Phone,String Email) {
        this.supplierid = id;
        this.supplierName = name;
        this.address = Address;
        this.phone = Phone;
        this.email = Email;
    }
    public Supplier() {
        this.supplierid = 0;
        this.supplierName = "";
        this.address = "";
        this.phone = "";
        this.email = "";
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
