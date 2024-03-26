package lk.ijse.statement;

import java.sql.*;

public class SQLInjection {
    private static void searchUserByCreateStatement(String user_id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = "+ user_id;

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String pw = resultSet.getString(3);

                System.out.println(id + " - " + name + " - " + pw);
            }
        }
    }

    private static void searchUserByPreparedStatement(String user_id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, user_id);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String pw = resultSet.getString(3);

                System.out.println(id + " - " + name + " - " + pw);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
//        searchUserByCreateStatement("'hsdfuhds' OR 1=1");
        searchUserByPreparedStatement("'hsdfuhds' OR 1=1");
    }
}
