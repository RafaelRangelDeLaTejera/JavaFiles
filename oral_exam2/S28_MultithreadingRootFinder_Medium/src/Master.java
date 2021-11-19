import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Master {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executorService = Executors.newCachedThreadPool();


         CircularBufferCoefficients sharedBufferCoefficients = new CircularBufferCoefficients();
         CircularBufferRoots sharedBufferRoots = new CircularBufferRoots();

        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));
        executorService.execute(new Slave(sharedBufferCoefficients,sharedBufferRoots));

        executorService.awaitTermination(1, TimeUnit.MILLISECONDS); //wait for the 10 slaves to  be created


        Random randomNumber = new Random();//object to create random numbers for coefficients

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

        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        System.exit(0);

        }
}


//todo
//coordinate the put coefficients and get coefficients with the put and get root methods, we need the classes to put and release so that no empty
//buffer roots is called

//todo
//find out when the programs is waiting for a method to complete that will never finish