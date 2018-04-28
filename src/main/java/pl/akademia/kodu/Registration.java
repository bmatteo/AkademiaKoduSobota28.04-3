package pl.akademia.kodu;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Registration {
    static void registration() {

        User user = new User();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        user.setLogin(scanner.nextLine());

        System.out.println("Password: ");
        user.setPassword(DigestUtils.md5Hex(scanner.nextLine()));

        System.out.println("Name: ");
        user.setName(scanner.nextLine());

        System.out.println("Surname: ");
        user.setSurname(scanner.nextLine());

        DbConnection.connect();
        DbConnection.insertUser(user);

    }
}
