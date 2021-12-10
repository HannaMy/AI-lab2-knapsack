import java.io.*;

public class ReadInput {


    public ProblemInfo readItems(int input) {
        try {
            String inputText = "files/input" + input + ".txt";
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputText)));
            int nbrOfKnapsack = Integer.parseInt(reader.readLine());
            Knapsack[] knapsacks = new Knapsack[nbrOfKnapsack];
            for (int i = 0; i < nbrOfKnapsack; i++) {
                int weightCapacity = Integer.parseInt(reader.readLine());
                knapsacks[i] = new Knapsack(weightCapacity);
            }
            int nbrOfItems = Integer.parseInt(reader.readLine());
            Item[] items = new Item[nbrOfItems];
            for (int i = 0; i < nbrOfItems; i++) {
                String[] inputs = reader.readLine().split(" ");
                int value = Integer.parseInt(inputs[0]);
                int weight = Integer.parseInt(inputs[1]);
                items[i] = new Item(weight, value);
            }
            ProblemInfo problemInfo = new ProblemInfo(knapsacks, items);
            return problemInfo;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
