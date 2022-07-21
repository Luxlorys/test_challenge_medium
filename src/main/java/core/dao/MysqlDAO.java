package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAO implements DAO {

    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "gromozeqa";
    private static final String PASSWORD = "password#";

    public Connection connectionToDB() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
