

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class messagesP {

	//contains all the elements
	BorderPane pane;
	//for the buttons on the left column
	VBox layoutBox;
	///According to the UI layout, 3 buttons needed 
	Button patientHomeBtn, sendBtn, messagesBtn;
	//According ot the UI layout, 1 messageField
	TextField pMessageField;
	
	public Scene messagesPFunction(Stage primaryStage) {
	
		//button display
		sendBtn = new Button ("Send");
		sendBtn.setPrefSize(40, 10);
		sendBtn.setAlignment(Pos.BOTTOM_RIGHT);
		messagesBtn = new Button ("MSSGs");
		messagesBtn.setPrefSize(40, 40);
		patientHomeBtn = new Button ("Home");
		patientHomeBtn.setPrefSize(40, 40);
		
		//Align buttons vertically, to the left of the scene
		layoutBox = new VBox();
		layoutBox.getChildren().addAll(patientHomeBtn, messagesBtn);
		layoutBox.setSpacing(20);
		
		
		//message field display
		pMessageField = new TextField("Write your message here");
		pMessageField.setPrefWidth(500);
        pMessageField.setAlignment(Pos.BASELINE_LEFT);
        
     // Create an HBox to layout the TextField and Button horizontally
        HBox hbox = new HBox();
        //hbox.getChildren().addAll(pMessageField, sendBtn);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        
        //hbox.setSpacing(10); // Add some spacing between the TextField and Button
		// Create a StackPane to overlay the TextField and Button
        StackPane root = new StackPane();
        root.getChildren().addAll(hbox);
        
        hbox.getChildren().addAll(pMessageField, sendBtn);

		
        
		//set the layoutBox, to the left of the border pane
        pane = new BorderPane();
		pane.setLeft(layoutBox);
		pane.setBottom(root);
        
		BorderPane.setMargin(layoutBox, new Insets(0, 10, 10, 0));
		
		
        Scene pMessageSection = new Scene(pane, 700, 500);
		return pMessageSection;
	}
}
