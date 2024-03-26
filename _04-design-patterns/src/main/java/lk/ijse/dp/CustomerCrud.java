package lk.ijse.dp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCrud {
    private static void saveCustomer() throws SQLException {
        DbConnection instance = DbConnection.getInstance();
        Connection connection = instance.getConnection();

        System.out.println("connection(saveCustomer()) = " + connection);

     /*   PreparedStatement pstm = connection.prepareStatement("INSERT INTO customers VALUES(?, ?, ?, ?)");
        ResultSet resultSet = pstm.executeQuery();*/
    }

    private static void getAllCustomer() throws SQLException {
        DbConnection instance = DbConnection.getInstance();

        Connection connection = instance.getConnection();

        System.out.println("connection(getAllCustoemr()) = " + connection);
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customers");

    }

    private static void searchCustomer() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        System.out.println("connection(searchCustoemr()) = " + connection);
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");
    }

    public static void main(String[] args) throws SQLException {
        saveCustomer();

        getAllCustomer();

        searchCustomer();
    }
}
