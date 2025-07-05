public class NonExpirableProduct extends Product implements Shippable {
    private boolean shippingRequired;
    private double weight;

    public NonExpirableProduct(String name, double price, int quantity, boolean shippingRequired, double weight) {
        super(name, price, quantity);
        this.shippingRequired = shippingRequired;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean needsShipping() {
        return shippingRequired;
    }

    public double getWeight() {
        return weight;
    }
}