import model.ExpandForm;
import model.Frame;
import model.MainForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var frame = Frame.getFrame();
        frame.setSize(500, 170);
        frame.setContentPane(new MainForm().getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
