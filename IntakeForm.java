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
	
	public ArrayList<PastVisit> pastVisitsList;
	public History history;
	
	
	public Scene IntakeFormFunction(Stage primaryStage, File patientFile) {
		
		pastVisitsList = getPastVisits(patientFile);
		history = getHistory(patientFile);
		
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
		
		historyBox.getChildren().add(new Text("Health Issues:"));
		for (int i = 0; i < history.healthIssues.size(); i++) {
			historyBox.getChildren().addAll(new Text(history.healthIssues.get(i)));
		}
		historyBox.getChildren().add(new Text("Prescriptions:"));
		for (int i = 0; i < history.prescrips.size(); i++) {
			historyBox.getChildren().addAll(new Text(history.prescrips.get(i)));
		}
		historyBox.getChildren().add(new Text("Immunization History:"));
		for (int i = 0; i < history.immunizations.size(); i++) {
			historyBox.getChildren().addAll(new Text(history.immunizations.get(i)));
		}
				
		//visitsbox
		visitsBox.setStyle("-fx-border-color: black");
		visitsBox.setSpacing(1);

		for(int i = 0; i < pastVisitsList.size(); i++) {
		      PastVisit temp = pastVisitsList.get(i);
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
		
		Scene intakeFormScene = new Scene(mainPane, 800, 600);
		return intakeFormScene;
	}
	
	public ArrayList<PastVisit> getPastVisits(File f){
	    int amountOfPastVisits = 0;
	    PastVisit temp;
	    ArrayList<PastVisit> pastVisits = new ArrayList<PastVisit>();
	    try {
	      FileReader fr = new FileReader(f);
	      BufferedReader br = new BufferedReader(fr);
	      String check = "1";
	      //goes down to past visit in file
	      while(!check.equals("Past Visits")) {
	        check = br.readLine();
	      }

	      while(!check.equals("past visits done")) {
	        while(!check.equals("Findings:")) {
	          check = br.readLine();
	        }
	        pastVisits.add(new PastVisit());
	        temp = pastVisits.get(amountOfPastVisits);
	        temp.findings = br.readLine();
	        
	        while(!check.equals("New prescriptions:")) {
	          check = br.readLine();
	        }
	        while(!check.equals("")) {
	          check = br.readLine();
	          temp.prescriptions.add(check);
	        }
	        check = br.readLine();
	        amountOfPastVisits++;
	      }
	      br.close();
	      
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } 

	    return pastVisits;
	  }
	
	public History getHistory(File f) {
		History hist = new History();
		try {
			FileReader fr = new FileReader(f);
		    BufferedReader br = new BufferedReader(fr);
		    String check = "1";
		    //goes down to history in file
		    while(!check.equals("History")) {
		    	check = br.readLine();
		    }
		    
		    while (!check.equals("Past Visits")) {
		    	while (!check.equals("Health Issue:")) {
		    		check = br.readLine();
		    	}
		    	hist.addIssues(br.readLine());
		    	check = br.readLine();
		    	
		    	while (!check.equals("Precriptions:")) {
		    		check = br.readLine();
		    	}
		    	
		    	while (!check.equals("")) {
		    		check = br.readLine();
		    		hist.addPrescrip(check);
		    	}
		    	
		    	while (!check.equals("Immunization History:")) {
		    		check = br.readLine();
		    	}
		    	
		    	check = br.readLine();
		    	
		    	while (!check.equals("")) {
		    		check = br.readLine();
		    		hist.addImmunizations(check);
		    	}
		    	
		    	check = br.readLine();
		 
		    }
		    br.close();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
		     e.printStackTrace();
		}
		
		return hist;
	}	
	
	
}
