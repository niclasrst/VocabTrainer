package additional;

import java.util.ArrayList;
import java.util.List;

public class Dataset {
    ArrayList<Vocab> data;
    dataHandler handler;
    String name;

    public Dataset(String name) {
        this.name = name;
        this.data = new ArrayList<>();
        this.handler = new dataHandler();
    }

    public void saveDataset() { handler.writeData(this.data, this.name); }
    public List<Vocab> readDataset() { return handler.readData("src/" + this.name + ".csv"); }
}
