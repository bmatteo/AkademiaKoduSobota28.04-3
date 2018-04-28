package pl.akademia.kodu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Registration {
    static void registration() throws NoSuchAlgorithmException {

        User user = new User();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Password: ");
        user.setPassword(scanner.nextLine());
        System.out.println("Name: ");
        user.setName(scanner.nextLine());
        System.out.println("Surname: ");
        user.setSurname(scanner.nextLine());

        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] thedigest = m.digest(user.getPassword());
    }
}
