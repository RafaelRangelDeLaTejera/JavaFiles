import java.util.concurrent.ArrayBlockingQueue;

public class CircularBufferCoefficients {

    private final ArrayBlockingQueue<double[]> bufferCoefficients; // shared buffer

    public CircularBufferCoefficients() {
        bufferCoefficients = new ArrayBlockingQueue<double[]>(1);} // shared buffer;

    // place coefficient values into buffer
    public void putCoefficients(double a,double b, double c)  throws InterruptedException{
        double[] coefficients = new double[]{a,b,c};
        bufferCoefficients.put(coefficients); // place value in buffer
    }

    // return value from buffer
    public double[] getCoefficients() throws InterruptedException{
        return bufferCoefficients.take();
    }
}