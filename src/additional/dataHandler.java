package additional;

import java.io.*;
import java.util.*;

public class dataHandler {
    public ArrayList<Vocab> readData(String CSV_FILE) {
        System.out.println(CSV_FILE);
        ArrayList<Vocab> data = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(CSV_FILE))) {
            while (sc.hasNextLine()) {
                data.add(getVocabFromLine(sc.nextLine()));
            }
        } catch (FileNotFoundException e) { System.out.println("[-] Error reading file.\n" + e.getMessage()); }

        return data;
    }

    public Vocab getVocabFromLine(String line) {
        List<String> vals = new ArrayList<>();

        try (Scanner rowSc = new Scanner(line)) {
            rowSc.useDelimiter(",");
            while (rowSc.hasNext()) {
                vals.add(rowSc.next());
            }
        } catch (Exception e) { System.out.println("[-] Error getting data from Line.\n" + e.getMessage()); }

        return new Vocab(vals.get(0), vals.get(1));
    }

    public void writeData(ArrayList<Vocab> data, String name) {
        try {
            File f = new File("src/" + name + ".csv");
            f.delete();
            FileWriter writer = new FileWriter(f, true);

            for (int i = 0; i < data.size(); i++) {
                writer.append(data.get(i).getVocab() + "\n");
            }

            writer.flush();
            writer.close();

            System.out.println("[+] Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("[-] Error writing file.\n" + e.getMessage());
        }
    }
}
