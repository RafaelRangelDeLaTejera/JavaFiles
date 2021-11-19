import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Slave implements Runnable{

    private final CircularBufferCoefficients sharedBufferCoefficients; // reference to shared object
    private final CircularBufferRoots sharedBufferRoots;
    private static boolean control;

    public Slave(CircularBufferCoefficients circularBufferCoefficients,CircularBufferRoots sharedBufferRoots) {
        this.sharedBufferCoefficients = circularBufferCoefficients;
        this.sharedBufferRoots = sharedBufferRoots;
        control = true;
    }

    @Override
    public void run() {

        while(control){
        try {

            //Thread.sleep(100);

            double[] coefficients = sharedBufferCoefficients.getCoefficients();


            double a = coefficients[0]; //get the three coefficient for the quadratic equation
            double b = coefficients[1];
            double c = coefficients[2];
            System.out.print("int slave ");

            String x1, x2;

            //perform operations to get the roots
            double underRootResult = (b * b) - (4 * a * c);
            double rightPartResult = -b / (2 * a);

            if (underRootResult < 0) { //if result is imaginary number
                double imaginaryPart = Math.sqrt(-1 * underRootResult) / (2 * a);

                x1 = rightPartResult + " + " + imaginaryPart + "i";
                x2 = rightPartResult + " - " + imaginaryPart + "i";

            } else {
                double leftPart = Math.sqrt(underRootResult)/(2*a);
                double root1 = rightPartResult + leftPart;
                double root2 = rightPartResult - leftPart;

                x1 = Double.toString(root1);
                x2 = Double.toString(root2);
            }

            System.out.print("\nright before put roots\n");

           // Thread.sleep(100);
            sharedBufferRoots.putRoots(x1, x2);

            System.out.print("\nout\n");

        } catch (Exception e) {
            System.out.print("in exception ");
            //Thread.currentThread().interrupt();

           // e.printStackTrace();
        }

    }



    }

    public static void setControl(boolean control) {
        Slave.control = control;
    }
}
