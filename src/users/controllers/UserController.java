package users.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import users.DBConnect;
import users.models.User;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserController implements Initializable{

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    ObservableList<User> plist = FXCollections.observableArrayList();

    @FXML
    private TableView<User> tableUser;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colEmail;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            conn = DBConnect.connect();
        }catch (Exception e){
            e.printStackTrace();
        }
        getUser();
        initTableColumn();
    }

    public void getUser(){
        tableUser.getItems().clear();
        try{
            pst = conn.prepareStatement("select * from users");
            rs = pst.executeQuery();

            while (rs.next()){
                plist.add(new User(rs.getString("name"), rs.getString("email")));

                tableUser.setItems(plist);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actionSave(ActionEvent e){
        String sql = "INSERT into users values (NULL, '"+ tf_name.getText() +"', '"+ tf_email.getText() +"' );";
        System.out.println(sql);
        try {
            pst.execute(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        getUser();
        clearTextField();
    }

    public void clearTextField(){
        tf_name.setText("");
        tf_email.setText("");
    }

    public void initTableColumn(){
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
    }

}
