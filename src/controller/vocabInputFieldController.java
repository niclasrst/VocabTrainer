package controller;

import additional.datasetHandler;
import additional.Vocab;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class vocabInputFieldController implements Initializable {
    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXTextField tf_lang1, tf_lang2;

    @FXML
    private void onEnter(ActionEvent event) {
        String l1 = tf_lang1.getText();
        String l2 = tf_lang2.getText();

        if (!l1.isEmpty() && !l2.isEmpty() && (!stringInFile(new File("src/one.csv"), l1) || !stringInFile(new File("src/one.csv"), l2))) {
            System.out.println("[+] Word not in file.");
            Vocab voc = new Vocab(l1, l2);
            datasetHandler.dOne.data.add(voc);
            datasetHandler.dOne.saveDataset();

            tf_lang1.setDisable(true);
            tf_lang2.setDisable(true);
        }
    }

    private boolean stringInFile(File f, String s) {
        try {
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(s)) { return true; }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[-] File not found.\n" + e.getMessage());
        }

        return false;
    }

    @FXML
    private void onClick() {
        tf_lang1.setDisable(!tf_lang1.isDisable());
        tf_lang2.setDisable(!tf_lang2.isDisable());
    }

    public void loadVoc(Vocab v) {
        tf_lang1.setText(v.l1);
        tf_lang2.setText(v.l2);
    }

    // TODO: 20.05.2019 Load data on open dataset to view your vocabs
    public void loadData() {
        for (Vocab v : datasetHandler.dOne.data) { loadVoc(v); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tf_lang1.setOnAction(this::onEnter);
        tf_lang2.setOnAction(this::onEnter);
        tf_lang1.setDisable(false);
        tf_lang2.setDisable(false);
    }
}
