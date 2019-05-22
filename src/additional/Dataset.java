package additional;

import java.util.ArrayList;

public class Dataset {
    public static ArrayList<Vocab> data;
    public dataHandler handler;
    public String name;

    public Dataset(String name) {
        this.name = name;
        this.data = new ArrayList<>();
        this.handler = new dataHandler();
    }

    public void saveDataset() { handler.writeData(this.data, this.name); }
    public ArrayList<Vocab> readDataset() { return handler.readData("src/" + this.name /*"one"*/ + ".csv"); }
}
