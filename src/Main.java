import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.now().plusDays(5), 0.4);
        Product biscuits = new ExpirableProduct("Biscuits", 150, 2, LocalDate.now().plusDays(10), 0.7);
        Product tv = new NonExpirableProduct("TV", 300, 3, true, 5.0);
        Product scratchCard = new NonExpirableProduct("Scratch Card", 50, 20, false, 0.0);

        Customer customer = new Customer("Ahmed", 1000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        Checkout.process(customer, cart);
    }
}
