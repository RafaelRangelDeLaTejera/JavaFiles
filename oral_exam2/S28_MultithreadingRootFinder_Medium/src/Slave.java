import java.util.HashMap;

public class Slave implements Runnable{

    private final CircularBufferCoefficients sharedBufferCoefficients; // reference to shared object
    private final CircularBufferRoots sharedBufferRoots;
    private int slaveNo = 0;
    private static HashMap<Integer,Integer> slaveThreads = new HashMap<>();

    public Slave(CircularBufferCoefficients circularBufferCoefficients, CircularBufferRoots sharedBufferRoots, int slaveNo) {
        this.sharedBufferCoefficients = circularBufferCoefficients;
        this.sharedBufferRoots = sharedBufferRoots;
        this.slaveNo = slaveNo;
        slaveThreads.put(slaveNo,0);
    }

    @Override
    public void run() {

        while(true){
            try {
                double[] coefficients = sharedBufferCoefficients.getCoefficients();

                slaveThreads.put(slaveNo,slaveThreads.get(slaveNo)+1);

                double a = coefficients[0]; //get the three coefficient for the quadratic equation
                double b = coefficients[1];
                double c = coefficients[2];

                String x1, x2;

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

                sharedBufferRoots.putRoots(x1, x2);

            } catch (Exception e) {
                System.out.print("in exception slave");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static HashMap<Integer, Integer> getSlaveThreads() {
        return slaveThreads;
    }
}
