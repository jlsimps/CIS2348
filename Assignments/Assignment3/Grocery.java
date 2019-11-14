public class Grocery extends Item implements Discount, Tax {
    private double price;
    private double units;
    private double discount;

    public Grocery(String name, int itemCode, double price, double units, double discount) {
        super(name, itemCode);
        this.price = price;
        this.units = units;
        this.discount = discount;
    }

    @Override
    public double computeDiscount () {
        return (units * price)  * (discount * .01);
    }

    @Override
    public double computeTax() {
        return 0;
    }

    public double computeTotalPrice () {
        return ((units * price) + computeTax()) - computeDiscount();
    }

    public void displayGrocery () {
        double subTotal = units * price;
        System.out.println("\n-----------------------------------------------------");
        displayInfo();
        System.out.println("Price per unit: $" + price);
        System.out.println("Total number of units: " + units);
        System.out.println("Subtotal before tax/discount: $" + subTotal);
        System.out.println("Grocery Tax: %0" + computeTax());
        System.out.println("Discount: %" + discount);
        System.out.println("Total savings from discount: $" + computeDiscount());
        System.out.println("GRAND TOTAL FOR ITEM: $" + computeTotalPrice());
        System.out.println("-----------------------------------------------------\n");
    }
}
