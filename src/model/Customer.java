package model;

public class Customer {
    private int id;
    private int customer_id;
    private String name;
    private String phone;
    private String email;

    public Customer(int id, int customer_id, String name, String phone, String email) {
        this.id = id;
        this.customer_id = customer_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter and Setter methods for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
