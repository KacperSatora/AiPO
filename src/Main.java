public class Main {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter("Epson", "EcoTank", "Color", "Ink", 50, 5 * 25);
        System.out.println(printer.getBrand());
        System.out.println(printer.getModel());
        printer.scan("Test scan", "A4");
        printer.powerOn();
        printer.print("Test print");
        printer.loadPaper(5);
        printer.loadInk(50);
        printer.scan("Test scan2", "A4");
        printer.print("Test print2");
        printer.connectToNetwork("LAN");
    }
}
