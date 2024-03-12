package lk.ijse.dbp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConfiguration {
    private static Connection connection;
    private static Statement statement;
    private static void loadAndRegisterDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private static void createTheConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        );
        System.out.println("connection: " + connection);
    }
    private static void createTheStatement() throws SQLException {
        statement = connection.createStatement();
    }

    private static void executeTheQuery() throws SQLException {
        String sql = "INSERT INTO customers(id, name, address, tel) VALUES('C004', 'Kithimi', 'Hikkaduwa', '0786567745')";
        int affectedRows = statement.executeUpdate(sql);
        System.out.println("affected rows: " + affectedRows);
        if(affectedRows > 0) {
            System.out.println("Huree! customer saved!");
        } else {
            System.err.println("Oops! customer not saved!");
        }
    }

    private static void closeTheConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        loadAndRegisterDriver();
        createTheConnection();
        createTheStatement();
        executeTheQuery();
        closeTheConnection();
    }
}
