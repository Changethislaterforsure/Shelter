public abstract class Animal {
    private String name;
    private int order; // smaller = older in the shelter

    public Animal(String name) {
        this.name = name;
    }

    // package private setter so only the shelter can set this
    void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    // returns true if this animal is older than the other
    public boolean isOlderThan(Animal other) {
        return this.order < other.order;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + name + ", order=" + order + ")";
    }
}