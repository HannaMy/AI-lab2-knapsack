import java.util.LinkedList;

public class ImprovingSearch {


    public ProblemInfo neighborSearch(ProblemInfo oneSolution) {

        ProblemInfo bestNeighborSolution = oneSolution;
        boolean run = true;
        while (run) {
            ProblemInfo temp = getBestNeighbor(bestNeighborSolution);
            if (temp == null) {
                run = false;
            } else {
                bestNeighborSolution = temp;
            }
        }
        return bestNeighborSolution;

    }

    public ProblemInfo getBestNeighbor(ProblemInfo lastSolution) {
        System.out.println("TEST -------------------");
        int nbrOfKnapsacks = lastSolution.getKnapsacks().length;


        int bestValue = lastSolution.getTotalValue();
        int indexOfBestKnapsack1 = 0;
        int indexOfBestKnapsack2 = 0;
        int indexOfBestItem1 = -1; // item1 switches knapsack
        int indexOfBestItem2 = -1; // item2 leaves a knapsack
        int indexOfBestItem3 = -1; // item3 joins a knapsack

        for (int knapsackIndexFirst = 0; knapsackIndexFirst < nbrOfKnapsacks; knapsackIndexFirst++) {
            for (int knapsackIndexSecond = 0; knapsackIndexSecond < nbrOfKnapsacks; knapsackIndexSecond++) {

                //System.out.println("checking knapsacks nbr: " + knapsackIndexFirst + " & " + knapsackIndexSecond);
                Knapsack knapsack1 = lastSolution.getKnapsacks()[knapsackIndexFirst];
                Knapsack knapsack2 = lastSolution.getKnapsacks()[knapsackIndexSecond];
                LinkedList<Item> knapsack1Items = knapsack1.getItems();
                LinkedList<Item> knapsack2Items = knapsack2.getItems();
                Item[] availableItems = lastSolution.getItems();
                if (knapsackIndexFirst == knapsackIndexSecond) {

                    for (int i = 0; i < knapsack1.getItems().size(); i++) {
                        for (int k = 0; k < availableItems.length; k++) {
                            if (availableItems[k] != null) {
                                if ((knapsack1.getWeightRemaining() + knapsack1Items.get(i).getWeight()) >= availableItems[k].getWeight()) {
                                    int currentValue = lastSolution.getTotalValue();
                                    int newValue = currentValue - knapsack1Items.get(i).getValue() + availableItems[k].getValue();
                                    if (newValue > bestValue) {
                                        System.out.println("---------------------BETTER SOLUTION FOUND NO ROTATION: " + newValue + ", old: " + bestValue + "Diff: " + (availableItems[k].getWeight()-knapsack2Items.get(i).getWeight()));
                                        //System.out.println(knapsack1.getWeightRemaining() + " " + knapsack1Items.get(i).getWeight() + " " +  availableItems[k].getWeight() );
                                        bestValue = newValue;
                                        indexOfBestItem1 = -1;
                                        indexOfBestItem2 = i;
                                        indexOfBestItem3 = k;
                                        indexOfBestKnapsack1 = knapsackIndexFirst;
                                        indexOfBestKnapsack2 = knapsackIndexSecond;
                                    }

                                }
                            }
                        }
                    }


                    break;
                }
                for (int i = 0; i < knapsack1.getItems().size(); i++) {
                    //System.out.println("checking first knapsack item " + i);
                    if (knapsack2.getWeightRemaining() >= knapsack1Items.get(i).getWeight()) {
                        for (int k = 0; k < availableItems.length; k++) {
                            if (availableItems[k] != null) {
                                if ((knapsack1.getWeightRemaining() + knapsack1Items.get(i).getWeight()) >= availableItems[k].getWeight()) {
                                    //System.out.println("Found one item to to add to knapsack 1 that will fit when we have removed item 1");
                                    int currentValue = lastSolution.getTotalValue();
                                    int newValue = currentValue + availableItems[k].getValue();
                                    if (newValue > bestValue) {
                                        System.out.println("---------------------BETTER SOLUTION FOUND ROTATION 2: " + newValue + ", old: " + bestValue + "Diff: " + (availableItems[k].getWeight()));
                                        //System.out.println(knapsack1.getWeightRemaining() + " " + knapsack1Items.get(i).getWeight() + " " +  availableItems[k].getWeight() );
                                        bestValue = newValue;
                                        indexOfBestItem1 = i;
                                        indexOfBestItem2 = -1;
                                        indexOfBestItem3 = k;
                                        indexOfBestKnapsack1 = knapsackIndexFirst;
                                        indexOfBestKnapsack2 = knapsackIndexSecond;
                                    }

                                }
                            }
                        }
                    } else {
                        for (int j = 0; j < knapsack2.getItems().size(); j++) {
                            //System.out.println("room: " + knapsack2.getWeightRemaining() + knapsack2Items.get(j).getWeight() + ", item weight: " + knapsack1Items.get(i).getWeight());
                            if ((knapsack2.getWeightRemaining() + knapsack2Items.get(j).getWeight()) >= knapsack1Items.get(i).getWeight()) {
                                //System.out.println("Found one item to remove in knapsack 2 to give space to item 1");
                                for (int k = 0; k < availableItems.length; k++) {
                                    if (availableItems[k] != null) {
                                        if ((knapsack1.getWeightRemaining() + knapsack1Items.get(i).getWeight()) >= availableItems[k].getWeight()) {
                                            //System.out.println("Found one item to to add to knapsack 1 that will fit when we have removed item 1");
                                            int currentValue = lastSolution.getTotalValue();
                                            int newValue = currentValue - knapsack2Items.get(j).getValue() + availableItems[k].getValue();
                                            if (newValue > bestValue) {
                                                System.out.println("---------------------BETTER SOLUTION FOUND ROTATION 1: " + newValue + ", old: " + bestValue + "Diff: " + (availableItems[k].getWeight() - knapsack2Items.get(j).getWeight()));
                                                System.out.println("Knapsack: " +knapsackIndexFirst+ " " +knapsack1.getWeightRemaining() + " " + knapsack1Items.get(i).getWeight() + " " +  availableItems[k].getWeight() );
                                                System.out.println("Knapsack: " +knapsackIndexSecond+ " " + (knapsack2.getWeightRemaining() + " " + knapsack2Items.get(j).getWeight()) + " " + knapsack1Items.get(i).getWeight() );
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
        }
        System.out.println("ööööööööööööööööööööööö   Checking");
        if (bestValue > lastSolution.getTotalValue()) {
            for (int i = 0; i < lastSolution.getKnapsacks().length; i++) {
                if (lastSolution.getKnapsacks()[i].getWeightRemaining() <0 || lastSolution.getTotalWeightRemaining() <0) {
                    System.out.println("SOMETHING WRONG KNAPSACK TO MUCH WEIGHT");
                    break;
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2Changing solution Weight Remeining: " + lastSolution.getTotalWeightRemaining());


            Item item1 = null;
            Item item2 = null;
            if (indexOfBestItem1 >= 0) {
                 item1 = lastSolution.getKnapsacks()[indexOfBestKnapsack1].getItem(indexOfBestItem1);
                lastSolution.getKnapsacks()[indexOfBestKnapsack1].removeItem(indexOfBestItem1);
            }
            if (indexOfBestItem2 >= 0) {
                item2 = lastSolution.getKnapsacks()[indexOfBestKnapsack2].getItem(indexOfBestItem2);
                lastSolution.getKnapsacks()[indexOfBestKnapsack2].removeItem(indexOfBestItem2);
            }
            if (indexOfBestItem1 >= 0) {
                lastSolution.getKnapsacks()[indexOfBestKnapsack2].addItem(item1);
                lastSolution.getKnapsacks()[indexOfBestKnapsack2].addValue(item1.getValue());
                lastSolution.getKnapsacks()[indexOfBestKnapsack2].addWeight(item1.getWeight());
            }

            Item item3 = lastSolution.getItems()[indexOfBestItem3];
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].addItem(item3);
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].addValue(item3.getValue());
            lastSolution.getKnapsacks()[indexOfBestKnapsack1].addWeight(item3.getWeight());
            lastSolution.getItems()[indexOfBestItem3] = null;

            if (indexOfBestItem2 >= 0) {
                lastSolution.addItem(item2);
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2Changing solution Weight Remeining: " + lastSolution.getTotalWeightRemaining());
        } else {
            return null;
        }


        return lastSolution;
    }


}
