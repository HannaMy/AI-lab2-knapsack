import java.util.LinkedList;

public class Knapsack {

    private int weightCapacity;
    private int weightCurrent;
    private int value;
    private LinkedList<Item> itemsInKnapsack;


    public Knapsack(int weightCapacity) {
        this.weightCapacity = weightCapacity;
        itemsInKnapsack = new LinkedList();
    }

    public int getWeightCurrent() {
        return weightCurrent;
    }

    public void setWeightCurrent(int weightCurrent) {
        this.weightCurrent = weightCurrent;
    }


    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public void addWeight(int weightToAdd){
        this.weightCurrent += weightToAdd;
    }

    public int getWeightRemaining(){
        return weightCapacity-weightCurrent;
    }

    public void addItem(Item item){
        itemsInKnapsack.addFirst(item);
    }

    public LinkedList getItems(){
        return itemsInKnapsack;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addValue(int valueToAdd){
        this.value += valueToAdd;
    }

    @Override
    public String toString() {

        return "Knapsack Weight Capacity: " + weightCapacity;
    }
}
