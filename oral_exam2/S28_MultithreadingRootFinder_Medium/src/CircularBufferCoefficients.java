import java.nio.Buffer;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class CircularBufferCoefficients {
    private final ArrayBlockingQueue<Double> buffer; // shared buffer

    public CircularBufferCoefficients() {
        buffer = new ArrayBlockingQueue<Double>(3);
    }

    // place coefficient values into buffer
    public void putCoefficients(double a,double b,double c) throws InterruptedException {
        buffer.put(a); // place value in buffer
        buffer.put(b);
        buffer.put(c);
    }

    // return value from buffer
    public double getCoefficients() throws InterruptedException { //try without exception
        double getCoefficient = buffer.take();

        return getCoefficient;
    }
}
