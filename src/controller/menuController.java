package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class menuController implements Initializable {

    @FXML
    private Pane pnl_datasets, pnl_train, pnl_test, pnl_settings;

    @FXML
    private JFXButton btn_datasets, btn_train, btn_test, btn_settings;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_datasets) {
            pnl_datasets.toFront();
        } else if (event.getSource() == btn_train) {
            pnl_train.toFront();
        } else if (event.getSource() == btn_test) {
            pnl_test.toFront();
        } else if (event.getSource() == btn_settings) {
            pnl_settings.toFront();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
