public class Item {


    private int id;
    private int value;
    private int weight;
    private double relativeValue;

    public Item(int id, int weight, int value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
        this.relativeValue = (double)(value / weight);
    }

    public Item( int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.relativeValue = (double)(value / weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getRelativeValue() {
        return relativeValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item " + id + " Weight: " + weight +  " Value: " + value;
    }
}
