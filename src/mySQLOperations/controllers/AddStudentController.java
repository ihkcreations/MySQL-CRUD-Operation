package mySQLOperations.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mySQLOperations.DatabaseConnection.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudentController {

    Parent root;
    Stage stage;
    Scene scene;


    public TextField txtStudentID;


    public TextField txtStudentName;


    public TextField txtStudentEmail;


    public TextField txtStudentAddress;


    public TextField txtStudentPhone;


    public void alertSuccessNotify(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("SUCCESS");
        alert.setHeaderText("Student Information");
        alert.setContentText("Provided data has been stored succesfully");
        alert.show();
    }

    public void saveStudentData() throws SQLException, ClassNotFoundException {

        String storeStudentID = txtStudentID.getText();
        String storeStudentName = txtStudentName.getText();
        String storeStudentEmail = txtStudentEmail.getText();
        String storeStudentAddress = txtStudentAddress.getText();
        String storeStudentPhone = txtStudentPhone.getText();

        String sqlQuery = "INSERT INTO studentlist (id, name, email, address, phoneNo) " +
                          "values(?,?,?,?,?);";

        Connection connection = new DatabaseConnection().getFixedConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery);

        statement.setString(1, storeStudentID);
        statement.setString(2, storeStudentName);
        statement.setString(3, storeStudentEmail);
        statement.setString(4, storeStudentAddress);
        statement.setString(5, storeStudentPhone);

        statement.executeUpdate();
        statement.close();

        alertSuccessNotify();


    }



}
