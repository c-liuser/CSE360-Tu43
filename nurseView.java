
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class nurseView {
    private Scene scene;
    private ListView<String> listView;
    private TextArea fileContent;
    private Patient patient;

    public nurseView() {
        listView = new ListView<String>();
        listView.setPrefSize(200, 200);

        fileContent = new TextArea();
        fileContent.setEditable(false);
        fileContent.setPrefSize(400, 300);

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

        Button intakeBtn = new Button("intake");
        intakeBtn.setPrefSize(50, 50);
        // Main section
        VBox main = new VBox();
        main.setSpacing(10);
        main.setPadding(new Insets(20));
        sidebar.getChildren().addAll(homeBtn, msgBtn, intakeBtn);

        Label titleLabel = new Label("Welcome Nurse");
        titleLabel.setFont(new Font("Arial", 24));

        HBox searchBox = new HBox();
        searchBox.setSpacing(10);

        TextField searchField = new TextField();
        searchField.setPrefWidth(200);

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: white;");

        searchBox.getChildren().addAll(searchField, searchButton);

        main.getChildren().addAll(titleLabel, searchBox, listView, fileContent);

        // Search button clicked
        searchButton.setOnAction(e -> searchUser(searchField.getText()));
        // Msg button
        msgBtn.setOnAction(e -> openMessages());
        // Intake button
        intakeBtn.setOnAction(e -> openIntake());
        // Item in list listener
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, fileName) -> {
            if (fileName != null) {
                System.out.println(fileName);
                displayFileContents(fileName);
            }
        });

        // sidebar on left main on right
        root.setLeft(sidebar);
        root.setCenter(main);

        scene = new Scene(root, 750, 500);
    }

    public Scene getScene() {
        return scene;
    }

    private void searchUser(String input) {
        listView.getItems().clear();

        Path folderPath = Paths.get("./src/docDB");

        try (Stream<Path> files = Files.list(folderPath)) {
            listView.getItems().addAll(files
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(fileName -> fileName.startsWith(input.toLowerCase()))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayFileContents(String fileName) {
        DatabaseManager db = new DatabaseManager();
        patient = (Patient) db.readPatientFile("./src/docDB/" + fileName);
        fileContent.setText(patient.toString() + "\n");
        fileContent.appendText("Past Visits:\n");
        for (int i = 0; i < patient.pastVisits.size(); i++) {
            PastVisit temp = patient.pastVisits.get(i);
            fileContent.appendText("Findings:\n");
            fileContent.appendText(temp.findings + "\n");
            fileContent.appendText("New prescriptions:\n");
            for (int j = 0; j < temp.prescriptions.size(); j++) {
                fileContent.appendText(temp.prescriptions.get(j) + "\n");
            }
        }

        fileContent.appendText("\nHistory:\n");
        for (int i = 0; i < patient.hist.healthIssues.size(); i++) {
            fileContent.appendText(patient.hist.healthIssues.get(i) + "\n");
        }
        fileContent.appendText("Prescriptions:\n");
        for (int i = 0; i < patient.hist.prescrips.size(); i++) {
            fileContent.appendText(patient.hist.prescrips.get(i) + "\n");
        }
        fileContent.appendText("Immunization History:\n");
        for (int i = 0; i < patient.hist.immunizations.size(); i++) {
            fileContent.appendText(patient.hist.immunizations.get(i));
        }
    }

    private void openMessages() {
        if (patient != null) {
            messagesN nurseMsgs = new messagesN();
            Scene messagesScene = nurseMsgs.messagesNFunction(patient);
            Stage stage = (Stage) scene.getWindow();
            stage.setScene(messagesScene);
            stage.show();
        } else {
            fileContent.setText("Please search and select a patient!");
        }
    }

    private void openIntake() {
        if (patient != null) {
            IntakeForm iForm = new IntakeForm();
            Scene formScene = iForm.IntakeFormFunction(patient);
            Stage stage = (Stage) scene.getWindow();
            stage.setScene(formScene);
            stage.show();
        } else {
            fileContent.setText("Please search and select a patient!");
        }
    }
}
