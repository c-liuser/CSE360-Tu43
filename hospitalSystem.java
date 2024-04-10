/*
 * CSE360 Project
 * Team Tu43
 * Team members: Daniel Chang, Cole Liu, Josh Ebe, Harsh Vassaram, Arvin Edouard
 * Main coder: Daniel Chang
 */
package application;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/*import javafx.event.ActionEvent;
import javafx.event.EventHandler;*/
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
//import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
/*import javafx.geometry.VPos;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
*/
import javafx.scene.text.FontWeight;

public class hospitalSystem extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        System.out.println("opened");
        primaryStage.setTitle("CSE360 Project");

        LoginPage login = new LoginPage();
        Scene scene = login.getScene();
        primaryStage.setScene(scene);
        // // Titles
        // Text title1 = new Text("Doctor/Nurse Portal");
        // title1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        // Text title2 = new Text("Patient Portal");
        // title2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        //
        // // Horizontal Box
        // HBox hbox = new HBox(10);
        // hbox.setPadding(new Insets(50));
        // hbox.setAlignment(Pos.TOP_CENTER);
        //
        // HBox smallhbox = new HBox(10);
        //
        // // Vertical Box 1
        // VBox vbox1 = new VBox(10);
        // vbox1.setPrefWidth(200);
        // vbox1.setPadding(new Insets(15));
        // VBox vbox3 = new VBox(10);
        // vbox3.setPrefWidth(200);
        // vbox3.setPadding(new Insets(15));
        //
        // // Button
        // Button button1 = new Button("Sign-in");
        // Button button2 = new Button("Sign-in");
        // Button button3 = new Button("Sign-up");
        //
        // // TextFields
        // TextField field1 = new TextField();
        // field1.setPromptText("Username");
        // TextField field2 = new TextField();
        // field2.setPromptText("Password");
        //
        // TextField field3 = new TextField();
        // field3.setPromptText("Username");
        // TextField field4 = new TextField();
        // field4.setPromptText("Password");
        //
        // TextField testOutput = new TextField();
        // testOutput.setPromptText("for testing only");
        //
        // // Separator
        // Separator sep = new Separator();
        // sep.setOrientation(Orientation.VERTICAL);
        // sep.setHalignment(HPos.RIGHT);
        //
        // // add to vboxes
        // vbox1.getChildren().addAll(title1, field1, field2, button1);
        // vbox1.setStyle("-fx-border-color: black");
        // vbox3.getChildren().addAll(title2, field3, field4, smallhbox);
        // vbox3.setStyle("-fx-border-color: black");
        //
        // // add to hbox
        // hbox.getChildren().add(vbox1);
        // hbox.getChildren().add(vbox3);
        // smallhbox.getChildren().addAll(button2, button3);
        //
        // // implement button events
        // button3.setOnAction(new EventHandler<>() {
        // public void handle(ActionEvent event) {
        // String username = field3.getText();
        // String password = field4.getText();
        // Patient newUser = new Patient(username, password);
        // testPatients.add(newUser);
        // if (testPatients.get(testPatients.size() - 1).getUser() == username
        // && testPatients.get(testPatients.size() - 1).getPass() == password) {
        // testOutput.setText("Sign-up successful!");
        // } else {
        // testOutput.setText("Sign-up Unsuccessful. Please try again!");
        // }
        // }
        // });
        // button2.setOnAction(new EventHandler<>() {
        // public void handle(ActionEvent event) {
        // String username = field3.getText();
        // String password = field4.getText();
        // for (int i = 0; i < testPatients.size(); i++) {
        // if (username.equals(testPatients.get(i).getUser())) {
        // if (password.equals(testPatients.get(i).getPass())) {
        // testOutput.setText("Success");
        // } else {
        // testOutput.setText("Wrong Password");
        // }
        // } else
        // testOutput.setText("User not found!");
        // }
        // }
        // });
        //
        // // changes to vbox
        // vbox3.getChildren().add(testOutput);
        File f = new File("./src/patientDB/aredou041720.txt");
        PatientPortal portal = new PatientPortal();
        LoginPage login = new LoginPage();
        Scene scene = new Scene(login.screen, 700, 500);
        login.scene = scene;
        login.stage = primaryStage;
        primaryStage.setScene(scene);
        // primaryStage.setScene(portal.PatientPortalInit(f));
        primaryStage.show();

        // to show intakeForm (temp)
        // IntakeForm intakeForm = new IntakeForm();
        // primaryStage.setScene(intakeForm.IntakeFormFunction(primaryStage));
        // primaryStage.show();

        // to show visitnotes (temp)
        // VisitNotes visitNotes = new VisitNotes();
        // primaryStage.setScene(visitNotes.VisitNotesFunction(primaryStage));
        // primaryStage.show();

        // show the patient message view
        // messagesP pMessages = new messagesP();
        // primaryStage.setScene(pMessages.messagesPFunction(primaryStage));
        // primaryStage.show();

        // show the nurse/doctor view
        // messagesND ndMessages = new messagesND();
        // primaryStage.setScene(ndMessages.messagesNDFunction(primaryStage));
        // primaryStage.show();
    }
}
