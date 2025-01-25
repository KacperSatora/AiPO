class MultiFunctionPrinter extends MultiFunctionDevice implements NetworkDevice {
    private final int paperTrayCapacity;
    private final int inkCapacity;
    private int currentPaperCount;
    private int currentInkAmount;
    private boolean isConnectedToNetwork;


    public MultiFunctionPrinter(String brand, String model, String scannerType, String printerType, int paperTrayCapacity, int inkCapacity) {
        super(brand, model, scannerType, printerType);
        this.paperTrayCapacity = paperTrayCapacity;
        this.inkCapacity = inkCapacity;

        this.currentPaperCount = 0;
        this.currentInkAmount = 0;

        this.isConnectedToNetwork = false;
        super.setScannerType("Color");
        super.setPrinterType("EcoTank");
    }

    @Override
    public void powerOn() {
        super.powerOn();
        System.out.println(getBrand() + " " + getModel() + " is now powered on.");
    }

    @Override
    public void powerOff() {
        super.powerOff();
        System.out.println(getBrand() + " " + getModel() + " is now powered off.");
    }

    @Override
    public void print(String document) {
        if (super.print()) {
            if (currentPaperCount > 0) {
                System.out.println("Printing document: " + document);
                currentPaperCount--;
            } else {
                System.out.println("Cannot print. Paper tray is empty.");
            }
        } else {
            System.out.println("Cannot print. Printer is out of power.");
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
        if (super.scan()) {
            System.out.println("Scanning document: " + documentName + " as " + format + " file.");
        } else {
            System.out.println("Cannot scan, printer is out of power");
        }
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