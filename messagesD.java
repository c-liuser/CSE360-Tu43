
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Window;

public class messagesD {

  // contains all the elements
  BorderPane pane2;
  // for the buttons on the left column
  VBox layoutBox2, messagesArea2;
  /// According to the UI layout, 3 buttons needed
  Button nHomeBtn, sendBtn2, backBT;
  // According to the UI layout, 1 messageField
  TextField nMessageField;
  TextArea messagesN;
  Patient patient;
  Scene nMessageSection;


	public Scene messagesNDFunction(Patient p) {
      patient = p;
      // button display
//    sendBtn2 = new Button("Send");
//    sendBtn2.setPrefSize(40, 10);
//    sendBtn2.setAlignment(Pos.BOTTOM_RIGHT);
//    pSearch = new Button("Search");
//    pSearch.setPrefSize(40, 40);
//    messagesBtn2 = new Button("MSSGs");
//    messagesBtn2.setPrefSize(40, 40);
//    nHomeBtn = new Button("Home");
//    nHomeBtn.setPrefSize(40, 40);
//    search = new Button("Search");
//    search.setPrefSize(50, 20);
      
      sendBtn2 = new Button("Send");
      sendBtn2.setPrefSize(60, 10);
      sendBtn2.setAlignment(Pos.BOTTOM_RIGHT);
          // back button
      backBT = new Button("BACK");
      backBT.setPrefSize(100, 50);
      backBT.setOnAction(new EventHandler<>() {
              public void handle(ActionEvent event) {
                  doctorView nurseV = new doctorView();
                  Window w = nMessageSection.getWindow();
                  if (w instanceof Stage) {
                      Stage s = (Stage) w;
                      s.setScene(nurseV.getScene());
                  }
              }
          });
          // home button
      nHomeBtn = new Button("Log out");
      nHomeBtn.setPrefSize(100, 50);
      nHomeBtn.setOnAction(new EventHandler<>() {
              public void handle(ActionEvent event) {
                  LoginPage home = new LoginPage();
                  Window w = nMessageSection.getWindow();
                  if (w instanceof Stage) {
                      Stage s = (Stage) w;
                      s.setScene(home.getScene());
                  }
              }
          });


      // Align buttons vertically, to the left of the scene
      layoutBox2 = new VBox();
      layoutBox2.getChildren().addAll(nHomeBtn, backBT);
      layoutBox2.setSpacing(20);

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

      messagesArea2 = new VBox();

      messagesArea2.getChildren().add(messagesN);
      hbox2.getChildren().addAll(messagesArea2);

      // Create a StackPane to overlay the TextField and Button
      StackPane root2 = new StackPane();
      root2.getChildren().addAll(hbox);
      root2.setAlignment(Pos.BOTTOM_RIGHT);

      // set the layoutBox, to the left of the border pane
      pane2 = new BorderPane();
      pane2.setLeft(layoutBox2);
      pane2.setCenter(hbox2);
      pane2.setBottom(root2);

      // Display saved messages
      displayPatientMessages();
      /////////////////////////////////////////////////////////////////////
      //////////////// Functionality

  
      sendBtn2.setOnAction(e -> {
          // clear the text field, load the message on the message area
          // send to the patient
          // Get the text from the message field
          String message = nMessageField.getText();

          // Add the message to the messages area
          messagesN.appendText("Doctor: " + message + "\n\n");
          // Save patient message data
          patient.addMsg("Doctor: " + message + "\n\n");
          DatabaseManager db = new DatabaseManager();
          db.editPatientFile(patient);
          // Clear the text field
          nMessageField.clear();
      });

      //////////////////////////////////////////////////

      BorderPane.setMargin(layoutBox2, new Insets(10, 10, 10, 10));
      BorderPane.setMargin(root2, new Insets(10, 10, 10, 10));
      BorderPane.setMargin(hbox2, new Insets(10, 10, 0, 10));

      nMessageSection = new Scene(pane2, 700, 500);

      return nMessageSection;

	}

	public void displayPatientMessages() {
	    for (int i = 0; i < patient.getMessages().size(); i++) {
          messagesN.appendText(patient.getMessages().get(i));
      }
	}
}
