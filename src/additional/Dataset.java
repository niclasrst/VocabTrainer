package additional;

import java.util.ArrayList;
import java.util.List;

public class Dataset {
    public static ArrayList<Vocab> data;
    public dataHandler handler;
    public String name;
    public boolean chosen;

    public Dataset(String name) {
        this.name = name;
        this.data = new ArrayList<>();
        this.handler = new dataHandler();
        this.chosen = false;
    }

    public void saveDataset() { handler.writeData(this.data, this.name); }
    public List<Vocab> readDataset() { return handler.readData("src/" + this.name + ".csv"); }
}
