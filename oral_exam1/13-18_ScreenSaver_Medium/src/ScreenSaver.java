import javax.swing.*;
import java.awt.*;

public class ScreenSaver extends JFrame {

    private final LineDrawer panel;

    public ScreenSaver() {

        super("Multiple line drawer cool eye effect screensaver");

        panel = new LineDrawer();
        panel.setBackground(Color.black);
        add(panel);


    }

}
