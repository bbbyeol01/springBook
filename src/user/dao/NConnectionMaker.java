package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/SPRINGBOOK?useUnicode=true&characterEncoding=utf8";
        String dbName = "root";
        String dbPassword = "abcde12345";

        return DriverManager.getConnection(url, dbName, dbPassword);
    }
}
