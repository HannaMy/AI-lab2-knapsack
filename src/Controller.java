public class Controller {
    private ReadInput readInput;
    private GreedyAlgorithm greedyAlgorithm;
    private ImprovingSearch improvingSearch;

    public Controller() {
        this.readInput = new ReadInput();
        greedyAlgorithm = new GreedyAlgorithm();
        improvingSearch = new ImprovingSearch();
    }


    public void run(){
        ProblemInfo problemInfo = readInput.readItems(1);
        ProblemInfo problemSolution = greedyAlgorithm.search(problemInfo);
        System.out.println(problemSolution.toString());
        for (int i = 0; i < problemSolution.getKnapsacks().length; i++) {
            System.out.println("Solution: WeightCapacity: " + problemSolution.getKnapsacks()[i].getWeightCapacity()+ ", Value: " + problemSolution.getKnapsacks()[i].getValue() + ", weight: " + problemSolution.getKnapsacks()[i].getWeightCurrent() + ", nbrOfITems: " +problemSolution.getKnapsacks()[i].getItems().size());
        }




    }




}
