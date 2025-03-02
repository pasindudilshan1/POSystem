package database;

import model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDAO {

    public static boolean recordSale(Sales sale) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed!");
            return false;
        }

        // Check if the customer_id exists in the customers table
        String checkCustomerQuery = "SELECT id FROM customers WHERE id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkCustomerQuery)) {
            checkStmt.setInt(1, sale.getCustomer_id());  // Check customer_id in customers table
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Customer with ID " + sale.getCustomer_id() + " does not exist.");
                return false; // Customer does not exist, return false
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Check if the product_code exists in the products table
        String checkProductQuery = "SELECT product_code FROM products WHERE product_code = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkProductQuery)) {
            checkStmt.setString(1, sale.getProduct_code());  // Check product_code in products table
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Product with code " + sale.getProduct_code() + " does not exist.");
                return false; // Product does not exist, return false
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Retrieve the price for the product from the products table
        double productPrice = 0.0;
        String getPriceQuery = "SELECT price FROM products WHERE product_code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(getPriceQuery)) {
            stmt.setString(1, sale.getProduct_code());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                productPrice = rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


        double totalPrice = sale.getQuantity() * productPrice;


        String query = "INSERT INTO sales (customer_id, product_code, quantity, total_price, sale_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sale.getCustomer_id());
            stmt.setString(2, sale.getProduct_code());
            stmt.setInt(3, sale.getQuantity());
            stmt.setDouble(4, totalPrice);
            stmt.setString(5, sale.getSale_date());

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
