public class Slave implements Runnable{

    private final CircularBufferCoefficients sharedBufferCoefficients; // reference to shared object
    private final CircularBufferRoots sharedBufferRoots;

    public Slave(CircularBufferCoefficients circularBufferCoefficients,CircularBufferRoots sharedBufferRoots) {
        this.sharedBufferCoefficients = circularBufferCoefficients;
        this.sharedBufferRoots = sharedBufferRoots;
    }

    @Override
    public void run(){
        try {
            double a = sharedBufferCoefficients.getCoefficients(); //get the three coefficient for the cuadratic equation
            double b = sharedBufferCoefficients.getCoefficients();
            double c = sharedBufferCoefficients.getCoefficients();

            String x1,x2;

            //perform operations to get the roots
            double underRootResult = (b*b)-(4*a*c);
            double rightPartResult = -b/(2*a);

            if (underRootResult < 0){ //if result is imaginary number
                double imaginaryPart = Math.sqrt(-1*underRootResult)/(2*a);

                 x1 = rightPartResult + " + " + imaginaryPart + "i";
                 x2 = rightPartResult + " - " + imaginaryPart + "i";

            }
            else {
                double leftPart = Math.sqrt(underRootResult);
                double root1 = rightPartResult+leftPart;
                double root2 = rightPartResult-leftPart;

                 x1 = Double.toString(root1);
                 x2 = Double.toString(root2);
            }

            sharedBufferRoots.putRoots(x1,x2);



        } catch (InterruptedException e) {
            e.printStackTrace(); //todo handle exception
        }



    }

}
