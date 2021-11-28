import java.util.concurrent.ArrayBlockingQueue;

/**
 * circular buffer class to get the solved roots from the slave threads and insert them into the master class
 */
public class CircularBufferRoots {

    /**
     * ArrayBlockingQueue to hold an array of strings with the root string values
     */
    private final ArrayBlockingQueue<String[]> bufferRoots; // shared buffer

    /**
     * no argument constructor that sets the capacity of the blocking buffer to 1, so it just holds the array with the roots
     */
    public CircularBufferRoots() {
        bufferRoots = new ArrayBlockingQueue<String[]>(1);
    }

    /**
     * method to place the root values into the buffer
     * @param x1 solved root 1
     * @param x2 solved toot 2
     * @throws InterruptedException when the put method from the blocking buffer throws an exception
     */
    public void putRoots(String x1,String x2)  throws InterruptedException{
        String[] roots = new String[]{x1,x2};
        bufferRoots.put(roots); // place value in buffer

    }

    /**
     * method to get the roots array holding the solved roots as strings
     * @return the array with the solved roots as strings
     * @throws InterruptedException when the take method from the blocking buffer throws an exception
     */
    public String[] getRoots() throws InterruptedException { //try without exception
        return  bufferRoots.take();
      }

    }

