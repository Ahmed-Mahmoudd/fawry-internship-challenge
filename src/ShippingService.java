import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items == null || items.isEmpty()) return;

        System.out.println("** Shipment notice **");

        Map<String, ShipmentInfo> grouped = new LinkedHashMap<>();
        double totalWeight = 0.0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            totalWeight += weight;

            if (!grouped.containsKey(name)) {
                grouped.put(name, new ShipmentInfo(1, weight));
            } else {
                grouped.get(name).count++;
            }
        }

        for (Map.Entry<String, ShipmentInfo> entry : grouped.entrySet()) {
            String name = entry.getKey();
            ShipmentInfo info = entry.getValue();
            System.out.printf("%dx %s %.0fg\n", info.count, name, info.weight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }

    private static class ShipmentInfo {
        int count;
        double weight;

        public ShipmentInfo(int count, double weight) {
            this.count = count;
            this.weight = weight;
        }
    }
}
