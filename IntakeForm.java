import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.ArrayList;

public class IntakeForm {
	
	BorderPane mainPane;
	VBox intakeBox, UIBox, historyBox, visitsBox;
	//HBox visitsBox;
	Button homeBtn, msgBtn, saveBtn;
	Label intakeFormLabel, intakeFormHistory, intakeFormPastVisits; 
	CheckBox over12;
	TextField intakeHeight, intakeWeight, intakeBodyTemp, intakeBloodPressure, intakeAllergies, intakeHealthConcerns;
	
	public Scene scene;
	public Stage stage;
	
	public File patientFile;
	public Patient patient;
	
	public ArrayList<PastVisit> pastVisitsList;
	public History history;
	
	private DatabaseManager db;

	
	public Scene IntakeFormFunction(Stage primaryStage, File patientFile) {
		
		db = new DatabaseManager();
		String path = ("" + System.getProperty("user.dir") + "/src/patientDB/jb1.txt");
		patient = db.readPatientFile(path);
		
		//panes
		mainPane = new BorderPane();
		intakeBox = new VBox();
		UIBox = new VBox();
		historyBox = new VBox();
		visitsBox = new VBox();
		
		//buttons
		homeBtn = new Button("home");
		homeBtn.setPrefSize(50, 50);
		msgBtn = new Button("msg");
		msgBtn.setPrefSize(50, 50);
		saveBtn = new Button("save");
		saveBtn.setPrefSize(80, 40);
				
		//labels
		intakeFormLabel = new Label("Intake Form");
		intakeFormLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		intakeFormHistory = new Label("Patient History");
		intakeFormHistory.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		intakeFormPastVisits = new Label("Past Visits");
		intakeFormPastVisits.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		
		//checkbox
		over12 = new CheckBox("Over 12");
				
		//textfields
		intakeHeight = new TextField("Height");
		intakeWeight = new TextField("Weight");		
		intakeBodyTemp = new TextField("Body Temperature");
		intakeBloodPressure = new TextField("Blood Pressure");
		intakeAllergies = new TextField("Allergies");
		intakeHealthConcerns = new TextField("Health Concerns");
				
		//uibox
		UIBox.setSpacing(20);
		UIBox.getChildren().addAll(homeBtn, msgBtn);
				
		//historybox
		historyBox.setStyle("-fx-border-color: black");
		historyBox.setSpacing(1);
		
		historyBox.getChildren().add(new Text("History:"));
	    for(int i = 0; i < patient.hist.healthIssues.size(); i++) {
	        historyBox.getChildren().add(new Text(patient.hist.healthIssues.get(i)));
	    }
	    historyBox.getChildren().add(new Text("Prescriptions:"));
	    for(int i = 0; i < patient.hist.prescrips.size(); i++) {
	        historyBox.getChildren().add(new Text(patient.hist.prescrips.get(i)));
	    }
	    historyBox.getChildren().add(new Text("Immunization History:"));
	    for(int i = 0; i < patient.hist.immunizations.size(); i++) {
	        historyBox.getChildren().add(new Text(patient.hist.immunizations.get(i)));
	    }
		
				
		//visitsbox
		visitsBox.setStyle("-fx-border-color: black");
		visitsBox.setSpacing(1);

		for(int i = 0; i < patient.pastVisits.size(); i++) {
		      PastVisit temp = patient.pastVisits.get(i);
		      visitsBox.getChildren().add(new Text("Findings:"));
		      visitsBox.getChildren().add(new Text(temp.findings));
		      visitsBox.getChildren().add(new Text("New prescriptions:"));
		      for(int j = 0; j < temp.prescriptions.size(); j++) {
		        visitsBox.getChildren().addAll(new Text(temp.prescriptions.get(j)));
		      }
		    }
				
		//intakebox
		intakeBox.setSpacing(5);
		intakeBox.getChildren().addAll(intakeFormLabel, over12, intakeHeight,intakeWeight,intakeBodyTemp,
				intakeBloodPressure, intakeAllergies, intakeHealthConcerns, saveBtn, intakeFormHistory, historyBox,
				intakeFormPastVisits, visitsBox);
				
		//mainpane
		mainPane.setLeft(UIBox); 
		mainPane.setCenter(intakeBox);
				
		BorderPane.setMargin(UIBox, new Insets(0, 10, 0, 0));
		BorderPane.setMargin(intakeBox, new Insets(0, 10, 10, 0));
		
		homeBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//take to nurse view
				
				
			}
		});
		
		msgBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//take to messagesND
				
				
			}
		});
		
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//save				
				
				if (over12.isSelected()) {
					int height = Integer.parseInt(intakeHeight.getText());
					int weight = Integer.parseInt(intakeWeight.getText());   
					int temp = Integer.parseInt(intakeBodyTemp.getText());
					int bloodPressure = Integer.parseInt(intakeBloodPressure.getText());
					String allergies = intakeAllergies.getText();
					String concerns = intakeHealthConcerns.getText();
					
					patient.setHeight(height);
					patient.setWeight(weight);
					patient.setTemp(temp);
					patient.setPressure(bloodPressure);
					patient.addAllergy(allergies);
					patient.addConcern(concerns);
					
			        db.editPatientFile(patient);
				}
				
				else {
					System.out.println("Under 12");
				}
			}
		});
		
		
		Scene intakeFormScene = new Scene(mainPane, 800, 600);
		return intakeFormScene;
	}
}
