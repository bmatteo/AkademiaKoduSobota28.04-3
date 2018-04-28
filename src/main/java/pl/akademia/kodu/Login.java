package pl.akademia.kodu;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class Login {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        DbConnection.connect();
        if(DbConnection.authenticate(login, password)) {
            System.out.println("Jest git!");
        } else {
            System.out.println("Error!");
        }
    }
}
