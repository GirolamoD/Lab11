package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    void doSimula(ActionEvent event) {
    	Model m = new Model();
    	txtResult.setText(m.process());
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
