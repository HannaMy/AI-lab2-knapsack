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
        ProblemInfo problemInfo = readInput.readItems(2);
        ProblemInfo problemSolution = greedyAlgorithm.search(problemInfo);
        //System.out.println(problemSolution.toString());
        for (int i = 0; i < problemSolution.getKnapsacks().length; i++) {
            System.out.println("Solution: WeightCapacity: " + problemSolution.getKnapsacks()[i].getWeightCapacity()+ ", Value: " + problemSolution.getKnapsacks()[i].getValue() + ", weight: " + problemSolution.getKnapsacks()[i].getWeightCurrent() + ", nbrOfITems: " +problemSolution.getKnapsacks()[i].getItems().size());
        }
        System.out.println("Solution1: "+problemSolution.getTotalValue());
        ImprovingSearch improvingSearch = new ImprovingSearch();
        ProblemInfo improvedSolution = improvingSearch.neighborSearch(problemSolution);
        for (int i = 0; i < improvedSolution.getKnapsacks().length; i++) {
            System.out.println("Solution: WeightCapacity: " + improvedSolution.getKnapsacks()[i].getWeightCapacity()+ ", Value: " + improvedSolution.getKnapsacks()[i].getValue() + ", weight: " + improvedSolution.getKnapsacks()[i].getWeightCurrent() + ", nbrOfITems: " +improvedSolution.getKnapsacks()[i].getItems().size());
        }

        System.out.println("Solution2: "+improvedSolution.getTotalValue());
        System.out.println("Items left: "+improvedSolution.getNbrOfItemsLeft());
        System.out.println(improvedSolution.toString());


    }




}
