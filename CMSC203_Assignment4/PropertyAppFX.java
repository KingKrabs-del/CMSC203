/*Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 3/30/2026
 * Platform/compiler: Java
 * Description: The program lets the user add properties, view a list of all properties, and calculate the total rent collected from all properties.
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// Used Oracle to relearn JavaFX
// Link: https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
public class PropertyAppFX extends Application {

    private ManagementCompany company = new ManagementCompany("Six-Seven BrainRot", "167-67-4167");

    private TextField nameInput = new TextField();
    private TextField cityInput = new TextField();
    private TextField rentInput = new TextField();
    private TextField ownerInput = new TextField();
    private TextArea displayArea = new TextArea();

    @Override
    public void start(Stage stage) {
        Label title = new Label("Property Management Application");

        GridPane form = createForm();

        Button addButton = new Button("Add Property");
        Button showButton = new Button("Show All Properties");
        Button rentButton = new Button("Calculate Total Rent");
        Button clearButton = new Button("Clear");

        addButton.setOnAction(e -> addProperty());
        showButton.setOnAction(e -> displayArea.setText(company.toString()));
        rentButton.setOnAction(e -> displayArea.setText("Total Rent: $" + company.totalRent()));
        clearButton.setOnAction(e -> clearInputs());

        HBox buttonRow = new HBox(10, addButton, showButton, rentButton, clearButton);

        displayArea.setEditable(false);
        displayArea.setPrefHeight(200);

        VBox topSection = new VBox(10, title, form, buttonRow);
        topSection.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(topSection);
        root.setCenter(displayArea);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Property App");
        stage.setScene(scene);
        stage.show();
    }

    // Creates the input form
    private GridPane createForm() {
        GridPane form = new GridPane();

        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Name:"), 0, 0);
        form.add(nameInput, 1, 0);

        form.add(new Label("City:"), 0, 1);
        form.add(cityInput, 1, 1);

        form.add(new Label("Rent:"), 0, 2);
        form.add(rentInput, 1, 2);

        form.add(new Label("Owner:"), 0, 3);
        form.add(ownerInput, 1, 3);

        return form;
    }

    // Adds a property from the input fields
    private void addProperty() {
        if (nameInput.getText().isEmpty() || cityInput.getText().isEmpty()
                || rentInput.getText().isEmpty() || ownerInput.getText().isEmpty()) {
            displayArea.setText("Please fill in all fields.");
            return;
        }

        // Learned from Chapter 11 of textbook
        try {
            double rent = Double.parseDouble(rentInput.getText());

            Property property = new Property(
                    nameInput.getText(),
                    cityInput.getText(),
                    rent,
                    ownerInput.getText()
            );

            int index = company.addProperty(property);

            if (index == -1) {
                displayArea.setText("The property list is full.");
            } else {
                displayArea.setText("Property added.");
                clearInputs();
            }

        } catch (NumberFormatException e) {
            displayArea.setText("Rent must be a number.");
        }
    }

    // Clears the input fields
    private void clearInputs() {
        nameInput.clear();
        cityInput.clear();
        rentInput.clear();
        ownerInput.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
