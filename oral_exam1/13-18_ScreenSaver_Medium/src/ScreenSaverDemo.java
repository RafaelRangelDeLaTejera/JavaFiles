import javax.swing.*;

public class ScreenSaverDemo {
    public static void main(String[] args) {
        ScreenSaver screenSaver = new ScreenSaver();
        screenSaver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSaver.setSize(1000, 800);
        screenSaver.setVisible(true);
    }
}
