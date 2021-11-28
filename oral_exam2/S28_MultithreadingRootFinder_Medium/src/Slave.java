import java.util.HashMap;

/**
 * slave class implements the runnable interface to work as a slave thread
 */
public class Slave implements Runnable{

    /**
     * circular buffer to serve to insert the coefficients generated in the master thread into this thread
     */
    private final CircularBufferCoefficients sharedBufferCoefficients;

    /**
     * circular buffer to insert the solved roots from the slave class into the master thread
     */
    private final CircularBufferRoots sharedBufferRoots;

    /**
     * value for to holds the slave thread number
     */
    private int slaveNo;

    /**
     * hash map to hold the slave thread number and the number of equations it has solved, it is static since this will keep track of the total number of slaves created and the number
     * of equations each has solved
     */
    private static HashMap<Integer,Integer> slaveThreads = new HashMap<>();

    /**
     * constructor that assigns the circular buffers for communication with main thread and also the slave number
     * @param circularBufferCoefficients circular buffer to insert the coefficients from the main thread to this slave thread
     * @param sharedBufferRoots circular buffer to insert the solved roots to the main thread
     * @param slaveNo slave thread number to distinguish it
     */
    public Slave(CircularBufferCoefficients circularBufferCoefficients, CircularBufferRoots sharedBufferRoots, int slaveNo) {
        this.sharedBufferCoefficients = circularBufferCoefficients;
        this.sharedBufferRoots = sharedBufferRoots;
        this.slaveNo = slaveNo;
        slaveThreads.put(slaveNo,0);
    }

    /**
     * overridden run method to solve the sets of coefficients that are inserted by the buffer and then pu the solved roots into the circularBufferRoots to insert them
     * back into the master thread
     */
    @Override
    public void run() {

        while(true){
            try {
                double[] coefficients = sharedBufferCoefficients.getCoefficients(); //get the coefficients

                slaveThreads.put(slaveNo,slaveThreads.get(slaveNo)+1); //increase the count of solved equations for the current slave thread

                double a = coefficients[0]; //get the three coefficient for the quadratic equation
                double b = coefficients[1];
                double c = coefficients[2];

                String x1, x2; //to put the solved roots into buffer

                //perform operations to get the roots
                double underRootResult = (b * b) - (4 * a * c);
                double rightPartResult = -b / (2 * a);

                if (underRootResult < 0) { //if result is imaginary number
                    double imaginaryPart = Math.sqrt(-1 * underRootResult) / (2 * a);

                    x1 = rightPartResult + " + i " + imaginaryPart ;
                    x2 = rightPartResult + " - i " + imaginaryPart ;

                } else {
                    double leftPart = Math.sqrt(underRootResult)/(2*a);
                    double root1 = rightPartResult + leftPart;
                    double root2 = rightPartResult - leftPart;

                    x1 = Double.toString(root1);
                    x2 = Double.toString(root2);
                }

                sharedBufferRoots.putRoots(x1, x2); //put roots in buffer to be inserted into master thread

            } catch (Exception e) {
                System.out.print("in exception slave");
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * static method for the master to call in order to the hash map with the slave threads and the amount of equations each solved
     * @return hashmap holding all the created slave threads
     */
    public static HashMap<Integer, Integer> getSlaveThreads() {
        return slaveThreads;
    }
}
