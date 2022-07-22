package core.dao;

import java.sql.Connection;

@FunctionalInterface
public interface DAO {
    Connection connectionToDB();

}
