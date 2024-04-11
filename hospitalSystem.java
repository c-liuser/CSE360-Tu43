/*
 * CSE360 Project
 * Team Tu43
 * Team members: Daniel Chang, Cole Liu, Josh Ebe, Harsh Vassaram, Arvin Edouard
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
