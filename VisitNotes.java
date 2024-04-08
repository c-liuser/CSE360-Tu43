import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VisitNotes {
	
	BorderPane mainPane;
	VBox UIBox, visitBox, historyBox, pastBox;
	Button homeBtn, msgBtn, saveBtn;
	Label visitNotes, patientHistory, healthIssues, prescriptions, immunizationHistory, pastVisits, findings, newPrescriptions;
	TextField findingsField, newPrescripsField, issuesField, prescriptionsField, immunizationField, oldFindingsField, oldPrescripsField;
	
	public Scene VisitNotesFunction(Stage primaryStage) {
				
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
		saveBtn.setPrefSize(100, 50);
				
		//labels
		visitNotes = new Label("Visit Notes");
		visitNotes.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		patientHistory = new Label("Patient History");
		patientHistory.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		healthIssues = new Label("Health Issues");
		healthIssues.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		prescriptions = new Label("Prescriptions");
		prescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		immunizationHistory = new Label("Immunization History");
		immunizationHistory.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		pastVisits = new Label("Past Visits");
		pastVisits.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		findings = new Label("Findings");
		findings.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		newPrescriptions = new Label("New Prescriptions");
		newPrescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				
		//textfields
		findingsField = new TextField();
		findingsField.setText("Findings");
		newPrescripsField = new TextField();
		newPrescripsField.setText("New Prescriptions");
		issuesField = new TextField();
		prescriptionsField = new TextField();
		immunizationField = new TextField();
		oldFindingsField = new TextField();
		oldPrescripsField = new TextField();
				
		//uibox
		UIBox.setSpacing(20);
		UIBox.getChildren().addAll(homeBtn, msgBtn);
				
		//historybox
		historyBox.setStyle("-fx-border-color: black");
		historyBox.setSpacing(5);
		historyBox.getChildren().addAll(healthIssues, issuesField, prescriptions, prescriptionsField, 
				immunizationHistory, immunizationField);
				
		//pastbox
		pastBox.setStyle("-fx-border-color: black");
		pastBox.setSpacing(5);
		pastBox.getChildren().addAll(findings, oldFindingsField, newPrescriptions, oldPrescripsField);
				
		//visitBox
		visitBox.setSpacing(5);
		visitBox.getChildren().addAll(visitNotes, findingsField, newPrescripsField, patientHistory,
				historyBox, pastVisits, pastBox, saveBtn);
				
		mainPane.setLeft(UIBox);
		mainPane.setCenter(visitBox);
				
		BorderPane.setMargin(UIBox, new Insets(0, 10, 0, 0));
		BorderPane.setMargin(visitBox, new Insets(0, 10, 10, 0));
			
		Scene visitNotesScene = new Scene(mainPane, 700, 500);
		return visitNotesScene;
		
	}
}
