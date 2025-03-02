package view;

import controller.CustomerController;
import model.Customer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerFrame extends JFrame {
    private JTextField nameField, phoneField, emailField;
    private JButton addButton, updateButton;

    public CustomerFrame() {
        setTitle("Customer Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);

        addButton = new JButton("Add Customer");
        updateButton = new JButton("Update Customer");


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(new JLabel("Email:"));
        add(emailField);
        add(addButton);
        add(updateButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();


                Customer customer = new Customer(0, 0, name, phone, email);
                boolean result = CustomerController.addCustomer(customer);

                if (result) {
                    JOptionPane.showMessageDialog(CustomerFrame.this, "Customer added successfully!");
                } else {
                    JOptionPane.showMessageDialog(CustomerFrame.this, "Failed to add customer.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();


                Customer customer = new Customer(1, 0, name, phone, email); // Assuming id = 1 for update
                boolean result = CustomerController.updateCustomer(customer);

                if (result) {
                    JOptionPane.showMessageDialog(CustomerFrame.this, "Customer updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(CustomerFrame.this, "Failed to update customer.");
                }
            }
        });

        setVisible(true);
    }
}
