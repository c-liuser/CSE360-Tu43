


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginPage {
  HBox smallhbox;
  VBox vbox1;
  VBox vbox3;
  
  public Label docLoginLB;
  public Label patientLoginLB;
  public Label docComs;
  public Label patientComs;
  
  public TextField docUsernameTF;
  public TextField docPasswordTF;
  public TextField patientUsernameTF;
  public TextField patientPasswordTF;
  public TextField patientFnameTF;
  public TextField patientLnameTF;
  public TextField patientBirthdayTF;
  public TextField patientNewPasswordTF;
  
  public Button patientSigninBT;
  public Button patientSignupBT;
  public ToggleGroup tg;
  
  RadioButton docRB;
  RadioButton nurseRB;
  TilePane r;
  
  private Separator sep;
  
  public HBox screen;
  
  private String loginDB = "" + System.getProperty("user.dir") + "/src/application/loginDB.txt";
  private String patientDB = "" + System.getProperty("user.dir") + "/src/patientDB/";
  private String docDB = "" + System.getProperty("user.dir") + "/src/docDB/";
  public Scene scene;
  public Stage stage;
  
  public DatabaseManager db = new DatabaseManager();
  private String docPrefix = "d:";
  private String nursePrefix = "n:";
  private String patientPrefix = "p:";
  
  public LoginPage() {
 // Titles
    docLoginLB = new Label("Doctor/Nurse Portal");
    docLoginLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    patientLoginLB = new Label("Patient Portal");
    patientLoginLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    
    docComs = new Label("");
    docComs.setFont(Font.font("Arial", FontWeight.BOLD, 10));
    patientComs = new Label("");
    patientComs.setFont(Font.font("Arial", FontWeight.BOLD, 10));

    // Horizontal Box
    screen = new HBox(10);
    screen.setPadding(new Insets(50));
    screen.setAlignment(Pos.TOP_CENTER);

    smallhbox = new HBox(10);

    // Vertical Box 1
    vbox1 = new VBox(10);
    vbox1.setPrefWidth(200);
    vbox1.setPadding(new Insets(15));
    vbox3 = new VBox(10);
    vbox3.setPrefWidth(200);
    vbox3.setPadding(new Insets(15));

    // Button
    Button docSigninBT = new Button("Sign-in");
    patientSigninBT = new Button("Sign-in");
    patientSignupBT = new Button("Sign-up");
//    patientSigninBT.setMinWidth(40);
//    patientSigninBT.setMinHeight(10);
//    patientSignupBT.setMinHeight(10);
//    patientSignupBT.setMinWidth(40);

    // TextFields
    docUsernameTF = new TextField();
    docUsernameTF.setPromptText("Username");
    docPasswordTF = new TextField();
    docPasswordTF.setPromptText("Password");

    patientUsernameTF = new TextField();
    patientUsernameTF.setPromptText("Username");
    patientPasswordTF = new TextField();
    patientPasswordTF.setPromptText("Password");

    TextField testOutput = new TextField();
    testOutput.setPromptText("for testing only");
    
    patientFnameTF = new TextField();
    patientFnameTF.setPromptText("First Name");
    patientLnameTF = new TextField();
    patientLnameTF.setPromptText("Last Name");
    patientBirthdayTF = new TextField();
    patientBirthdayTF.setPromptText("Birthday");
    patientNewPasswordTF = new TextField();
    patientNewPasswordTF.setPromptText("Password");
    
    // radio buttons
    tg = new ToggleGroup();
    r = new TilePane();
    docRB = new RadioButton("Doctor"); 
    docRB.setToggleGroup(tg);
    nurseRB = new RadioButton("Nurse"); 
    nurseRB.setToggleGroup(tg);
    r.getChildren().add(docRB); 
    r.getChildren().add(nurseRB); 
    
    // Separator
    sep = new Separator();
    sep.setOrientation(Orientation.VERTICAL);
    sep.setHalignment(HPos.RIGHT);

    // add to vboxes
    vbox1.getChildren().addAll(docLoginLB, docUsernameTF, docPasswordTF, r, docSigninBT, docComs);
    vbox1.setStyle("-fx-border-color: black");
    vbox3.getChildren().addAll(patientLoginLB, patientUsernameTF, patientPasswordTF, patientSigninBT,patientFnameTF, patientLnameTF, patientBirthdayTF, patientNewPasswordTF, patientSignupBT, patientComs);
    vbox3.setStyle("-fx-border-color: black");

    // add to hbox
    screen.getChildren().add(vbox1);
    screen.getChildren().add(vbox3);
    //smallhbox.getChildren().addAll(patientSigninBT, patientSignupBT);

    // implement button events
    patientSignupBT.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
          String fName = patientFnameTF.getText();
          String lName = patientLnameTF.getText();
          String bday = patientBirthdayTF.getText();
          String newPassword = patientNewPasswordTF.getText();
          String newUsername = "";
          
          Random rand = new Random();
            
          int rand_int1 = rand.nextInt(fName.length());
          newUsername += fName.substring(0, rand_int1 + 1);
            
          rand_int1 = rand.nextInt(lName.length());
          newUsername += lName.substring(0, rand_int1 + 1);

          rand_int1 = rand.nextInt(bday.length());
          newUsername += bday.substring(0, rand_int1 + 1);
            
          newUsername = newUsername.toLowerCase();
          patientComs.setText(newUsername);
          //write to logindb
          db.addUserToLogin(patientPrefix, newUsername, newPassword);
          //write to patientdb
          db.createInPatientDB(newUsername, fName, lName, bday);
          // write to docdb
          db.createInDocDB(newUsername, fName, lName, bday);
            
        }
    });
    patientSigninBT.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            Boolean hasAccount = false;
            String username = patientUsernameTF.getText();
            String password = patientPasswordTF.getText();
            String prefix = "p:";
            
            try {
              FileReader fr = new FileReader(loginDB);
              BufferedReader br = new BufferedReader(fr);
              String check = "1";
              while(check != null) {
                if(check.equals(prefix + username +" "+ password)){
                  br.close();
                  hasAccount = true;
                  System.out.println("signin successful");
                  break;
                }
                check = br.readLine();
              }
              System.out.println("signin failed");
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            } 
            if(hasAccount) {
              // navigate to doc page
              //patientComs.setText("signin successful");
              PatientPortal portal = new PatientPortal();
              Window w = scene.getWindow();
              if(w instanceof Stage) {
                Stage s = (Stage) w;
                s.setScene(portal.PatientPortalInit(patientDB+username+".txt"));
              }
            }else {
              patientComs.setText("Account does not exist");
            }
        }
    });
    
    docSigninBT.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        Boolean hasAccount = false;
        String username = docUsernameTF.getText();
        String password = docPasswordTF.getText();
        String prefix = "";
        if(docRB.isSelected()) {
          prefix = "d:";
        }
        if(nurseRB.isSelected()) {
          prefix = "n:";
        }
        
        try {
          FileReader fr = new FileReader(loginDB);
          BufferedReader br = new BufferedReader(fr);
          String check = "1";
          while(check != null) {
            if(check.equals(prefix + username +" "+ password)){
              br.close();
              System.out.println("signin successful");
              hasAccount = true;
              break;
            }
            check = br.readLine();
          }
          System.out.println("signin failed");
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } 
        //navigation
        if(hasAccount) {
          // navigate to doc page
          if(docRB.isSelected()) {
            doctorView dview = new doctorView();
            Window w = scene.getWindow();
            if(w instanceof Stage) {
              Stage s = (Stage) w;
              s.setScene(dview.getScene());
            }
          }
          
          if(nurseRB.isSelected()) {
            //navigate to nurse
            nurseView nview = new nurseView();
            Window w = scene.getWindow();
            if(w instanceof Stage) {
              Stage s = (Stage) w;
              s.setScene(nview.getScene());
            }
          }
        }else {
          docComs.setText("Account does not exist");
        }
       
//        for (int i = 0; i < testPatients.size(); i++) {
//            if (username.equals(testPatients.get(i).getUser())) {
//                if (password.equals(testPatients.get(i).getPass())) {
//                    testOutput.setText("Success");
//                } else {
//                    testOutput.setText("Wrong Password");
//                }
//            } else
//                testOutput.setText("User not found!");
//        }
      }
    });	
    
    scene = new Scene(screen, 750, 500);
    // changes to vbox
  }
  
  public Scene getScene() {
	  return scene;
  }

}
