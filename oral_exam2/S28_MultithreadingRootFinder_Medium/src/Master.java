import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Master {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Random randomNumber = new Random();//object to create random numbers for coefficients

        // create BlockingBuffer to store doubles
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

        for (int i = 0; i < 30; i++){
            sharedBufferCoefficients.putCoefficients(randomNumber.nextDouble(),randomNumber.nextDouble(),randomNumber.nextDouble());
        System.out.print(i + sharedBufferRoots.getRoots() + "\n");
        }

        executorService.shutdown();
    }
}

//todo
//I need to clear the buffers of find a way to clear the slaves because only three equations are being executed becasue the slaves dont empty they just run once and stop
//buffers seem to work fine