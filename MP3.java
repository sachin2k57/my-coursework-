public class MP3 extends Gadget {
    private int availableMemory;

    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public int getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic(int memoryRequired) {
        if (memoryRequired <= availableMemory) {
            availableMemory -= memoryRequired;
            System.out.println("Downloaded music. " + memoryRequired + "MB used.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    public void deleteMusic(int memoryFreed) {
        availableMemory += memoryFreed;
        System.out.println("Deleted music. " + memoryFreed + "MB freed.");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}
