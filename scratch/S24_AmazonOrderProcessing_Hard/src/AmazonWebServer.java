import java.io.*;
import java.util.Scanner;

public class AmazonWebServer implements Runnable {

    private BufferDemo outputBuffer;

    Path pathSource.get("orderList.csv")
    Scanner sc = new Scanner(new File("orderList.cv"));

    public AmazonWebServer(BufferDemo outputBuffer) {
        this.outputBuffer = outputBuffer;




//parsing a CSV file into Scanner class constructor

                sc.useDelimiter(",");   //sets the delimiter pattern
                while (sc.hasNext())  //returns a boolean value
                {
                    System.out.print(sc.next());  //find and returns the next complete token from this scanner
                }
                sc.close();  //closes the scanner



    }

    @Override
    public void run() {

    }
}
