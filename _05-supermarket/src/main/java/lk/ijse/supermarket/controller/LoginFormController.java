package lk.ijse.supermarket.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.supermarket.db.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {
    public TextField txtUserId;
    public TextField txtPassword;
    public AnchorPane rootNode;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String userId = txtUserId.getText();
        String pw = txtPassword.getText();

        try {
            checkCredential(userId, pw);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "OOPS! something went wrong").show();
        }
    }

    private void checkCredential(String userId, String pw) throws SQLException, IOException {
        String sql = "SELECT user_id, password FROM users WHERE user_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, userId);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String dbPw = resultSet.getString(2);

            if(dbPw.equals(pw)) {
                navigateToTheDashboard();
            } else {
                new Alert(Alert.AlertType.ERROR, "Password is incorrect!").show();
            }
        } else {
            new Alert(Alert.AlertType.INFORMATION, "user id not found!").show();
        }
    }

    private void navigateToTheDashboard() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
    }

    public void linkRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/registration_form.fxml"));

        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.setTitle("Registration Form");

        stage.show();
    }
}
