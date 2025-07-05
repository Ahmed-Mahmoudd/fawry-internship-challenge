import java.util.*;

public class Checkout {
    public static void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();

            if (p.isExpired()) {
                System.out.println("Error: Product " + p.getName() + " is expired.");
                return;
            }
            if (qty > p.getQuantity()) {
                System.out.println("Error: Not enough quantity for " + p.getName());
                return;
            }

            subtotal += p.getPrice() * qty;
            if (p.needsShipping() && p instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    toShip.add((Shippable) p);
                }
                shipping += 15 * qty; // 15 per shippable item
            }
        }

        double total = subtotal + shipping;
        if (!customer.deduct(total)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            System.out.printf("%dx %s    %.0f\n", qty, p.getName(), p.getPrice() * qty);
            p.decreaseQuantity(qty);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal        %.0f\n", subtotal);
        System.out.printf("Shipping        %.0f\n", shipping);
        System.out.printf("Amount          %.0f\n", total);
        System.out.printf("Remaining Balance: %.0f\n", customer.getBalance());
    }
}