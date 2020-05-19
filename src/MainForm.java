import javax.swing.*;
import java.awt.event.*;

public class MainForm {
    private JPanel mainPanel;
    private JButton expandButton;
    private JButton collapseButton;
    private JTextField surnameTextField;
    private JTextField firstnameTextField;
    private JTextField secondnameTextField;
    private JPanel collapsePanel;
    private JPanel buttonsPanel;
    private JPanel namedPanel;
    private JPanel centralPanel;
    private JLabel fullNameLabel;

    public MainForm() {
        expandButton.setVisible(false);
        namedPanel.setVisible(false);

        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasAllTextFields()) {
                    // after collapse button is pressed
                    collapseButton.setVisible(false);
                    expandButton.setVisible(true);

                    collapsePanel.setVisible(false);
                    namedPanel.setVisible(true);
                    fullNameLabel.setText(getFullName());
                }else {
                    JOptionPane.showMessageDialog(getMainPanel(),
                            "Введены не все данные",
                            "Ошибка",
                            2);
                }
            }
        });

        expandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // after expand button is pressed
                collapseButton.setVisible(true);
                expandButton.setVisible(false);

                collapsePanel.setVisible(true);
                namedPanel.setVisible(false);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private Boolean hasAllTextFields() {
        if (firstnameTextField.getText().length() == 0
                || secondnameTextField.getText().length() == 0
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
