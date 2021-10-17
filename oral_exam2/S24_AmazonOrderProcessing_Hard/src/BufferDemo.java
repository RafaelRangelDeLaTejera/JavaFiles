import java.util.concurrent.ArrayBlockingQueue;

public class BufferDemo {

    private final ArrayBlockingQueue<String> buffer;

    /**buffer constructor initializes buffer to ArrayBlockingQueue of Strings with capacity of 8 */
    public BufferDemo() {
        buffer = new ArrayBlockingQueue<String>( 8);
    }

    /** Put new information on the buffer to use as input buffer */
    public void blockingPut(String information) throws InterruptedException {
        buffer.put(information); // place value in buffer
    }

    /** Get and remove information from the buffer to use as output buffer */
    public String blockingGet() throws InterruptedException {
        String getInfo = buffer.take(); // remove value from buffer

        return getInfo;
    }

}
