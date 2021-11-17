import java.util.concurrent.ArrayBlockingQueue;

public class CircularBufferRoots {

    private final ArrayBlockingQueue<String> buffer; // shared buffer

    public CircularBufferRoots() {
        buffer = new ArrayBlockingQueue<String>(2);
    }

    // place root values into buffer
    public void putRoots(String x1,String x2) throws InterruptedException {
        buffer.put(x1); // place value in buffer
        buffer.put(x2);
    }

    // return value from buffer
    public String getRoots() throws InterruptedException { //try without exception
        String getRoot = buffer.take();

        return getRoot;
    }
}
