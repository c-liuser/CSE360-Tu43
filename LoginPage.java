
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPage {
  HBox smallhbox;
  VBox vbox1;
  VBox vbox3;
  
  public Label docLoginLB;
  public Label patientLoginLB;
  
  public TextField docUsernameTF;
  public TextField docPasswordTF;
  public TextField patientUsernameTF;
  public TextField patientPasswordTF;
  public TextField patientFnameTF;
  public TextField patientLnameTF;
  public TextField patientBirthdayTF;
  
  public Button patientSigninBT;
  public Button patientSignupBT;
  
  private Separator sep;
  
  public HBox screen;
  
  public LoginPage() {
 // Titles
    docLoginLB = new Label("Doctor/Nurse Portal");
    docLoginLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    patientLoginLB = new Label("Patient Portal");
    patientLoginLB.setFont(Font.font("Arial", FontWeight.BOLD, 20));

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
    Button button1 = new Button("Sign-in");
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
    
    patientFnameTF= new TextField();
    patientFnameTF.setPromptText("First Name");
    patientLnameTF= new TextField();
    patientLnameTF.setPromptText("Last Name");
    patientBirthdayTF= new TextField();
    patientBirthdayTF.setPromptText("Birthday");
    
    VBox patientSigninVB = new VBox(10);
    patientSigninVB.setPrefWidth(200);
    patientSigninVB.setPadding(new Insets(15));
    patientSigninVB.getChildren().addAll(patientFnameTF, patientLnameTF, patientBirthdayTF, patientSignupBT);

    // Separator
    sep = new Separator();
    sep.setOrientation(Orientation.VERTICAL);
    sep.setHalignment(HPos.RIGHT);

    // add to vboxes
    vbox1.getChildren().addAll(docLoginLB, docUsernameTF, docPasswordTF, button1);
    vbox1.setStyle("-fx-border-color: black");
    vbox3.getChildren().addAll(patientLoginLB, patientUsernameTF, patientPasswordTF, patientSigninBT);
    vbox3.setStyle("-fx-border-color: black");

    // add to hbox
    screen.getChildren().add(vbox1);
    screen.getChildren().add(vbox3);
    //smallhbox.getChildren().addAll(patientSigninBT, patientSignupBT);

    // implement button events
    patientSignupBT.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            String username = patientUsernameTF.getText();
            String password = patientPasswordTF.getText();
            //Patient newUser = new Patient(username, password);
//            testPatients.add(newUser);
//            if (testPatients.get(testPatients.size() - 1).getUser() == username
//                    && testPatients.get(testPatients.size() - 1).getPass() == password) {
//                testOutput.setText("Sign-up successful!");
//            } else {
//                testOutput.setText("Sign-up Unsuccessful. Please try again!");
//            }
        }
    });
    patientSigninBT.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            String username = patientUsernameTF.getText();
            String password = patientPasswordTF.getText();
//            for (int i = 0; i < testPatients.size(); i++) {
//                if (username.equals(testPatients.get(i).getUser())) {
//                    if (password.equals(testPatients.get(i).getPass())) {
//                        testOutput.setText("Success");
//                    } else {
//                        testOutput.setText("Wrong Password");
//                    }
//                } else
//                    testOutput.setText("User not found!");
//            }
        }
    });

    // changes to vbox
    vbox3.getChildren().add(patientSigninVB);
  }

}
