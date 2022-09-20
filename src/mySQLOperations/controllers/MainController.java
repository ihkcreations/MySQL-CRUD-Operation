package mySQLOperations.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mySQLOperations.DatabaseConnection.DatabaseConnection;
import mySQLOperations.models.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    Parent root;
    Scene  scene;
    Stage stage;

    public TableView<Student> studentTable;


    public TableColumn<Student, String> col_id;


    public TableColumn<Student, String> col_name;


    public TableColumn<Student, String> col_email;


    public TableColumn<Student, String> col_address;


    public TableColumn<Student, String> col_phone;


    public Button btnAdd;


    public Button btnRefresh;


    ObservableList<Student> studentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getScene(ActionEvent event){
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void utilityScene(ActionEvent event){

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }



    public void addStudent(ActionEvent event) throws IOException {

            root = FXMLLoader.load(getClass().getResource("../fxml/AddStudent.fxml"));
            utilityScene(event);

    }


        public void refresh(ActionEvent event) throws SQLException, ClassNotFoundException {

        studentList.clear();

        Connection connection = new DatabaseConnection().getFixedConnection();

        String query = "SELECT * FROM studentlist";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet results = statement.executeQuery();

        while(results.next()){

            String studentID = results.getString("id");
            String studentName = results.getString("name");
            String studentEmail = results.getString("email");
            String studentAddress = results.getString("address");
            String studentPhoneNo = results.getString("phoneNo");

            studentList.add(new Student(studentID, studentName, studentEmail, studentAddress, studentPhoneNo));
            studentTable.setItems(studentList);


        }

    }



    public void loadTable() throws SQLException, ClassNotFoundException {

        Connection connection = new DatabaseConnection().getFixedConnection();

        String query = "SELECT * FROM studentlist";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet results = statement.executeQuery();

        while(results.next()){

            String studentID = results.getString("id");
            String studentName = results.getString("name");
            String studentEmail = results.getString("email");
            String studentAddress = results.getString("address");
            String studentPhoneNo = results.getString("phoneNo");

            studentList.add(new Student(studentID, studentName, studentEmail, studentAddress, studentPhoneNo));
            studentTable.setItems(studentList);


        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));


    }
}
