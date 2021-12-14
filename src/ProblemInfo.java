import java.awt.*;
import java.util.LinkedList;

public class ProblemInfo {

    private Knapsack[] knapsacks;
    private Item[] items;

    public ProblemInfo(Knapsack[] knapsacks, Item[] items) {
        this.knapsacks = knapsacks;
        this.items = items;
        sortItems();
    }


    public void sortItems() {
        Item temp = null;
        for (int i = 0; i < items.length; i++) {
            int indexOfItemWithHighestRelativeValue = i;
            for (int j = i; j < items.length; j++) {
                if (items[indexOfItemWithHighestRelativeValue].getRelativeValue() <= items[j].getRelativeValue()) {
                    indexOfItemWithHighestRelativeValue = j;
                }
            }
            temp = items[i];
            items[i] = items[indexOfItemWithHighestRelativeValue];
            items[indexOfItemWithHighestRelativeValue] = temp;
            items[i].setId(i);
        }
    }

    public Knapsack[] getKnapsacks() {
        return knapsacks;
    }

    public void setKnapsacks(Knapsack[] knapsacks) {
        this.knapsacks = knapsacks;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }


    public int getTotalValue() {
        int totalValue = 0;
        for (int i = 0; i < knapsacks.length; i++) {
            totalValue += knapsacks[i].getValue();
        }
        return totalValue;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (int i = 0; i < knapsacks.length; i++) {
            totalWeight += knapsacks[i].getWeightCurrent();
        }
        return totalWeight;
    }

    public int getTotalWeightCapacity() {

        int totalWeightCapacity = 0;
        for (int i = 0; i < knapsacks.length; i++) {
            totalWeightCapacity += knapsacks[i].getWeightCapacity();
        }
        return totalWeightCapacity;
    }
    public int getTotalWeightRemaining() {

        int totalWeightRemaining = 0;
        for (int i = 0; i < knapsacks.length; i++) {
            totalWeightRemaining += knapsacks[i].getWeightRemaining();
        }
        return totalWeightRemaining;
    }

    public int getNbrOfItemsLeft(){
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null){
                size++;
            }
        }

        return size;
    }

    @Override
    public String toString() {
        String string = "Problem Info\n";
        string += "Knapsacks: ";
        for (int i = 0; i < knapsacks.length; i++) {
            string += knapsacks[i].toString() + "\n";

        }

        string += "Items: ";
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null) {
                string += items[i].toString() + "\n";
            }
        }
        return string;
    }
}
