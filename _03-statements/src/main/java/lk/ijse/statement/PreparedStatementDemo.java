package lk.ijse.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {
    private static void saveCustomer(String id, String name, String address, String tel) throws SQLException {
        String sql = "INSERT INTO customers VALUES(?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, tel);

            boolean isSaved = pstm.executeUpdate() > 0;

            System.out.println(isSaved ? "customer saved!" : "customer not saved!");
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.print("Input customer id: ");
        String id = input.next();

        System.out.print("Input customer name: ");
        String name = input.next();

        System.out.print("Input customer address: ");
        String address = input.next();

        System.out.print("Input customer tel: ");
        String tel = input.next();


        saveCustomer(id, name, address, tel);
    }
}
