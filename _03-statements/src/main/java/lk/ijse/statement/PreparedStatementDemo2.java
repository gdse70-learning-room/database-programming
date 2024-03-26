package lk.ijse.statement;

import java.util.Scanner;

public class PreparedStatementDemo2 {
    private static void updateCustomer(String id, String name, String address, String tel) {

    }

    public static void main(String[] args) {
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
