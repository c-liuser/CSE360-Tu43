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
	
	public Scene VisitNotesFunction(Stage primaryStage) {
				
		//panes
		BorderPane mainPane = new BorderPane();
		VBox UIBox = new VBox();
		VBox visitBox = new VBox();
		VBox historyBox = new VBox();
		VBox pastBox = new VBox();
				
		//buttons
		Button homeBtn = new Button("home");
		homeBtn.setPrefSize(50, 50);
		Button msgBtn = new Button("msg");
		msgBtn.setPrefSize(50, 50);
				
		//labels
		Label visitNotes = new Label("Visit Notes");
		visitNotes.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		Label patientHistory = new Label("Patient History");
		patientHistory.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		Label healthIssues = new Label("Health Issues");
		healthIssues.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label prescriptions = new Label("Prescriptions");
		prescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label immunizationHistory = new Label("Immunization History");
		immunizationHistory.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label pastVisits = new Label("Past Visits");
		pastVisits.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		Label findings = new Label("Findings");
		findings.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Label newPrescriptions = new Label("New Prescriptions");
		newPrescriptions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				
		//textfields
		TextField findingsField = new TextField();
		TextField newPrescripsField = new TextField();
		TextField issuesField = new TextField();
		TextField prescriptionsField = new TextField();
		TextField immunizationField = new TextField();
		TextField oldFindingsField = new TextField();
		TextField oldPrescripsField = new TextField();
				
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
				historyBox, pastVisits, pastBox);
				
		mainPane.setLeft(UIBox);
		mainPane.setCenter(visitBox);
				
		BorderPane.setMargin(UIBox, new Insets(0, 10, 0, 0));
		BorderPane.setMargin(visitBox, new Insets(0, 10, 10, 0));
			
		Scene visitNotesScene = new Scene(mainPane, 700, 500);
		return visitNotesScene;
		
	}
}
