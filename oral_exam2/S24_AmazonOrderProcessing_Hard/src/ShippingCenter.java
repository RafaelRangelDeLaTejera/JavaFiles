public class ShippingCenter implements Runnable{
    private BufferDemo inputBuffer;
    private BufferDemo outputBuffer;

    public ShippingCenter(int centerNumber, BufferDemo inputBuffer, BufferDemo outputBuffer) {
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
    }

    @Override
    public void run() {

    }
}
