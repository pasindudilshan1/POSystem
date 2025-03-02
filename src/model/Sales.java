package model;

public class Sales {
    private int id;
    private int customer_id;
    private String product_code;
    private int quantity;
    private double total_price;
    private String sale_date;


    public Sales(int id, int customer_id, String product_code, int quantity, double total_price, String sale_date) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_code = product_code;
        this.quantity = quantity;
        this.total_price = total_price;
        this.sale_date = sale_date;
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

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }
}
