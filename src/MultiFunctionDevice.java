abstract class MultiFunctionDevice {
    private String brand;
    private String model;

    public MultiFunctionDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public abstract void powerOn();

    public abstract void powerOff();
}
