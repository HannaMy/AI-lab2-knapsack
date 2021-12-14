public class GreedyAlgorithm {

    private Knapsack[] knapsacks;
    private Item[] items;


    public ProblemInfo search(ProblemInfo problemInfo) {

        knapsacks = problemInfo.getKnapsacks();
        items = problemInfo.getItems();

        for (int i = 0; i < items.length; i++) {
           // System.out.println(items[i].toString());
            for (int j = 0; j <knapsacks.length; j++) {
                //System.out.println(knapsacks[j].getWeightRemaining());
                if (knapsacks[j].getWeightRemaining() >= items[i].getWeight()) {

                    knapsacks[j].addWeight(items[i].getWeight());
                    knapsacks[j].addValue(items[i].getValue());
                    knapsacks[j].addItem(items[i]);
                    items[i] = null;
                    break;
                }
                //System.out.println("Item " + i + "could not be added in knapsack " + j );
            }

        }


        return problemInfo;
    }


}
