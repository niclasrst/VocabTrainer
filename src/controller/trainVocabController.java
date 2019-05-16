package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class trainVocabController implements Initializable {

    @FXML
    private AnchorPane pnl_choose_data, pnl_train_input;

    @FXML
    private JFXButton btn_enter_guess;

    @FXML
    private JFXTextField tf_guess;

    @FXML
    private ProgressBar progressBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
