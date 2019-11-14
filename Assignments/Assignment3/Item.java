public class Item {
    private String name;
    private int itemCode;

    public Item (String name, int itemCode) {
       this.name = name;
       this.itemCode = itemCode;
    }

    public void displayInfo () {
        System.out.println("Item Name: " + name);
        System.out.println("Item Code: " + itemCode);
    }
}
