package controller;

import additional.Vocab;
import additional.datasetHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class trainVocabController implements Initializable {
    private static Vocab choice = chooseVocab(new File("src/one.csv"));
    private static Vocab last = choice;
    private double p = 0.05;

    @FXML
    private AnchorPane pnl_train_input;

    @FXML
    private JFXButton btn_enter_guess;

    @FXML
    private JFXTextField tf_guess;

    @FXML
    private Label lbl_vocab, lbl_indicator, lbl_rewrite;

    @FXML
    private JFXProgressBar progressBar;

    public static Vocab chooseVocab(File f) {
        String result = null;
        Random rand = new Random();
        int n = 0;

        try {
            for (Scanner sc = new Scanner(f); sc.hasNext(); ) {
                ++n;
                String line = sc.nextLine();
                if (rand.nextInt(n) == 0)
                    result = line;
            }
        } catch (FileNotFoundException e) {
            System.out.println("[-] Error choosing data.\n" + e.getMessage());
        }

        return Vocab.fromString(result);
    }

    @FXML
    private void onAction(ActionEvent event) {
        if (event.getSource() == btn_enter_guess) {
            if (tf_guess.getText().equals(choice.l2)) {
                nextVocab();
                lbl_rewrite.setVisible(false);
                lbl_indicator.setVisible(false);
            } else {
                lbl_rewrite.setText(choice.l2);
                lbl_indicator.setVisible(true);
                lbl_rewrite.setVisible(true);
            }
        }
    }

    private void nextVocab() {
        progressBar.setProgress(p);
        tf_guess.setText("");
        tf_guess.setFocusTraversable(true);

        // TODO: 20.05.2019 Check if choice is same as last!
        last = choice;
        choice = chooseVocab(new File("src/one.csv"));
        while (last.l1 == choice.l1) {
            choice = chooseVocab(new File("src/one.csv"));
        }
        lbl_vocab.setText(choice.l1);
        p += 0.05;
    }

    @FXML
    private void onEnter(ActionEvent event) {
        if (tf_guess.getText().equals(choice.l2)) {
            nextVocab();
            lbl_rewrite.setVisible(false);
            lbl_indicator.setVisible(false);

            datasetHandler.migrate(choice, datasetHandler.dOne, datasetHandler.dTwo);
        } else {
            lbl_rewrite.setText(choice.l2);
            lbl_indicator.setVisible(true);
            lbl_rewrite.setVisible(true);
            tf_guess.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbl_vocab.setText(choice.l1);
        lbl_indicator.setVisible(false);
        lbl_rewrite.setVisible(false);
        btn_enter_guess.setOnAction(this::onAction);
        tf_guess.setOnAction(this::onEnter);
    }
}
