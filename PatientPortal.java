

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PatientPortal {
  
  public BorderPane screen;
  
  public HBox menu;
  public VBox mainScreen;
  public VBox pastVisitSection;
  
  public HBox nameHbox;
  
  public GridPane patientInfo;
  
  public TextField fNameTF;
  public TextField lNameTF;
  public TextField number;
  
  public Button homeBT;
  public Button messagingBT;
  public Button editBT;
  public Button submitBT;
  
  public Label welcomeLB;
  
  public PastVisit pv;
  public ArrayList<PastVisit> pastVisitsList;
  
  public Patient patient;
  
  private DatabaseManager db;
  
  
  public Scene PatientPortalInit(String patientFile) {
    db = new DatabaseManager();
   // pv = new PastVisit();
    //pastVisitsList = pv.getPastVisits(patientFile);
    
    patient = db.readPatientFile(patientFile);
    
    welcomeLB = new Label("Welcome Patient");
    welcomeLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    
    homeBT = new Button("Home");
    messagingBT = new Button("Messages");
    editBT = new Button("Edit");
    editBT.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        editBTAction();
      }
    });
    submitBT = new Button("Submit");
    submitBT.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        submitBTAction();
      }
    });
      
    menu = new HBox();
    menu.getChildren().addAll(homeBT, messagingBT);
    menu.setAlignment(Pos.TOP_CENTER);
    
    fNameTF = new TextField(patient.getFirstName());
    fNameTF.setEditable(false);
    lNameTF = new TextField(patient.getLastName());
    lNameTF.setEditable(false);
    number = new TextField(patient.getPhone());
    number.setEditable(false);
    
    nameHbox = new HBox();
    nameHbox.getChildren().addAll(fNameTF, lNameTF);
    
    patientInfo = new GridPane();
    patientInfo.setVgap(5); 
    patientInfo.setHgap(5);  
    
    patientInfo.add(nameHbox, 0, 0);
    patientInfo.add(number, 0, 1);
    
    patientInfo.add(editBT, 1, 0);
    
    //start of past section
    pastVisitSection = new VBox(5);
    
    Label pastVisitLB = new Label("Past Visits");
    pastVisitLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    pastVisitSection.getChildren().add(pastVisitLB);
    for(int i = 0; i < patient.pastVisits.size(); i++) {
      PastVisit temp = patient.pastVisits.get(i);
      pastVisitSection.getChildren().add(new Text("Findings:"));
      pastVisitSection.getChildren().add(new Text(temp.findings));
      pastVisitSection.getChildren().add(new Text("New prescriptions:"));
      for(int j = 0; j < temp.prescriptions.size(); j++) {
        pastVisitSection.getChildren().addAll(new Text(temp.prescriptions.get(j)));
      }
    }
    
    mainScreen = new VBox(20);
    mainScreen.getChildren().addAll(welcomeLB, patientInfo, pastVisitSection);
    mainScreen.setAlignment(Pos.TOP_CENTER);
    patientInfo.setAlignment(Pos.TOP_CENTER);
    //pastVisitSection.setAlignment(Pos.TOP_CENTER);
    VBox.setMargin(pastVisitSection, new Insets(40));
    
    screen = new BorderPane();
    screen.setTop(menu);
    screen.setCenter(mainScreen);
    BorderPane.setMargin(mainScreen, new Insets(40));
    Scene patientPortal = new Scene(screen, 800, 600);
    return patientPortal;
  }
  
//  public PatientPortal(File patientFile) {
//	  pv = new PastVisit();
//	    pastVisitsList = pv.getPastVisits(patientFile);
//	    
//	    welcomeLB = new Label("Welcome Patient");
//	    welcomeLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//	    
//	    homeBT = new Button("Home");
//	    messagingBT = new Button("Messages");
//	    editBT = new Button("Edit");
//	    editBT.setOnAction(new EventHandler<ActionEvent>() {
//	      public void handle(ActionEvent event) {
//	        editBTAction();
//	      }
//	    });
//	    submitBT = new Button("Submit");
//	    submitBT.setOnAction(new EventHandler<ActionEvent>() {
//	      public void handle(ActionEvent event) {
//	        submitBTAction();
//	      }
//	    });
//	      
//	    menu = new HBox();
//	    menu.getChildren().addAll(homeBT, messagingBT);
//	    menu.setAlignment(Pos.TOP_CENTER);
//	    
//	    fNameTF = new TextField("First");
//	    fNameTF.setEditable(false);
//	    lNameTF = new TextField("Last");
//	    lNameTF.setEditable(false);
//	    number = new TextField("Number");
//	    number.setEditable(false);
//	    
//	    nameHbox = new HBox();
//	    nameHbox.getChildren().addAll(fNameTF, lNameTF);
//	    
//	    patientInfo = new GridPane();
//	    patientInfo.setVgap(5); 
//	    patientInfo.setHgap(5);  
//	    
//	    patientInfo.add(nameHbox, 0, 0);
//	    patientInfo.add(number, 0, 1);
//	    
//	    patientInfo.add(editBT, 1, 0);
//	    
//	    //start of past section
//	    pastVisitSection = new VBox(5);
//	    
//	    Label pastVisitLB = new Label("Past Visits");
//	    pastVisitLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//	    pastVisitSection.getChildren().add(pastVisitLB);
//	    for(int i = 0; i < pastVisitsList.size(); i++) {
//	      PastVisit temp = pastVisitsList.get(i);
//	      pastVisitSection.getChildren().add(new Text("Findings:"));
//	      pastVisitSection.getChildren().add(new Text(temp.findings));
//	      pastVisitSection.getChildren().add(new Text("New prescriptions:"));
//	      for(int j = 0; j < temp.prescriptions.size(); j++) {
//	        pastVisitSection.getChildren().addAll(new Text(temp.prescriptions.get(j)));
//	      }
//	    }
//	    
//	    mainScreen = new VBox(20);
//	    mainScreen.getChildren().addAll(welcomeLB, patientInfo, pastVisitSection);
//	    mainScreen.setAlignment(Pos.TOP_CENTER);
//	    patientInfo.setAlignment(Pos.TOP_CENTER);
//	    //pastVisitSection.setAlignment(Pos.TOP_CENTER);
//	    VBox.setMargin(pastVisitSection, new Insets(40));
//	    
//	    screen = new BorderPane();
//	    screen.setTop(menu);
//	    screen.setCenter(mainScreen);
//	    BorderPane.setMargin(mainScreen, new Insets(40));
//	    
//  }
  
  public void editBTAction() {
    fNameTF.setEditable(true);
    lNameTF.setEditable(true);
    number.setEditable(true);
    patientInfo.getChildren().remove(editBT);
    patientInfo.add(submitBT, 1, 0);
  }
  
  public void submitBTAction() {
    patient.setFirstName(fNameTF.getText());
    patient.setLastName(lNameTF.getText());
    patient.setPhone(number.getText());
    PastVisit past = new PastVisit();
    
    //past.findings = number.getText();
    //patient.pastVisits.add(past);
    
    db.editPatientFile(patient);
    fNameTF.setEditable(false);
    lNameTF.setEditable(false);
    number.setEditable(false);
    patientInfo.getChildren().remove(submitBT);
    patientInfo.add(editBT, 1, 0);
  }
  
  public void messageBTACtion() {
    
  }
  

}
