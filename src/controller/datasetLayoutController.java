package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class datasetLayoutController implements Initializable {

    @FXML
    private JFXButton btn_1, btn_2, btn_3, btn_4, btn_done, btn_add_field;

    @FXML
    private GridPane pnl_btns;

    @FXML
    public VBox pnl_vbox;

    @FXML
    private Pane pnl_vocab_input, pnl_add;

    @FXML
    private void actionHandler(ActionEvent event) throws IOException {
        if (event.getSource() == btn_done) { pnl_add.toFront(); }
        if (event.getSource() == btn_add_field) { pnl_vbox.getChildren().add(new FXMLLoader().load(getClass().getResource("../views/vocabInputField.fxml"))); }
    }

    @FXML
    public void onClick(ActionEvent event) {
        if (event.getSource() == btn_1) {
            System.out.println("[+] Btn 1 pressed");
            pnl_vocab_input.toFront();
        } else if (event.getSource() == btn_2) {
            System.out.println("[+] Btn 2 pressed");
            pnl_vocab_input.toFront();
        } else if (event.getSource() == btn_3) {
            System.out.println("[+] Btn 3 pressed");
            pnl_vocab_input.toFront();
        } else if (event.getSource() == btn_4) {
            System.out.println("[+] Btn 4 pressed");
            pnl_vocab_input.toFront();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnl_btns.setAlignment(Pos.CENTER);
        pnl_btns.setHgap(15);
        pnl_btns.setVgap(15);
    }
}
