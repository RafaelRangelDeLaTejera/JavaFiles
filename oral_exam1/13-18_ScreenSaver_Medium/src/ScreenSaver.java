import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class ScreenSaver extends JFrame {

    //private int count = 0;

    private final LineDrawer panel;

    public ScreenSaver() {

        super("Using a JDesktopPane");

        panel = new LineDrawer();
        panel.setBackground(Color.black);

            add(panel);


    }



//    public int randomCoordinateGenerator(){
//        int coordinate = (Math.random() *10) + 1;
//    }
}
