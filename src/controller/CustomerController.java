package controller;

import database.CustomerDAO;
import model.Customer;

public class CustomerController {


    public static boolean addCustomer(Customer customer) {
        return CustomerDAO.addCustomer(customer);
    }


    public static Customer getCustomerById(int id) {
        return CustomerDAO.getCustomerById(id);
    }


    public static boolean updateCustomer(Customer customer) {
        return CustomerDAO.updateCustomer(customer);
    }
}
