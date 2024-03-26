package lk.ijse.statement;

import java.sql.*;

public class CreateStatementDemo {
    private static void saveCustomer() throws SQLException {
        /*It's not compulsory to load and register the Driver after JDBC 4.x
        Class.forName("com.mysql.cj.jdbc.Driver");*/

        String sql = "INSERT INTO customers VALUES('C009', 'Dilmith', 'Jaffna', '078657768')";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        );
        Statement statement = connection.createStatement();
        int affectedRows = statement.executeUpdate(sql);
        if(affectedRows > 0)
            System.out.println("customer saved!");
        else
            System.out.println("customer not saved!");

        connection.close();
    }

    private static void getAllCustomers() throws SQLException {

        String sql = "SELECT * FROM customers";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);//return type -> ResultSet

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String tel = resultSet.getString("tel");

                System.out.println(id + " - " + name + " - " + address + " - " + tel);
            }
        }

//        connection.close();
    }

    private static void searchCustomerById(String id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = " + id;

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                String cus_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String tel = resultSet.getString(4);

                System.out.println(id + " - " + name + " - " + address + " - " + tel);
            } else {
                System.out.println("customer can't find!");
            }
        }
    }

    private static void deleteCustomer(String id) throws SQLException {

        String sql = "DELETE FROM customers WHERE id = " + id;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            boolean isDeleted = statement.executeUpdate(sql) > 0;

            if(isDeleted)
                System.out.println("customer deleted!");
            else
                System.out.println("customer not deleted!");
        }
    }

    private static void updateCustomer(String id) throws SQLException {

        String sql = "UPDATE customers SET name = 'Shehara', address = 'USA', tel = '0786545675' WHERE id = " + id;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            boolean isUpdated = statement.executeUpdate(sql) > 0;

            System.out.println(isUpdated ? "customer updated!" : "customer not updated");
        }
    }

    public static void main(String[] args) throws SQLException {
//        saveCustomer();

        getAllCustomers();

//        searchCustomerById("'C0010'");

//        deleteCustomer("'C008'");

        updateCustomer("'C007'");
    }
}
