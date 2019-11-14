public class Clothing extends Item implements Discount, Tax{
    private String brand;
    private double price;
    private double units;
    private double discount;
    final double taxp = 8.5;

    public Clothing(String name, int itemCode, String brand, double price, double units, double discount) {
        super(name, itemCode);
        this.brand = brand;
        this.price = price;
        this.units = units;
        this.discount = discount;
    }

    @Override
    public double computeDiscount() {
        return (units * price)  * (discount * .01);
    }

    @Override
    public double computeTax() {
        return (units * price) * (taxp * .01);
    }

    public double computeTotalPrice() {
        return (units * price) + computeTax() - computeDiscount();
    }

    public void displayClothing() {
        double subTotal = units * price;
        System.out.println("\n-----------------------------------------------------");
        displayInfo();
        System.out.println("Clothing Brand: " + brand);
        System.out.println("Price per unit: $" + price);
        System.out.println("Total number of units: " + units);
        System.out.println("Subtotal before tax/discount: $" + subTotal);
        System.out.println("Clothing Tax @ 8.5%: $" + computeTax());
        System.out.println("Discount: %" + discount);
        System.out.println("Total savings from discount: $" + computeDiscount());
        System.out.println("GRAND TOTAL FOR ITEM: $" + computeTotalPrice());
        System.out.println("-----------------------------------------------------\n");
    }
}
