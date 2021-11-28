import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * main thread class to either generate and solve 30 sets of quadratic equations or 3000 and print the statistics
 */
public class Master {

    /**
     * main method thread that first prompts the user to choose to either generate and solve 30 sets of quadratic equations or 3000 and print the statistics
     * @param args for when the program is executed from the command line and special arguments are passed in
     * @throws InterruptedException when the main thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException{

        Random randomNumber = new Random();//object to create random numbers for coefficients

        //have user select option
        Scanner input = new Scanner(System.in); //create scanner object to read in from user
        System.out.print("Input 1 to generate and solve 30 sets of randomly generated coefficients and print all roots,\n" +
                "or input 2 to generate and solve 3000 sets of coefficients and print Statistics of slave thread usage: ");

        int option = input.nextInt();

        ExecutorService executorService = Executors.newCachedThreadPool();


         CircularBufferCoefficients sharedBufferCoefficients = new CircularBufferCoefficients();
         CircularBufferRoots sharedBufferRoots = new CircularBufferRoots();

        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 1));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 2));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 3));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 4));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 5));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 6));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 7));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 8));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 9));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots, 10));

        executorService.awaitTermination(1, TimeUnit.MILLISECONDS); //wait for the 10 slaves to  be created

        if (option == 1) {
            for (int i = 0; i < 30; i++) {

                try {
                    System.out.print(i+": ");

                    Thread.sleep(100);
                    sharedBufferCoefficients.putCoefficients(randomNumber.nextDouble(), randomNumber.nextDouble(), randomNumber.nextDouble());

                    Thread.sleep(100);
                    String[] roots = sharedBufferRoots.getRoots();
                    System.out.print("root 1 = " + roots[0] + ", root 2 = " + roots[1] + "\n");

                } catch (Exception e) {
                    System.out.print("In exception master");
                    Thread.currentThread().interrupt();
                }
            }
        }
        else if (option == 2){ //generate 3000 sets of coefficients and solve
            for (int i = 0; i < 3000; i++) {

                try {

                    sharedBufferCoefficients.putCoefficients(randomNumber.nextDouble(), randomNumber.nextDouble(), randomNumber.nextDouble());

                    String[] roots = sharedBufferRoots.getRoots(); //get the roots to free the buffer

                } catch (Exception e) {
                    System.out.print("In exception master");
                    Thread.currentThread().interrupt();
                }
            }

            HashMap<Integer,Integer> threads = Slave.getSlaveThreads(); //hash map to hold the slave threads

            for (int x = 1; x <= 10; x++){ //print statistics of how many equations each of the 10 slaves solved
                System.out.print("slave " + x + " solved " + threads.get(x) + " sets\n");
            }

        }
        else {
            System.out.print("invalid input, run program again");
        }

        //executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        System.exit(0);

        }
}


//todo
//coordinate the put coefficients and get coefficients with the put and get root methods, we need the classes to put and release so that no empty
//buffer roots is called

//todo
//find out when the programs is waiting for a method to complete that will never finish