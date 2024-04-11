import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter; 
import java.io.BufferedWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VisitNotes {
	
	BorderPane mainPane;
	VBox UIBox, visitBox, historyBox, pastBox;
	Button homeBtn, msgBtn, saveBtn;
	Label visitNotes, patientHistory, pastVisits;
	TextField findingsField, newPrescripsField;
	
	public File patientFile;
	public Patient patient;
	
	public ArrayList<PastVisit> pastVisitsList;
	public String history;
	
	private DatabaseManager db;
	
	public Scene VisitNotesFunction(Stage primaryStage, File patientFile) {
				
		db = new DatabaseManager();
		String path = ("" + System.getProperty("user.dir") + "/src/patientDB/jb1.txt");
		patient = db.readPatientFile(path);

		//panes
		mainPane = new BorderPane();
		UIBox = new VBox();
		visitBox = new VBox();
		historyBox = new VBox();
		pastBox = new VBox();
				
		//buttons
		homeBtn = new Button("home");
		homeBtn.setPrefSize(50, 50);
		msgBtn = new Button("msg");
		msgBtn.setPrefSize(50, 50);
		saveBtn = new Button("save");
		saveBtn.setPrefSize(80, 40);
				
		//labels
		visitNotes = new Label("Visit Notes");
		visitNotes.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		patientHistory = new Label("Patient History");
		patientHistory.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		pastVisits = new Label("Past Visits");
		pastVisits.setFont(Font.font("Arial", FontWeight.BOLD, 16));
				
		//textfields
		findingsField = new TextField();
		findingsField.setText("Findings");
		newPrescripsField = new TextField();
		newPrescripsField.setText("New Prescriptions");
				
		//uibox
		UIBox.setSpacing(20);
		UIBox.getChildren().addAll(homeBtn, msgBtn);
				
		//historybox
		historyBox.setStyle("-fx-border-color: black");
		historyBox.setSpacing(1);
		historyBox.getChildren().add(new Text(history));
		    
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
				
		//pastbox
		pastBox.setStyle("-fx-border-color: black");
		pastBox.setSpacing(1);
		for(int i = 0; i < patient.pastVisits.size(); i++) {
		      PastVisit temp = patient.pastVisits.get(i);
		      pastBox.getChildren().add(new Text("Findings:"));
		      pastBox.getChildren().add(new Text(temp.findings));
		      pastBox.getChildren().add(new Text("New prescriptions:"));
		      for(int j = 0; j < temp.prescriptions.size(); j++) {
		        pastBox.getChildren().addAll(new Text(temp.prescriptions.get(j)));
		      }
		    }
				
		//visitBox
		visitBox.setSpacing(5);
		visitBox.getChildren().addAll(visitNotes, findingsField, newPrescripsField, saveBtn, patientHistory,
				historyBox, pastVisits, pastBox);	    
				
		mainPane.setLeft(UIBox);
		mainPane.setCenter(visitBox);
				
		BorderPane.setMargin(UIBox, new Insets(0, 10, 0, 0));
		BorderPane.setMargin(visitBox, new Insets(0, 10, 10, 0));
			
		homeBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//take to doctor view
				
				
			}
		});
		
		msgBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//take to messagesD
				
				
			}
		});
		
		
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//save				
				
				String findings = findingsField.getText();
				String newPrescription = newPrescripsField.getText();
				
				PastVisit pv = new PastVisit();
		        pv.changeFindings(findings);
		        pv.addPrescription(newPrescription);
		        
		        patient.pastVisits.add(pv);
				
		        db.editPatientFile(patient);
		        
		     //   System.out.println(patient)
			}
		});
		
		
		Scene visitNotesScene = new Scene(mainPane, 700, 500);
		return visitNotesScene;
		
	}
	
}
