public class Main {

    public static void main(String[] args) {
        Grocery grocery1 = new Grocery("Bread", 11, 1.5, 2, 0);
        Grocery grocery2 = new Grocery("Apple", 12, .75, 6, 1);

        Clothing clothing1 = new Clothing("Jeans", 21, "Levis", 35, 1, 0);
        Clothing clothing2 = new Clothing("Dress Shirt", 22, "Izod", 25, 2, 10);


        grocery1.displayGrocery();
        grocery2.displayGrocery();
        clothing1.displayClothing();
        clothing2.displayClothing();

        double totalBill = grocery1.computeTotalPrice() + grocery2.computeTotalPrice() + clothing1.computeTotalPrice() + clothing2.computeTotalPrice();

        System.out.println("\n\n**************************************");
		System.out.println("YOUR TOTAL BILL COMES OUT TO: $" + totalBill);
		System.out.println("**************************************");
    }
}
