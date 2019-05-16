package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class datasetLayoutController implements Initializable {
    private int i = 1;
    private int row = 0;
    private int count = 1;

    @FXML
    private JFXButton btn_add, btn_done, btn_add_field, btn;

    @FXML
    private GridPane pnl_btns;

    @FXML
    public VBox pnl_vbox;

    @FXML
    private Pane pnl_vocab_input, pnl_add;

    @FXML
    private void actionHandler(ActionEvent event) throws IOException {
        if (event.getSource() == btn_add && count < 8) { addBtn(); }
        if (event.getSource() == btn_done) { pnl_add.toFront(); }
        if (event.getSource() == btn_add_field) { pnl_vbox.getChildren().add(new FXMLLoader().load(getClass().getResource("../views/vocabInputField.fxml"))); }
    }

    @FXML
    public void addBtn() {
        if (i > 3) { i = 0; row++; }

        btn = new JFXButton("" + count);
        btn.setId("btn_dataset");
        btn.setPrefSize(100, 100);
        btn.setTextAlignment(TextAlignment.CENTER);
        btn.setButtonType(JFXButton.ButtonType.FLAT);
        btn.setRipplerFill(Paint.valueOf("#1dd1a1"));

        GridPane.setHalignment(btn, HPos.CENTER);
        GridPane.setValignment(btn, VPos.CENTER);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pnl_vocab_input.toFront();
            }
        });

        pnl_btns.add(btn, i, row);
        i++;
        count ++;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnl_btns.setAlignment(Pos.CENTER);
        pnl_btns.setHgap(15);
        pnl_btns.setVgap(15);
    }
}
