package additional;

import java.util.*;

public class datasetHandler {
    public static Dataset dOne = new Dataset("one");
    public static Dataset dTwo = new Dataset("two");
    public static Dataset dThree = new Dataset("three");

    public static void init() {
        ArrayList<Vocab> temp = dOne.readDataset();
        for (Vocab v : temp) {
            dOne.data.add(v);
            System.out.println(v.getVocab());
        }

        System.out.println(" ");

        ArrayList<Vocab> temp1 = dTwo.readDataset();
        for (Vocab v1 : temp1) {
            dTwo.data.add(v1);
            System.out.println(v1.getVocab());
        }

        System.out.println(" ");

        ArrayList<Vocab> temp2 = dThree.readDataset();
        for (Vocab v2 : temp2) {
            dThree.data.add(v2);
            System.out.println(v2.getVocab());
        }
    }

    public static void migrate(Vocab v, Dataset from, Dataset to) {
        to.data.add(v);
        // TODO: 2019-05-29 Element cant be removed ??
        from.data.remove(v);

        from.saveDataset();
        to.saveDataset();
        System.out.println("[+] Migrated");
    }
}
