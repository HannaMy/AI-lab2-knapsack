import java.util.LinkedList;

public class Controller {
    private ReadInput readInput;
    private GreedyAlgorithm greedyAlgorithm;
    private ImprovingSearch improvingSearch;

    public Controller() {
        this.readInput = new ReadInput();
        greedyAlgorithm = new GreedyAlgorithm();
        improvingSearch = new ImprovingSearch();
    }

    //TODO: add function to fill with new items in the neighbor search
    //TODO: Do better testcases?

    public void run(){
        for (int testcase = 1; testcase < 7; testcase++) {
            runTestCase(testcase);
        }

    }
    public void runTestCase(int testcaseNbr){
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO---Testcase nbr " + testcaseNbr + "---OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println();
        ProblemInfo problemInfo = readInput.readItems(testcaseNbr);

        System.out.println("--------------------------GREEDY-------------------------");
        ProblemInfo problemSolution = greedyAlgorithm.search(problemInfo);
        printResult(problemSolution);
        System.out.println("--------------------------IMPROVED SEARCH-------------------------");
        ProblemInfo improvedSolution = improvingSearch.neighborSearch(problemSolution);
        printResult(improvedSolution);
    }

    private void printResult(ProblemInfo problemInfo){
        System.out.println("RESULT - Value: " + problemInfo.getTotalValue() + " (" + problemInfo.getTotalWeight() + "/" + problemInfo.getTotalWeightCapacity() + " weight, " +  problemInfo.getTotalWeightRemaining() +" left) ");
        for (int i = 0; i < problemInfo.getKnapsacks().length; i++) {
            System.out.print("      Knapsack " + i + " - Value: " +  problemInfo.getKnapsacks()[i].getValue() + " (" + problemInfo.getKnapsacks()[i].getWeightCurrent() + "/" + problemInfo.getKnapsacks()[i].getWeightCapacity() + " weight) " );
            System.out.print(" [");
            for (int j = 0; j < problemInfo.getKnapsacks()[i].getItems().size() ; j++) {
                LinkedList<Item> list = problemInfo.getKnapsacks()[i].getItems();
                Item item = list.get(j);
                System.out.print(item + ", ");
            }
            System.out.println("]");
        }

    }





}
