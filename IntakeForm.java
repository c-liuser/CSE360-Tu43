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
	
	public Scene IntakeFormFunction(Stage primaryStage) {
		
		//panes
		BorderPane mainPane = new BorderPane();
		VBox intakeBox = new VBox();
		VBox UIBox = new VBox();
		VBox historyBox = new VBox();
		VBox visitsBox = new VBox();
		
		//buttons
		Button homeBtn = new Button("home");
		homeBtn.setPrefSize(50, 50);
		Button msgBtn = new Button("msg");
		msgBtn.setPrefSize(50, 50);
				
		//labels
		Label intakeFormLabel = new Label("Intake Form");
		intakeFormLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		Label intakeFormHistory = new Label("Patient History");
		intakeFormHistory.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		Label intakeFormPastVisits = new Label("Past Visits");
		intakeFormPastVisits.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		Label intakeHealthIssuesLabel = new Label("Health Issues");
		intakeHealthIssuesLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label intakePrescriptionsLabel = new Label("Prescriptions");
		intakePrescriptionsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label intakeImmunizationLabel = new Label("Immunization History");
		intakeImmunizationLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label intakeFindings = new Label("Findings");
		intakeFindings.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label intakeNewPrescriptions = new Label("New Prescriptions");
		intakeNewPrescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				
		//checkbox
		CheckBox over12 = new CheckBox("Over 12");
				
		//textfields
		TextField intakeHeight = new TextField("Height");
		TextField intakeWeight = new TextField("Weight");		
		TextField intakeBodyTemp = new TextField("Body Temperature");
		TextField intakeBloodPressure = new TextField("Blood Pressure");
		TextField intakeAllergies = new TextField("Allergies");
		TextField intakeHealthConcerns = new TextField("Health Concerns");
		TextField intakeHealthIssues = new TextField();
		TextField intakePrescriptions = new TextField();
		TextField intakeImmunizationHistory = new TextField();
		TextField intakePastVisitsFindings = new TextField();
		TextField intakePastVisitsPrescriptions = new TextField();
				
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
				intakeFormPastVisits, visitsBox);
				
		//mainpane
		mainPane.setLeft(UIBox); 
		mainPane.setCenter(intakeBox);
				
		BorderPane.setMargin(UIBox, new Insets(0, 10, 0, 0));
		BorderPane.setMargin(intakeBox, new Insets(0, 10, 10, 0));
		
		Scene intakeFormScene = new Scene(mainPane, 800, 600);
		return intakeFormScene;
	}
}
