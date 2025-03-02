package database;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDAO {
    public static Product getProductByproduct_code(String product_code) {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM products WHERE product_code = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, product_code);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("product_code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")

                );
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addProduct(Product product) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection dfail!!");

        }




        String query = "INSERT INTO products (product_code,name,price,quantity) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getProduct_code());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            int result = stmt.executeUpdate();

            return result > 0;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }


    }

    public static boolean updateProduct(Product product) {
        Connection conn = DatabaseConnection.getConnection();

        if (conn == null) {
            System.out.println("database connection faild");
            return false;
        }
        String query = "UPDATE product SET name = ?, price =?, quantity = ? WHERE product_code = ? ";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2,product.getPrice());
            stmt.setInt(3,product.getQuantity());
            stmt.setString(4, product.getProduct_code());
            int result = stmt.executeUpdate();
            return result > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }


        }
    public static boolean deleteProduct(Product product){
        Connection conn =DatabaseConnection.getConnection();

        if (conn == null){
            System.out.println("Database connection failed!");
            return false;
        }
        String query = "DELETE product WHERE product_code = ?";

        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString( 1, product.getProduct_code());


            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }



    }


}






