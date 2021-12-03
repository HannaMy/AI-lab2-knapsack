import java.io.*;

public class ReadInput {






            public void readItems()  {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("files/input1.txt")));
                    int nbrOfKnapsack = Integer.parseInt(reader.readLine());
                    Knapsack[] knapsacks = new Knapsack[nbrOfKnapsack];
                    for (int i = 0; i < nbrOfKnapsack; i++) {
                        int weightCapacity = Integer.parseInt(reader.readLine());
                        knapsacks[i] = new Knapsack(weightCapacity);
                    }
                    int nbrOfItems = Integer.parseInt(reader.readLine());
                    Item[] items = new Item[nbrOfItems];
                    for (int i = 0; i < nbrOfItems; i++) {
                        //String[] inputs = 
                        //items[i] = new Item();
                    }
                    //Item[] = new Item[];
                   // int[]

                }catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
}
