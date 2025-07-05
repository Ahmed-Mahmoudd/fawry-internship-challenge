import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new LinkedHashMap<>();

    public void add(Product p, int quantity) {
        if (quantity <= p.getQuantity()) {
            items.put(p, items.getOrDefault(p, 0) + quantity);
        } else {
            System.out.println("Quantity exceeds stock.");
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
