import java.nio.Buffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderProcessing {

    public void processOrder(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        // create BlockingBuffer to store ints
        BufferDemo sharedBufferServerCenter = new BufferDemo();
        BufferDemo sharedBufferCenterSection = new BufferDemo();
        BufferDemo sharedBufferSectionDock = new BufferDemo();
        BufferDemo sharedBufferDockTruck = new BufferDemo();

        executorService.execute(new AmazonWebServer(sharedBufferServerCenter));
        executorService.execute(new ShippingCenter(1,sharedBufferServerCenter,sharedBufferCenterSection));
        executorService.execute(new ShippingCenter(2,sharedBufferServerCenter,sharedBufferCenterSection));
        executorService.execute(new ShippingDock(sharedLocation));
        executorService.execute(new Section(sharedLocation));
        executorService.execute(new ShippingDock(sharedLocation));
        executorService.execute(new DeliveryTruck(sharedLocation));




//        executorService.shutdown();
//        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

}
