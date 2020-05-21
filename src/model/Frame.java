package model;

import javax.swing.*;

public class Frame {
    private static volatile JFrame frame;

    private  Frame() {}

    public static JFrame getFrame() {
        if (frame == null) {
            synchronized (Frame.class) {
                if (frame == null) {}
                frame = new JFrame();
            }
        }
        return frame;
    }
}
