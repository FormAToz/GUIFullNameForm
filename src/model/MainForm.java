package model;

import javax.swing.*;
import java.awt.event.*;

public class MainForm {
    private static ExpandForm expandForm = new ExpandForm();
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextField surnameTextField;
    private JTextField firstnameTextField;
    private JTextField secondnameTextField;
    private JPanel collapsePanel;
    private JPanel buttonsPanel;
    private JPanel namedPanel;
    private JPanel centralPanel;

    public MainForm() {
        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasAllTextFields()) {
                    // after collapse button is pressed
                    mainPanel.setVisible(false);
                    expandForm.setText(getFullName());
                    Frame.getFrame().setContentPane(expandForm.getMainPanel());
                }else {
                    JOptionPane.showMessageDialog(getMainPanel(),
                            "Введены не все данные",
                            "Ошибка",
                            2);
                }
            }
        });
    }

    public JPanel getMainPanel() {
        mainPanel.setVisible(true);
        return mainPanel;
    }

    private Boolean hasAllTextFields() {
        if (firstnameTextField.getText().length() == 0
                || surnameTextField.getText().length() == 0) {
            return false;
        }
        return true;
    }

    private String getFullName() {
        if (hasAllTextFields()) {
            StringBuilder sb = new StringBuilder();
            sb.append(surnameTextField.getText())
                    .append(" ")
                    .append(firstnameTextField.getText())
                    .append(" ")
                    .append(secondnameTextField.getText());
            return sb.toString();
        }
        return "";
    }
}
