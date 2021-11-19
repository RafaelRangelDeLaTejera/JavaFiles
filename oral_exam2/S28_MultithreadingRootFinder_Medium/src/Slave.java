public class Slave implements Runnable{

    private final CircularBufferCoefficients sharedBufferCoefficients; // reference to shared object
    private final CircularBufferRoots sharedBufferRoots;
    private final int slaveNo;
    private int countSolvedSets;

    public Slave(CircularBufferCoefficients circularBufferCoefficients, CircularBufferRoots sharedBufferRoots, int slaveNo) {
        this.sharedBufferCoefficients = circularBufferCoefficients;
        this.sharedBufferRoots = sharedBufferRoots;
        this.slaveNo = slaveNo;
        countSolvedSets = 0;
    }

    @Override
    public void run() {

        while(true){
            try {

                Thread.sleep(100);

                double[] coefficients = sharedBufferCoefficients.getCoefficients();

                countSolvedSets++;

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

                Thread.sleep(100);
                sharedBufferRoots.putRoots(x1, x2);

                System.out.print("\nout\n");

            } catch (Exception e) {
                System.out.print("in exception ");
                //Thread.currentThread().interrupt();

               // e.printStackTrace();
            }
        }

        System.out.print(countSolvedSets + "Sets solved by slave " + slaveNo);
    }

    public int getCountSolvedSets() {
        return countSolvedSets;
    }

    public int getSlaveNo() {
        return slaveNo;
    }
}
