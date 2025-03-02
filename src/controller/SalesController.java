package controller;

import database.CustomerDAO;
import database.SalesDAO;
import model.Customer;
import model.Sales;

import java.sql.Connection;
import java.sql.SQLException;

public class SalesController {


    public static boolean recordSale(Sales sale, Customer customer) {

        Connection conn = null;
        try {
            conn = database.DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }


            conn.setAutoCommit(false);


            Customer existingCustomer = CustomerDAO.getCustomerById(customer.getCustomer_id());

            if (existingCustomer == null) {

                boolean customerAdded = CustomerDAO.addCustomer(customer);
                if (!customerAdded) {
                    System.out.println("Failed to add customer.");
                    conn.rollback();
                    return false;
                }
            } else {

                boolean customerUpdated = CustomerDAO.updateCustomer(customer);
                if (!customerUpdated) {
                    System.out.println("Failed to update customer.");
                    conn.rollback();
                    return false;
                }
            }


            boolean saleRecorded = SalesDAO.recordSale(sale);
            if (!saleRecorded) {
                System.out.println("Failed to record the sale.");
                conn.rollback();
                return false;
            }


            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
