package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class trainVocabController implements Initializable {

    @FXML
    private AnchorPane pnl_train_input;

    @FXML
    private JFXButton btn_enter_guess;

    @FXML
    private JFXTextField tf_guess;

    @FXML
    private JFXProgressBar progressBar;

    private void chooseData() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
