public class ProblemInfo {

    private Knapsack[] knapsacks;
    private Item[] items;

    public ProblemInfo(Knapsack[] knapsacks, Item[] items) {
        this.knapsacks = knapsacks;
        this.items = items;
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
}
