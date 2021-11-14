public class Section implements Runnable{
    private BufferDemo inputBuffer;
    private BufferDemo outputBuffer;

    public Section(int sectionNumber, BufferDemo inputBuffer, BufferDemo outputBuffer) {
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
    }

    @Override
    public void run() {

    }
}
