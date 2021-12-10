import java.util.LinkedList;

public class ImprovingSearch {


    public ProblemInfo neighborSearch(ProblemInfo oneSolution) {

        ProblemInfo bestNeighborSolution = oneSolution;
        boolean run = true;
        while (run) {
            ProblemInfo temp = getBestNeighbor(bestNeighborSolution);
            if(temp == null){
                run = false;
            }else{
                bestNeighborSolution = temp;
            }
        }
        return bestNeighborSolution;

    }

    public ProblemInfo getBestNeighbor(ProblemInfo lastSolution) {
        int nbrOfKnapsacks = lastSolution.getKnapsacks().length;


        int bestValue = lastSolution.getTotalValue();
        int indexOfBestKnapsack1 = 0;
        int indexOfBestKnapsack2 = 0;
        int indexOfBestItem1 = 0; // item1 switches knapsack
        int indexOfBestItem2 = 0; // item2 leaves a knapsack
        int indexOfBestItem3 = 0; // item3 joins a knapsack

        for (int knapsackIndexFirst = 0; knapsackIndexFirst < nbrOfKnapsacks; knapsackIndexFirst++) {
            for (int knapsackIndexSecond = knapsackIndexFirst + 1; knapsackIndexSecond < nbrOfKnapsacks; knapsackIndexSecond++) {
               // System.out.println("checking knapsacks nbr: " + knapsackIndexFirst + " & " + knapsackIndexSecond);
                Knapsack knapsack1 = lastSolution.getKnapsacks()[knapsackIndexFirst];
                Knapsack knapsack2 = lastSolution.getKnapsacks()[knapsackIndexSecond];
                LinkedList<Item> knapsack1Items = knapsack1.getItems();
                LinkedList<Item> knapsack2Items = knapsack2.getItems();
                Item[] availableItems = lastSolution.getItems();
                for (int i = 0; i < knapsack1.getItems().size(); i++) {
                    //System.out.println("checking first knapsack item " + i);
                    for (int j = 0; j < knapsack2.getItems().size(); j++) {
                        //System.out.println("room: " + knapsack2.getWeightRemaining() + knapsack2Items.get(j).getWeight() + ", item weight: " + knapsack1Items.get(i).getWeight());
                        if ((knapsack2.getWeightRemaining() + knapsack2Items.get(j).getWeight()) >= knapsack1Items.get(i).getWeight()) {
                            //System.out.println("Found one item to remove in knapsack 2 to give space to item 1");
                            for (int k = 0; k < availableItems.length; k++) {
                                if(availableItems[k] != null) {
                                    if ((knapsack1.getWeightRemaining() + knapsack1Items.get(i).getWeight()) >= availableItems[k].getWeight()) {
                                        //System.out.println("Found one item to to add to knapsack 1 that will fit when we have removed item 1");
                                        int currentValue = lastSolution.getTotalValue();
                                        int newValue = currentValue - knapsack2Items.get(j).getValue() + availableItems[k].getValue();
                                        if (newValue > bestValue) {
                                            System.out.println("---------------------BETTER SOLUTION FOUND: " + newValue + ", old: " + bestValue);
                                            bestValue = newValue;
                                            indexOfBestItem1 = i;
                                            indexOfBestItem2 = j;
                                            indexOfBestItem3 = k;
                                            indexOfBestKnapsack1 = knapsackIndexFirst;
                                            indexOfBestKnapsack2 = knapsackIndexSecond;
                                        }

                                    }
                                }
                            }

                        }

                    }

                }
            }
        }
        if(bestValue > lastSolution.getTotalValue()) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2Changing solution");
            Item item1 = lastSolution.getKnapsacks()[indexOfBestKnapsack1].getItem(indexOfBestItem1);
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].removeItem(indexOfBestItem1);
            Item item2 = lastSolution.getKnapsacks()[indexOfBestKnapsack2].getItem(indexOfBestItem2);
            lastSolution.getKnapsacks()[indexOfBestKnapsack2].removeItem(indexOfBestItem2);
            lastSolution.getKnapsacks()[indexOfBestKnapsack2].addItem(item1);
            lastSolution.getKnapsacks()[indexOfBestKnapsack2].addValue(item1.getValue());
            lastSolution.getKnapsacks()[indexOfBestKnapsack2].addWeight(item1.getWeight());
            Item item3 = lastSolution.getItems()[indexOfBestItem3];
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].addItem(item3);
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].addValue(item3.getValue());
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].addWeight(item3.getWeight());
            lastSolution.getItems()[indexOfBestItem3] = null;
            lastSolution.addItem(item2);
        }else{
            return null;
        }


        return lastSolution;
    }


}
