package controller;

import database.InventoryDAO;
import model.Product;

public class InventoryController {


    public static Product getProductByProductCode(String productCode) {
        return InventoryDAO.getProductByproduct_code(productCode);
    }

    public static boolean addProduct(Product product) {
        return InventoryDAO.addProduct(product);
    }

    public static boolean updateProduct(Product product) {
        return InventoryDAO.updateProduct(product);
    }

    public static boolean deleteProduct(Product product) {
        return InventoryDAO.deleteProduct(product);
    }
}
