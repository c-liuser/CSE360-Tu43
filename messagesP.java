package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class messagesP {

	// contains all the elements
	BorderPane pane;
	// for the buttons on the left column
	VBox layoutBox, messagesArea;
	/// According to the UI layout, 3 buttons needed
	Button patientHomeBtn, sendBtn, messagesBtn;
	// According ot the UI layout, 1 messageField
	TextField pMessageField;
	TextArea messagesP;
	Patient patient;

	public Scene messagesPFunction(Stage primaryStage, Patient p) {

		patient = p;

		// button display
		sendBtn = new Button("Send");
		sendBtn.setPrefSize(40, 10);
		sendBtn.setAlignment(Pos.BOTTOM_RIGHT);
		messagesBtn = new Button("MSSGs");
		messagesBtn.setPrefSize(40, 40);
		patientHomeBtn = new Button("Home");
		patientHomeBtn.setPrefSize(40, 40);

		// Align buttons vertically, to the left of the scene
		layoutBox = new VBox();
		layoutBox.getChildren().addAll(patientHomeBtn, messagesBtn);
		layoutBox.setSpacing(20);

		// message field display
		pMessageField = new TextField();
		pMessageField.setPromptText("Write your message here");
		pMessageField.setPrefWidth(580);
		pMessageField.setAlignment(Pos.BASELINE_LEFT);

		// Create an HBox to layout the TextField and Button horizontally
		HBox hbox = new HBox();
		// hbox.getChildren().addAll(pMessageField, sendBtn);
		hbox.setAlignment(Pos.CENTER_RIGHT);

		// hbox.setSpacing(10); // Add some spacing between the TextField and Button

		hbox.getChildren().addAll(pMessageField, sendBtn);

		messagesP = new TextArea();
		messagesP.setPrefHeight(400);
		messagesP.setPrefWidth(340);
		messagesP.setEditable(false);
		messagesArea = new VBox();
		displayPatientMessages();

		// Align the text to the right
		// messagesP.setStyle("-fx-text-alignment: right;");

		messagesArea.getChildren().add(messagesP);

		/////////////////////////////////////////////////////////////////////
		//////////////// Functionality

		patientHomeBtn.setOnAction(e -> {
			// change to patient home
			pane.getChildren().clear();
			// redirect to the patient home view
			DatabaseManager db = new DatabaseManager();
			db.editPatientFile(patient);
		});

		messagesBtn.setOnAction(e -> {
			// Load the messages page
		});

		sendBtn.setOnAction(e -> {
			// clear the text field, load the message on the message area
			// send to doctor & nurse

			// Get the text from the message field
			String message = pMessageField.getText();

			// Add the message to the messages area
			messagesP.appendText("Me: " + message + "\n");
			patient.addMsg("Me: " + message + "\n");
			// Clear the text field
			pMessageField.clear();

		});

		//////////////////////////////////////////////////

		// Create a StackPane to overlay the TextField and Button
		StackPane root = new StackPane();
		root.getChildren().addAll(hbox);
		// set the layoutBox, to the left of the border pane
		pane = new BorderPane();
		pane.setLeft(layoutBox);
		pane.setBottom(root);
		pane.setCenter(messagesP);

		BorderPane.setMargin(layoutBox, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(root, new Insets(10, 10, 10, 10));
		BorderPane.setMargin(messagesP, new Insets(10, 10, 0, 10));

		Scene pMessageSection = new Scene(pane, 700, 500);

		return pMessageSection;

	}

	public void displayPatientMessages() {
		for (String msg : patient.getMessages()) {
			messagesP.appendText(msg);
		}
	}
}
