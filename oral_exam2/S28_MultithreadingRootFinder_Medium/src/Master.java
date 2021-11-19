import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Master {

    public static void main(String[] args) throws InterruptedException{

        Random randomNumber = new Random();//object to create random numbers for coefficients

        //have user select option
        Scanner input = new Scanner(System.in); //create scanner object to read in from user
        System.out.print("Input 1 to generate and solve 30 sets of randomly generated coefficients and print all roots," +
                "or input 2 to generate and solve 3000 sets of coefficients and print Statistics of slave thread usage");

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
                    System.out.print(i);

                    Thread.sleep(100);
                    sharedBufferCoefficients.putCoefficients(1, 4, 4);

                    Thread.sleep(100);
                    String[] roots = sharedBufferRoots.getRoots();
                    System.out.print("root 1 = " + roots[0] + ", root 2 = " + roots[1] + "\n");


                } catch (Exception e) {
                    System.out.print("In exception master");
                    // Thread.currentThread().interrupt();
                }
            }
        }
        else if (option == 2){
            for (int i = 0; i < 3000; i++) {

                try {
                    System.out.print(i);

                    sharedBufferCoefficients.putCoefficients(1, 4, 4);

                    String[] roots = sharedBufferRoots.getRoots();
                   // System.out.print("root 1 = " + roots[0] + ", root 2 = " + roots[1] + "\n");


                } catch (Exception e) {
                    System.out.print("In exception master");
                    // Thread.currentThread().interrupt();
                }
            }


        }
        else {
            System.out.print("invalid input, run program again");
        }

        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        System.exit(0);

        }
}


//todo
//coordinate the put coefficients and get coefficients with the put and get root methods, we need the classes to put and release so that no empty
//buffer roots is called

//todo
//find out when the programs is waiting for a method to complete that will never finish