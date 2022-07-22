package core.repository;

/*
create table User
(
    id              int auto_increment
        primary key,
    First_name      varchar(32) not null,
    Last_name       varchar(32) not null,
    Amount_of_money int         not null,
    constraint User_First_name_uindex
        unique (First_name)
);
*/


import core.dao.DAO;
import core.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final DAO dao;

    public UserRepository(DAO dao) {
        this.dao = dao;
    }

    public final boolean registerNewUser(User user) {
        String query = "INSERT INTO User (First_name, Last_name, Amount_of_Money) VALUES (?, ?, ?)";
        try{
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAmountOfMoney());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }


    public final boolean deleteUser(String userName) {
        String query = "DELETE FROM User WHERE First_name = ?";
        try{
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);

            preparedStatement.setString(1, userName);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public final boolean displayAllUsers() {
        try {
            String query = "SELECT  * FROM User";

            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Database view: ");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id") + " | ");
                System.out.print("First name: " + resultSet.getString("First_name") + " | ");
                System.out.print("Last name: " + resultSet.getString("Last_name") + " | ");
                System.out.println("Amount of money: " + resultSet.getString("Amount_of_money"));

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return true;
    }
}
