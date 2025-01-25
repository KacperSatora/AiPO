abstract class MultiFunctionDevice implements Scanner, Printer {
    private String brand;
    private String model;
    private boolean powerState = true;
    private String scannerType;
    private String printerType;

    @Override
    public void scan(String documentName, String format) {
        System.out.println("Moving scanner across");
    }

    @Override
    public void print(String document) {
        System.out.println("Moving print head over a page");
    }


    protected boolean print() {
        return powerState;
    }

    protected boolean scan() {
        return powerState;
    }

    protected void setScannerType(String scannerType) {
        this.scannerType = scannerType;
    }

    protected void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public MultiFunctionDevice(String brand, String model, String scannerType, String printerType) {
        this.brand = brand;
        this.model = model;
        this.scannerType = scannerType;
        this.printerType = printerType;
        this.powerState = false;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void powerOn() {
        System.out.println("Powering on");
        powerState = true;
    };

    public void powerOff() {
        System.out.println("Powering off");
        powerState = false;
    };
}
