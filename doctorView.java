

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;

public class doctorView {
	Scene scene;
	
	public doctorView(){
		BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #ADD8E6;"); // Light blue background

        // Side panel
        VBox sidebar = new VBox();
        sidebar.setSpacing(20);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: navy;"); // White background

        Button homeBtn = new Button("home");
        homeBtn.setPrefSize(50, 50);
        Button msgBtn = new Button("msg");
        msgBtn.setPrefSize(50, 50);

        // Main section
        VBox main = new VBox();
        main.setSpacing(10);
        main.setPadding(new Insets(20));
        sidebar.getChildren().addAll(homeBtn, msgBtn);

        Label titleLabel = new Label("Welcome Doctor");
        titleLabel.setFont(new Font("Arial", 24));

        HBox searchBox = new HBox();
        searchBox.setSpacing(10);

        TextField searchField = new TextField();
        searchField.setPrefWidth(200);

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: white;");

        searchBox.getChildren().addAll(searchField, searchButton);

        main.getChildren().addAll(titleLabel, searchBox);

        // sidebar on left main on right
        root.setLeft(sidebar);
        root.setCenter(main);
        
        scene = new Scene(root, 750, 500);
	
	}
	
    public Scene getScene() {
        return scene;
    }
}
