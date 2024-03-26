package lk.ijse.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo2 {
    private static void updateCustomer(String id, String name, String address, String tel) throws SQLException {

        String sql = "UPDATE customers SET name = ?, address = ?, tel = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, name);
            pstm.setObject(2, address);
            pstm.setObject(3, tel);
            pstm.setObject(4, id);

            boolean isUpdated = pstm.executeUpdate() > 0;
            System.out.println(isUpdated ? "customer updated!" : "customer not updated!");
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.print("Input customer id: ");
        String id = input.next();

        System.out.print("Input customer new name: ");
        String name = input.next();

        System.out.print("Input customer new address: ");
        String address = input.next();

        System.out.print("Input customer new tel: ");
        String tel = input.next();

        updateCustomer(id, name, address, tel);
    }
}
