package view;

import controller.SalesController;
import model.Customer;
import model.Sales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class POSFrame extends JFrame {
    private JTextField customerIdField, customerNameField, customerPhoneField, customerEmailField;
    private JTextField productCodeField, quantityField;
    private JButton recordSaleButton;

    public POSFrame() {
        setTitle("Point of Sale");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        customerIdField = new JTextField(20);
        customerNameField = new JTextField(20);
        customerPhoneField = new JTextField(20);
        customerEmailField = new JTextField(20);


        productCodeField = new JTextField(20);
        quantityField = new JTextField(20);

        recordSaleButton = new JButton("Record Sale");


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        add(new JLabel("Customer ID:"));
        add(customerIdField);
        add(new JLabel("Name:"));
        add(customerNameField);
        add(new JLabel("Phone:"));
        add(customerPhoneField);
        add(new JLabel("Email:"));
        add(customerEmailField);


        add(new JLabel("Product Code:"));
        add(productCodeField);
        add(new JLabel("Quantity:"));
        add(quantityField);

        add(recordSaleButton);


        recordSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int customerId = Integer.parseInt(customerIdField.getText());
                    String customerName = customerNameField.getText();
                    String customerPhone = customerPhoneField.getText();
                    String customerEmail = customerEmailField.getText();


                    Customer customer = new Customer(0, customerId, customerName, customerPhone, customerEmail);


                    String productCode = productCodeField.getText();
                    int quantity = Integer.parseInt(quantityField.getText());


                    Sales sale = new Sales(0, customerId, productCode, quantity, 0.0, "2025-02-22");


                    boolean result = SalesController.recordSale(sale, customer);

                    if (result) {
                        JOptionPane.showMessageDialog(POSFrame.this, "Sale recorded and customer handled successfully!");
                    } else {
                        JOptionPane.showMessageDialog(POSFrame.this, "Failed to record sale or handle customer.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(POSFrame.this, "Invalid input: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
