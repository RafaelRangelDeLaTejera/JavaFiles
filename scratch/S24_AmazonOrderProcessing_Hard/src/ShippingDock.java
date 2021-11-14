import java.util.concurrent.ArrayBlockingQueue;

public class ShippingDock implements Runnable{
    private BufferDemo inputBuffer;
    private BufferDemo outputBuffer;

    public ShippingDock(BufferDemo inputBuffer, BufferDemo outputBuffer) {
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
    }

    @Override
    public void run() {

    }
}
