import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class IntakeForm {
	
	BorderPane mainPane;
	VBox intakeBox, UIBox, historyBox, visitsBox;
	Button homeBtn, msgBtn, saveBtn;
	Label intakeFormLabel, intakeFormHistory, intakeFormPastVisits, intakeHealthIssuesLabel, intakePrescriptionsLabel, intakeImmunizationLabel, intakeFindings, intakeNewPrescriptions; 
	CheckBox over12;
	TextField intakeHeight, intakeWeight, intakeBodyTemp, intakeBloodPressure, intakeAllergies, intakeHealthConcerns, intakeHealthIssues, intakePrescriptions, intakeImmunizationHistory, intakePastVisitsFindings, intakePastVisitsPrescriptions;
	
	public Scene IntakeFormFunction(Stage primaryStage) {
		
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
		saveBtn.setPrefSize(100, 50);
				
		//labels
		intakeFormLabel = new Label("Intake Form");
		intakeFormLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		intakeFormHistory = new Label("Patient History");
		intakeFormHistory.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		intakeFormPastVisits = new Label("Past Visits");
		intakeFormPastVisits.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		intakeHealthIssuesLabel = new Label("Health Issues");
		intakeHealthIssuesLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		intakePrescriptionsLabel = new Label("Prescriptions");
		intakePrescriptionsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		intakeImmunizationLabel = new Label("Immunization History");
		intakeImmunizationLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		intakeFindings = new Label("Findings");
		intakeFindings.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		intakeNewPrescriptions = new Label("New Prescriptions");
		intakeNewPrescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				
		//checkbox
		over12 = new CheckBox("Over 12");
				
		//textfields
		intakeHeight = new TextField("Height");
		intakeWeight = new TextField("Weight");		
		intakeBodyTemp = new TextField("Body Temperature");
		intakeBloodPressure = new TextField("Blood Pressure");
		intakeAllergies = new TextField("Allergies");
		intakeHealthConcerns = new TextField("Health Concerns");
		intakeHealthIssues = new TextField();
		intakePrescriptions = new TextField();
		intakeImmunizationHistory = new TextField();
		intakePastVisitsFindings = new TextField();
		intakePastVisitsPrescriptions = new TextField();
				
		//uibox
		UIBox.setSpacing(20);
		UIBox.getChildren().addAll(homeBtn, msgBtn);
				
		//historybox
		historyBox.setStyle("-fx-border-color: black");
		historyBox.setSpacing(5);
		historyBox.getChildren().addAll(intakeHealthIssuesLabel, intakeHealthIssues, intakePrescriptionsLabel,
				intakePrescriptions, intakeImmunizationLabel, intakeImmunizationHistory);
				
		//visitsbox
		visitsBox.setStyle("-fx-border-color: black");
		visitsBox.setSpacing(5);
		visitsBox.getChildren().addAll(intakeFindings, intakePastVisitsFindings, intakeNewPrescriptions, 
						intakePastVisitsPrescriptions);
				
		//intakebox
		intakeBox.setSpacing(5);
		intakeBox.getChildren().addAll(intakeFormLabel, over12, intakeHeight,intakeWeight,intakeBodyTemp,
				intakeBloodPressure, intakeAllergies, intakeHealthConcerns, intakeFormHistory, historyBox,
				intakeFormPastVisits, visitsBox, saveBtn);
				
		//mainpane
		mainPane.setLeft(UIBox); 
		mainPane.setCenter(intakeBox);
				
		BorderPane.setMargin(UIBox, new Insets(0, 10, 0, 0));
		BorderPane.setMargin(intakeBox, new Insets(0, 10, 10, 0));
		
		Scene intakeFormScene = new Scene(mainPane, 800, 600);
		return intakeFormScene;
	}
}
