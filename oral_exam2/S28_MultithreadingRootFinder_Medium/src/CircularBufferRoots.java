import java.util.concurrent.ArrayBlockingQueue;

public class CircularBufferRoots {

    private final ArrayBlockingQueue<String[]> bufferRoots; // shared buffer

    public CircularBufferRoots() {
        bufferRoots = new ArrayBlockingQueue<String[]>(1);
    }

    // place root values into buffer
    public void putRoots(String x1,String x2)  throws InterruptedException{
        System.out.print("putting roots\n");
        String[] roots = new String[]{x1,x2};

            bufferRoots.put(roots); // place value in buffer

    }

    // return value from buffer
    public String[] getRoots() throws InterruptedException { //try without exception
System.out.print("getting roots\n");
        return  bufferRoots.take();
      }

    }

