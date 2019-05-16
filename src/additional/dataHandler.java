package additional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dataHandler {
    public void readData(String CSV_FILE) {
        List<Vocab> data = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(CSV_FILE))) {
            while (sc.hasNextLine()) {
                data.add(getVocabFromLine(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("[-] Error reading file.\n" + e.getMessage());
        }
    }

    public Vocab getVocabFromLine(String line) {
        List<String> vals = new ArrayList<>();
        try (Scanner rowSc = new Scanner(line)) {
            rowSc.useDelimiter(",");
            while (rowSc.hasNext()) {
                vals.add(rowSc.next());
            }
        } catch (Exception e) {
            System.out.println("[-] Error getting data from Line.\n" + e.getMessage());
        }

        return new Vocab(vals.get(0), vals.get(1));
    }

    public void writeData(List<Vocab> data, String name) {
        try (PrintWriter writer = new PrintWriter(new File("src/" + name + ".csv"))) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < data.size(); i++) {
                sb.append(data.get(i).getVocab());
                sb.append("\n");
            }

            writer.write(sb.toString());
            System.out.println("[+] Successfully wrote to file.");
        } catch (FileNotFoundException e) {
            System.out.println("[-] Error writing file.\n" + e.getMessage());
        }
    }
}
