package pl.akademia.kodu;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class DbConnection {

    public static Connection connect = null;

    public static void connect() {

        // Setup the connection with the DB
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/LoginPanel?"
                            + "user=root&password=");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(User user) {
        try {
            String sqlInsert = "INSERT INTO user (login, password, name, surname)" +
                    " VALUES (?, ?, ?, ?);";

            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());

            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean authenticate(String login, String pass) {
        try {
            String sqlSelect = "SELECT password from user WHERE login = '" + login + "';";

            Statement s = connect.createStatement();

            ResultSet resultSet = s.executeQuery(sqlSelect);
            while (resultSet.next()) {
                if (DigestUtils.md5Hex(pass).equals(resultSet.getString("password"))){
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }
}


