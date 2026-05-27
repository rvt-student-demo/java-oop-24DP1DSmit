package rvt;

import javax.swing.JFrame;


public class todoui {
    private JFrame window;

    public todoui(){
        initialize();
    }

    private void initialize() {
        window = new JFrame();
        window.setTitle("Todo app");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1024, 768);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
    public void show() {
        window.setVisible(true);
    }
}
