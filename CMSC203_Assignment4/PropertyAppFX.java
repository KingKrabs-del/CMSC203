/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Ishatta King
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application {
    private ManagementCompany mc = new ManagementCompany("Moco Company", "123-456-7890");

    private TextField propertyNameField;
    private TextField cityField;
    private TextField rentField;
    private TextField ownerField;
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        Label propertyNameLabel = new Label("Property Name:");
        Label cityLabel = new Label("City:");
        Label rentLabel = new Label("Rent Amount:");
        Label ownerLabel = new Label("Owner:");

        propertyNameField = new TextField();
        cityField = new TextField();
        rentField = new TextField();
        ownerField = new TextField();

        Button addButton = new Button("Add Property");
        Button showButton = new Button("Show Properties");
        Button totalButton = new Button("Show Total Rent");
        Button clearButton = new Button("Clear");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(220);

        addButton.setOnAction(e -> addProperty());
        showButton.setOnAction(e -> outputArea.setText(mc.toString()));
        totalButton.setOnAction(e -> outputArea.setText("Total Rent: $" + mc.totalRent()));
        clearButton.setOnAction(e -> clearFields());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(propertyNameLabel, 0, 0);
        grid.add(propertyNameField, 1, 0);

        grid.add(cityLabel, 0, 1);
        grid.add(cityField, 1, 1);

        grid.add(rentLabel, 0, 2);
        grid.add(rentField, 1, 2);

        grid.add(ownerLabel, 0, 3);
        grid.add(ownerField, 1, 3);

        HBox buttons = new HBox(10, addButton, showButton, totalButton, clearButton);
        VBox root = new VBox(10, grid, buttons, outputArea);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 650, 400);
        primaryStage.setTitle("Property Management Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addProperty() {
        String propertyName = propertyNameField.getText().trim();
        String city = cityField.getText().trim();
        String rentText = rentField.getText().trim();
        String owner = ownerField.getText().trim();

        if (propertyName.isEmpty() || city.isEmpty() || rentText.isEmpty() || owner.isEmpty()) {
            outputArea.setText("Error: All fields are required.");
            return;
        }

        double rent;
        try {
            rent = Double.parseDouble(rentText);
        } catch (NumberFormatException e) {
            outputArea.setText("Error: Rent must be a valid number.");
            return;
        }

        Property p = new Property(propertyName, city, rent, owner);
        int result = mc.addProperty(p);

        if (result == -1) {
            outputArea.setText("Error: Property list is full.");
        } else {
            outputArea.setText("Property added successfully at index " + result + ".");
            clearFields();
        }
    }

    private void clearFields() {
        propertyNameField.clear();
        cityField.clear();
        rentField.clear();
        ownerField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
