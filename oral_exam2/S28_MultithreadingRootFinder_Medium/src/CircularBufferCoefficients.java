import java.util.concurrent.ArrayBlockingQueue;

/**
 * Circular Buffer class to write the coefficients generated in the master class into the slave threads
 */
public class CircularBufferCoefficients {

    /**
     * private ArrayBlockingQueue to implement synchronization for us and store the array with the coefficients to be inserted into the slave threads
     */
    private final ArrayBlockingQueue<double[]> bufferCoefficients; // shared buffer

    /**
     * no argument constructor that sets the capacity to 1 to store one array
     */
    public CircularBufferCoefficients() {
        bufferCoefficients = new ArrayBlockingQueue<double[]>(1);} // shared buffer;

    /**
     * method to place coefficient values into buffer as an array to only call the put method once
     * @param a coefficient a of equation
     * @param b coefficient b of equation
     * @param c coefficient c of equation
     * @throws InterruptedException in case the coefficients cant be put on the buffer
     */
    public void putCoefficients(double a,double b, double c)  throws InterruptedException{
        double[] coefficients = new double[]{a,b,c};
        bufferCoefficients.put(coefficients); // place string in buffer
    }

    /**
     * method to get the coefficients from the buffer
     * @return the array that holds the coefficients in the buffer
     * @throws InterruptedException when the exception is generated from the take method called by the arrayBlocking queue
     */
    public double[] getCoefficients() throws InterruptedException{
        return bufferCoefficients.take();
    }
}