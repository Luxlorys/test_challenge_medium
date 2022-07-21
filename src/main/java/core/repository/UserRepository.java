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

}
