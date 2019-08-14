package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeSet;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GeneratorController implements Initializable{

	private TreeSet<Integer> numbers;
	private int mega;
	Random random = new Random();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton buttonGenerate;

    @FXML
    private Label labelNumber1;

    @FXML
    private Label labelNumber2;

    @FXML
    private Label labelNumber3;

    @FXML
    private Label labelNumber4;

    @FXML
    private Label labelNumber5;

    @FXML
    private Label labelNumberMega;
    
    @FXML
    private Label labelWelcome;
    
    @FXML
    private JFXButton buttonResults;

    private ArrayList<String> res = new ArrayList<>();

	ArrayList<Label> labels = new ArrayList<Label>();

    //Method that generates random numbers
	private void generate() {
		numbers = new TreeSet<Integer>();
		this.mega = random.nextInt(25)+1;
		while(this.numbers.size()<5){
			this.numbers.add(random.nextInt(69)+1);
		}		
//		this.numbers = numbers;
		this.mega = random.nextInt(25)+1;
	    addResult(this.numbers, this.mega);
			}
	
	//Method to add result to Result windows
	private void addResult(TreeSet<Integer> numbers2, int mega2) {
		this.res.add(numbers2+" PowerBall: "+mega2);
		System.out.println(this.res.get(res.size()-1));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//array of labels
		labels.add(labelNumber1);
		labels.add(labelNumber2);
		labels.add(labelNumber3);
		labels.add(labelNumber4);
		labels.add(labelNumber5);	
		
		buttonResults.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Showing Results!");
				result();
				}
			
				
				private void result() {
					
					buttonResults.getScene().getWindow().hide();
					
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/application/Results.fxml"));
					try {
						loader.load();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Parent root = loader.getRoot();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Results");
											
					ResultsController resultsController = loader.getController();
					resultsController.setText(res);
					
					stage.show();
				}
			});
										
		
		buttonGenerate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// Message when button clicked! And printing TreeSet array
				System.out.println("Generate button was clicked!");
				generate();
												
					
				//iterator for array of generated numbers, and displaying them on the screen
				Iterator<Integer> it = numbers.iterator();				
				for(int i=0;i<labels.size();i++){
					labels.get(i).setText(Integer.toString(it.next()));
					it.hasNext();
					}
				labelNumberMega.setText(Integer.toString(mega));
			}		
		});
	}
	
}
