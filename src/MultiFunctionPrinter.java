class PrinterScanner extends MultiFunctionDevice implements Printer, Scanner, NetworkDevice {
    private final int paperTrayCapacity;
    private final int inkCapacity;
    private int currentPaperCount;
    private int currentInkAmount;
    private boolean isConnectedToNetwork;

    public PrinterScanner(String brand, String model, int paperTrayCapacity, int inkCapacity) {
        super(brand, model);
        this.paperTrayCapacity = paperTrayCapacity;
        this.currentPaperCount = 0;
        this.inkCapacity = inkCapacity;
        this.isConnectedToNetwork = false;
    }

    @Override
    public void powerOn() {
        System.out.println(getBrand() + " " + getModel() + " is now powered on.");
    }

    @Override
    public void powerOff() {
        System.out.println(getBrand() + " " + getModel() + " is now powered off.");
    }

    @Override
    public void print(String document) {
        if (currentPaperCount > 0) {
            System.out.println("Printing document: " + document);
            currentPaperCount--;
        } else {
            System.out.println("Cannot print. Paper tray is empty.");
        }
    }

    @Override
    public void loadPaper(int sheets) {
        if (currentPaperCount + sheets <= paperTrayCapacity) {
            currentPaperCount += sheets;
            System.out.println("Loaded " + sheets + " sheets. Current paper count: " + currentPaperCount);
        } else {
            System.out.println("Cannot load " + sheets + " sheets. Exceeds maximum tray capacity by " + (sheets + currentPaperCount - paperTrayCapacity) + " sheets.");
        }
    }

    @Override
    public void loadInk(int amount) {
        if (currentInkAmount + amount <= inkCapacity) {
            currentInkAmount += amount;
            System.out.println("Loaded " + amount + "ml of ink. Current ink amount: " + currentInkAmount);
        } else {
            System.out.println("Cannot add " + amount + "ml of ink. Exceeds maximum capacity by " + (amount + currentInkAmount - inkCapacity) + "ml.");
        }
    }

    @Override
    public void scan(String documentName, String format) {
        System.out.println("Scanning document: " + documentName + " as " + format + " file.");
    }

    @Override
    public void connectToNetwork(String networkName) {
        isConnectedToNetwork = true;
        System.out.println(getBrand() + " " + getModel() + " is connected to network: " + networkName);
    }

    public void checkStatus() {
        System.out.println("Brand: " + getBrand() + ", Model: " + getModel());
        System.out.println("Paper count: " + currentPaperCount + "/" + paperTrayCapacity);
        System.out.println("Network connected: " + (isConnectedToNetwork ? "Yes" : "No"));
    }
}