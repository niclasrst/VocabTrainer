package controller;

import additional.datasetHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class datasetLayoutController implements Initializable {
    private int idx = 1;

    @FXML
    private JFXButton btn_1, btn_2, btn_3, btn_done, btn_add_field;

    @FXML
    private GridPane pnl_btns;

    @FXML
    public VBox pnl_vbox;

    @FXML
    private Pane pnl_vocab_input, pnl_add;

    @FXML
    private ScrollPane scroll_pane;

    @FXML
    private void actionHandler(ActionEvent event) throws IOException {
        if (event.getSource() == btn_done) { pnl_add.toFront(); pnl_vbox.getChildren().remove(0, idx); idx = 0; System.out.println("Done"); }
        if (event.getSource() == btn_done) { pnl_add.toFront(); }
        if (event.getSource() == btn_add_field) { pnl_vbox.getChildren().add(idx, new FXMLLoader().load(getClass().getResource("../views/vocabInputField.fxml"))); idx++; }
    }

    @FXML
    public void onClick(ActionEvent event) {
        if (event.getSource() == btn_1) {
            pnl_vocab_input.toFront();
            datasetHandler.dOne.data = datasetHandler.dOne.readDataset();
            loadVocFields(datasetHandler.dOne.data.size());
        } else if (event.getSource() == btn_2) {
            pnl_vocab_input.toFront();
            datasetHandler.dTwo.data = datasetHandler.dTwo.readDataset();
            loadVocFields(datasetHandler.dTwo.data.size());
        } else if (event.getSource() == btn_3) {
            pnl_vocab_input.toFront();
            datasetHandler.dThree.data = datasetHandler.dThree.readDataset();
            loadVocFields(datasetHandler.dThree.data.size());
        }
    }

    public void loadVocFields(int size) {
        try {
            for (int i = 0; i < size; i++) {
                pnl_vbox.getChildren().add(idx, new FXMLLoader().load(getClass().getResource("../views/vocabInputField.fxml")));
                idx++;
            }
        } catch (IOException e) {
            System.out.println("[-] Error loading InputField fxml.\n" + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnl_btns.setAlignment(Pos.CENTER);
        pnl_btns.setHgap(15);
        pnl_btns.setVgap(15);
        scroll_pane.setContent(pnl_vbox);
        JFXScrollPane.smoothScrolling(scroll_pane);
    }
}
