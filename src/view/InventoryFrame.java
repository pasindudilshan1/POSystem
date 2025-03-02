package view;

import controller.InventoryController;
import model.Product;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryFrame extends JFrame {
    private JTextField productCodeField, nameField, priceField, quantityField;
    private JButton addButton, updateButton, deleteButton;

    public InventoryFrame() {
        setTitle("Inventory Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        productCodeField = new JTextField(20);
        nameField = new JTextField(20);
        priceField = new JTextField(20);
        quantityField = new JTextField(20);

        addButton = new JButton("Add Product");
        updateButton = new JButton("Update Product");
        deleteButton = new JButton("Delete Product");


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Product Code:"));
        add(productCodeField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Price:"));
        add(priceField);
        add(new JLabel("Quantity:"));
        add(quantityField);
        add(addButton);
        add(updateButton);
        add(deleteButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String productCode = productCodeField.getText();
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());


                Product product = new Product(0, productCode, name, price, quantity);
                boolean result = InventoryController.addProduct(product);

                if (result) {
                    JOptionPane.showMessageDialog(InventoryFrame.this, "Product added successfully!");
                } else {
                    JOptionPane.showMessageDialog(InventoryFrame.this, "Failed to add product.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String productCode = productCodeField.getText();
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());


                Product product = new Product(0, productCode, name, price, quantity);
                boolean result = InventoryController.updateProduct(product);

                if (result) {
                    JOptionPane.showMessageDialog(InventoryFrame.this, "Product updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(InventoryFrame.this, "Failed to update product.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture user input for deletion
                String productCode = productCodeField.getText();
                Product product = new Product(0, productCode, null, 0.0, 0);

                boolean result = InventoryController.deleteProduct(product);
                if (result) {
                    JOptionPane.showMessageDialog(InventoryFrame.this, "Product deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(InventoryFrame.this, "Failed to delete product.");
                }
            }
        });

        setVisible(true);
    }
}
