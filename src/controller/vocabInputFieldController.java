package controller;

import additional.Vocab;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class vocabInputFieldController implements Initializable {

    @FXML
    private JFXButton btn_delete, btn_more;

    @FXML
    private JFXTextField tf_lang1, tf_lang2;

    @FXML
    private void onEnter(ActionEvent event) {
        String l1 = tf_lang1.getText();
        String l2 = tf_lang2.getText();

        if (!l1.isEmpty() && !l2.isEmpty()) {
            Vocab voc = new Vocab(l1, l2);
        }
    }

    @FXML
    private void onClick() {
        tf_lang1.setDisable(false);
        tf_lang2.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tf_lang1.setOnAction(this::onEnter);
        tf_lang2.setOnAction(this::onEnter);
        tf_lang1.setDisable(true);
        tf_lang2.setDisable(true);
    }
}
