package application;

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

public class messagesN {

	// contains all the elements
	BorderPane pane2;
	// for the buttons on the left column
	VBox layoutBox2, searchList, messagesArea2;
	/// According to the UI layout, 3 buttons needed
	Button nHomeBtn, pSearch, messagesBtn2, sendBtn2, search;
	// According to the UI layout, 1 messageField
	TextField nMessageField, searchField;
	TextArea messagesN;
	Patient patient;

	public Scene messagesNFunction(Stage primaryStage, Patient p) {
		patient = p;
		// button display
		sendBtn2 = new Button("Send");
		sendBtn2.setPrefSize(40, 10);
		sendBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		pSearch = new Button("Search");
		pSearch.setPrefSize(40, 40);
		messagesBtn2 = new Button("MSSGs");
		messagesBtn2.setPrefSize(40, 40);
		nHomeBtn = new Button("Home");
		nHomeBtn.setPrefSize(40, 40);
		search = new Button("Search");
		search.setPrefSize(50, 20);

		// Align buttons vertically, to the left of the scene
		layoutBox2 = new VBox();
		layoutBox2.getChildren().addAll(nHomeBtn, pSearch, messagesBtn2);
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
		nMessageField = new TextField();
		nMessageField.setPromptText("Write your message here");
		nMessageField.setPrefWidth(400);
		nMessageField.setAlignment(Pos.BASELINE_LEFT);

		// Create an HBox to layout the TextField and Button horizontally
		HBox hbox = new HBox();
		HBox hbox2 = new HBox(40);
		// hbox.getChildren().addAll(pMessageField, sendBtn);
		hbox.setAlignment(Pos.CENTER_RIGHT);

		// hbox.setSpacing(10); // Add some spacing between the TextField and Button

		hbox.getChildren().addAll(nMessageField, sendBtn2);

		messagesN = new TextArea();
		messagesN.setPrefHeight(500);
		messagesN.setPrefWidth(400);
		messagesN.setEditable(false);
		displayPatientMessages();
		messagesArea2 = new VBox();

		messagesArea2.getChildren().add(messagesN);
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

		nHomeBtn.setOnAction(e -> {
			// change to the specific home page
			pane2.getChildren().clear();
			// redirect to the designated page Nurse
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
			String message = nMessageField.getText();

			// Add the message to the messages area
			messagesN.appendText("Nurse: " + message + "\n\n");
			patient.addMsg("Nurse: " + message + "\n\n");
			// Clear the text field
			nMessageField.clear();
		});

		//////////////////////////////////////////////////

		BorderPane.setMargin(layoutBox2, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(searchList, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(root2, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(hbox2, new Insets(10, 10, 0, 10));

		Scene nMessageSection = new Scene(pane2, 700, 500);

		return nMessageSection;

	}

	private void displayPatientMessages() {
		for (String msg : patient.getMessages()) {
			messagesN.appendText(msg);
		}
	}
}
