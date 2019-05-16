package additional;

import java.util.ArrayList;

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
    public void readDataset() { handler.readData("src/" + this.name); }
}
