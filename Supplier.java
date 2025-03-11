public class Supplier {
    public String supplierName;
    public int supplierid;
    private String address;
    private String phone;
    private String email;
    public Supplier(String name,int id,String Address,String Phone,String Email) {
        this.supplierName = name;
        this.supplierid = id;
        this.address = Address;
        this.phone = Phone;
        this.email = Email;
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
