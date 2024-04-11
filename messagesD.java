
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class messagesD {

	// contains all the elements
	BorderPane pane2;
	// for the buttons on the left column
	VBox layoutBox2, searchList, messagesArea2;
	/// According to the UI layout, 3 buttons needed
	Button ndHomeBtn, pSearch, messagesBtn2, sendBtn2, search;
	// According to the UI layout, 1 messageField
	TextField ndMessageField, searchField;
	TextArea messagesND;
	Patient patient;

	public Scene messagesNDFunction(Patient p) {
		patient = p;
		// button display
		sendBtn2 = new Button("Send");
		sendBtn2.setPrefSize(40, 10);
		sendBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		pSearch = new Button("Search");
		pSearch.setPrefSize(40, 40);
		messagesBtn2 = new Button("MSSGs");
		messagesBtn2.setPrefSize(40, 40);
		ndHomeBtn = new Button("Home");
		ndHomeBtn.setPrefSize(40, 40);
		search = new Button("Search");
		search.setPrefSize(50, 20);

		// Align buttons vertically, to the left of the scene
		layoutBox2 = new VBox();
		layoutBox2.getChildren().addAll(ndHomeBtn, pSearch, messagesBtn2);
		layoutBox2.setSpacing(20);

		searchField = new TextField();
		searchField.setPromptText("Search");
		searchField.setPrefWidth(150);
		searchField.setMaxWidth(140);
		searchList = new VBox();
		search.setAlignment(Pos.BASELINE_LEFT);
		searchList.getChildren().addAll(searchField, search);
		searchList.setSpacing(10);

		// message field display
		ndMessageField = new TextField();
		ndMessageField.setPromptText("Write your message here");
		ndMessageField.setPrefWidth(400);
		ndMessageField.setAlignment(Pos.BASELINE_LEFT);

		// Create an HBox to layout the TextField and Button horizontally
		HBox hbox = new HBox();
		HBox hbox2 = new HBox(40);
		// hbox.getChildren().addAll(pMessageField, sendBtn);
		hbox.setAlignment(Pos.CENTER_RIGHT);

		// hbox.setSpacing(10); // Add some spacing between the TextField and Button

		hbox.getChildren().addAll(ndMessageField, sendBtn2);

		messagesND = new TextArea();
		messagesND.setPrefHeight(500);
		messagesND.setPrefWidth(400);
		messagesND.setEditable(false);
		displayPatientMessages();
		messagesArea2 = new VBox();

		messagesArea2.getChildren().add(messagesND);
		hbox2.getChildren().addAll(searchList, messagesArea2);

		// Create a StackPane to overlay the TextField and Button
		StackPane root2 = new StackPane();
		root2.getChildren().addAll(hbox);
		root2.setAlignment(Pos.BOTTOM_RIGHT);

		// set the layoutBox, to the left of the border pane
		pane2 = new BorderPane();
		pane2.setLeft(layoutBox2);
		pane2.setCenter(hbox2);
		pane2.setBottom(root2);

		/////////////////////////////////////////////////////////////////////
		//////////////// Functionality

		ndHomeBtn.setOnAction(e -> {
			// change to the specific home page
			pane2.getChildren().clear();
			// redirect to the designated page Doctor
			// Save patient message data
			DatabaseManager db = new DatabaseManager();
			db.editPatientFile(patient);

		});

		search.setOnAction(e -> {
			// search patient by First and Last Name
		});

		sendBtn2.setOnAction(e -> {
			// clear the text field, load the message on the message area
			// send to the patient
			// Get the text from the message field
			String message = ndMessageField.getText();

			// Add the message to the messages area
			messagesND.appendText("Doctor: " + message + "\n\n");
			// Save patient message data
			patient.addMsg("Doctor: " + message + "\n\n");
			DatabaseManager db = new DatabaseManager();
			db.editPatientFile(patient);
			// Clear the text field
			ndMessageField.clear();
		});

		//////////////////////////////////////////////////

		BorderPane.setMargin(layoutBox2, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(searchList, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(root2, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(hbox2, new Insets(10, 10, 0, 10));

		Scene ndMessageSection = new Scene(pane2, 700, 500);

		return ndMessageSection;

	}

	public void displayPatientMessages() {
		for (String msg : patient.getMessages()) {
			messagesND.appendText(msg);
		}
	}
}
