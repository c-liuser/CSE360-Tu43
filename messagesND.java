package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class messagesND {
	
	//contains all the elements
	BorderPane pane2;
	//for the buttons on the left column
	VBox layoutBox2;
	///According to the UI layout, 3 buttons needed 
	Button ndHomeBtn, pSearch, messagesBtn2, sendBtn2;
	//According ot the UI layout, 1 messageField
	TextField ndMessageField;
	
	public Scene messagesNDFunction(Stage primaryStage) {
		
		//button display
		sendBtn2 = new Button ("Send");
		sendBtn2.setPrefSize(40, 10);
		sendBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		pSearch = new Button ("Search");
		pSearch.setPrefSize(40, 40);
		messagesBtn2 = new Button ("MSSGs");
		messagesBtn2.setPrefSize(40, 40);
		ndHomeBtn = new Button ("Home");
		ndHomeBtn.setPrefSize(40, 40);
		
		
		//Align buttons vertically, to the left of the scene
		layoutBox2 = new VBox();
		layoutBox2.getChildren().addAll(ndHomeBtn, pSearch, messagesBtn2);
		layoutBox2.setSpacing(20);
		
		//message field display
		ndMessageField = new TextField("Write your message here");
		ndMessageField.setPrefWidth(400);
		ndMessageField.setAlignment(Pos.BASELINE_LEFT);
		
		// Create an HBox to layout the TextField and Button horizontally
        HBox hbox = new HBox();
        //hbox.getChildren().addAll(pMessageField, sendBtn);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        
        //hbox.setSpacing(10); // Add some spacing between the TextField and Button
		// Create a StackPane to overlay the TextField and Button
        StackPane root2 = new StackPane();
        root2.getChildren().addAll(hbox);
        
        hbox.getChildren().addAll(ndMessageField, sendBtn2);
        
      //set the layoutBox, to the left of the border pane
        pane2 = new BorderPane();
		pane2.setLeft(layoutBox2);
		pane2.setBottom(root2);
        
		BorderPane.setMargin(layoutBox2, new Insets(0, 10, 10, 0));
		
		Scene ndMessageSection = new Scene(pane2, 700, 500);
		
		
        return ndMessageSection;
	
	}
}
