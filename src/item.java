public class item {
    private int id;
    private int value;
    private int weight;
    private double relativeValue;


    public item(int id, int weight, int value) {
        this.id = id;
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
}
