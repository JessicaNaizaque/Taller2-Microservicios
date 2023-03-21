package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.clients.RestClient;
import org.example.trips.Trip;
import org.example.trips.TripWithoutId;

import java.util.List;

public class MainSceneController {
    private List<Trip> trips;
    private Long updateId;

    @FXML
    private TableView<Trip> table;
    @FXML
    private TableColumn<Trip, Long> columnId;
    @FXML
    private TableColumn<Trip, String> columnName;
    @FXML
    private TableColumn<Trip, String> columnOrigin;
    @FXML
    private TableColumn<Trip, String> columnDestination;
    @FXML
    private TableColumn<Trip, String> columnDate;
    @FXML
    private TextField createNameField;
    @FXML
    private TextField createOriginField;
    @FXML
    private TextField createDestinationField;
    @FXML
    private TextField createDateField;
    @FXML
    private TextArea createResponseArea;
    @FXML
    private ComboBox<Trip> updateIdComboBox;
    @FXML
    private TextField updateNameField;
    @FXML
    private TextField updateOriginField;
    @FXML
    private TextField updateDestinationField;
    @FXML
    private TextField updateDateField;
    @FXML
    private TextArea updateResponseArea;
    @FXML
    private ComboBox<Trip> deleteIdComboBox;
    @FXML
    private TextArea deleteResponseArea;

    public void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnOrigin.setCellValueFactory(new PropertyValueFactory<>("origin"));
        columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        refreshTrips();
    }

    private void refreshTrips() {
        trips = RestClient.getAllTrips();

        updateIdComboBox.getItems().clear();
        updateIdComboBox.getItems().addAll(trips);
        deleteIdComboBox.getItems().clear();
        deleteIdComboBox.getItems().addAll(trips);

        table.getItems().clear();
        table.getItems().addAll(trips);
    }

    @FXML
    private void createTrip(ActionEvent actionEvent) {
        if (createNameField.getText().isEmpty() || createOriginField.getText().isEmpty() || createDestinationField.getText().isEmpty() || createDateField.getText().isEmpty()) {
            createResponseArea.setText("All fields must have a value");
            return;
        }

        TripWithoutId newTrip = new TripWithoutId(createNameField.getText(), createOriginField.getText(), createDestinationField.getText(), createDateField.getText());
        Trip createdTrip = null;
        try {
           createdTrip = RestClient.createTrip(newTrip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (createdTrip == null) {
            createResponseArea.setText("Error creating trip");
            return;
        }
        createResponseArea.setText("Created trip: " + createdTrip.toStringData());

        createNameField.clear();
        createOriginField.clear();
        createDestinationField.clear();
        createDateField.clear();

        refreshTrips();
    }

    @FXML
    private void updateTrip(ActionEvent actionEvent) {
        if (updateIdComboBox.getSelectionModel().isEmpty() || updateNameField.getText().isEmpty() || updateOriginField.getText().isEmpty() || updateDestinationField.getText().isEmpty() || updateDateField.getText().isEmpty()) {
            updateResponseArea.setText("All fields must have a value");
            return;
        }

        Trip trip = updateIdComboBox.getSelectionModel().getSelectedItem();
        TripWithoutId newTrip = new TripWithoutId(updateNameField.getText(), updateOriginField.getText(), updateDestinationField.getText(), updateDateField.getText());
        Trip updatedTrip = null;
        try {
            updatedTrip = RestClient.updateTrip(trip.getId(), newTrip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (updatedTrip == null) {
            updateResponseArea.setText("Error updating trip");
            return;
        }
        updateResponseArea.setText("Updated trip: " + updatedTrip.toStringData());

        updateIdComboBox.getSelectionModel().clearSelection();
        updateNameField.clear();
        updateOriginField.clear();
        updateDestinationField.clear();
        updateDateField.clear();

        refreshTrips();

    }

    @FXML
    private void deleteTrip(ActionEvent actionEvent) {
        if (deleteIdComboBox.getSelectionModel().isEmpty()) {
            deleteResponseArea.setText("Select a trip to delete");
            return;
        }

        Trip trip = deleteIdComboBox.getSelectionModel().getSelectedItem();
        try {
            RestClient.deleteTrip(trip.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        deleteResponseArea.setText("Deleted trip: " + trip.toStringData());

        deleteIdComboBox.getSelectionModel().clearSelection();

        refreshTrips();
    }

    @FXML
    public void onUpdateComboBox(ActionEvent actionEvent) {
        if (updateIdComboBox.getSelectionModel().isEmpty()) {
            return;
        }
        if (updateId != null && updateId.equals(updateIdComboBox.getSelectionModel().getSelectedItem().getId())) {
            return;
        }
        Trip trip = updateIdComboBox.getSelectionModel().getSelectedItem();
        updateId = trip.getId();
        updateNameField.setText(trip.getName());
        updateOriginField.setText(trip.getOrigin());
        updateDestinationField.setText(trip.getDestination());
        updateDateField.setText(trip.getDate());
    }
}
