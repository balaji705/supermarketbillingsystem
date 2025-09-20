import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    double getTotalPrice() {
        return quantity * price;
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> cart = new ArrayList<>();
        double total = 0.0;

        System.out.println("Welcome to the Supermarket Billing System!");
        while (true) {
            System.out.println("\n1. Add Item to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Delete Item from Cart");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
           
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price per unit: ");
                    double price = scanner.nextDouble();
                    cart.add(new Item(name, quantity, price));
                    System.out.println("Item added to cart!");
                    break;

               
                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty!");
                    } else {
                        System.out.println("\nItems in Cart:");
                        int index = 1;
                        for (Item item : cart) {
                            System.out.printf("%d. Name: %s, Quantity: %d, Price: %.2f, Total: %.2f\n",
                                    index++, item.name, item.quantity, item.price, item.getTotalPrice());
                        }
                    }
                    break;
                 case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty! Nothing to delete.");
                    } else {
                        System.out.println("\nItems in Cart:");
                        int index = 1;
                        for (Item item : cart) {
                            System.out.printf("%d. %s (Qty: %d)\n", index++, item.name, item.quantity);
                        }
                        System.out.print("Enter the item number to delete: ");
                        int delIndex = scanner.nextInt();
                        if (delIndex > 0 && delIndex <= cart.size()) {
                            Item removed = cart.remove(delIndex - 1);
                            System.out.println("Removed: " + removed.name);
                        } else {
                            System.out.println("Invalid item number!");
                        }
                    }
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty! Add items before generating bill.");
                    } else {
                        System.out.println("\nGenerating Bill...");
                        total = 0.0;`
                        for (Item item : cart) {
                            total += item.getTotalPrice();
                        }
                        System.out.printf("Total Amount: %.2f\n", total);
                        System.out.println("Thank you for shopping with us!");
                        return;
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;

                

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
