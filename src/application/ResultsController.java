package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ResultsController implements Initializable{


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextArea textAreaResult;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}


	public void setText(String string) {
		textAreaResult.setText(string);		
	}

	public void setText(ArrayList<String> res) {
		Iterator<String> it = res.iterator();
		while (it.hasNext()){
			textAreaResult.appendText(it.next());;
			textAreaResult.appendText("\n");
		}
	}
	
}
