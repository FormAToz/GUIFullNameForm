package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpandForm {
    private MainForm mainForm = new MainForm();
    private JPanel expandPanel;
    private JButton expandButton;
    private JTextField fullNameField;

    private String regex = "\\D+\\s\\D+";
    private Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    private Matcher matcher;

    public ExpandForm() {
        expandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // after expand button is pressed
                if (checkInput()) {
                    expandPanel.setVisible(false);
                    Frame.getFrame().setContentPane(mainForm.getMainPanel());
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
        expandPanel.setVisible(true);
        return expandPanel;
    }

    public void setText(String text) {
        fullNameField.setText(text);
    }

    private Boolean checkInput() {
        matcher = pattern.matcher(fullNameField.getText());
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
