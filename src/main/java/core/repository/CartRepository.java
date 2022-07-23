package core.repository;

/*
create table Cart (
    id         int auto_increment
        primary key,
    user_id    int not null,
    product_id int not null,
    constraint product_id
        foreign key (product_id) references Product (Id),
    constraint user_id
        foreign key (user_id) references User (id)
);
*/

import core.dao.DAO;
import core.entity.Product;
import core.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepository {

    private final DAO dao;

    public CartRepository(DAO dao) {
        this.dao = dao;
    }


    public final void buyProduct(User user, Product product) {}

    public final void getAllOrders() {
        String query = "SELECT Cart.id, User.First_name, User.Last_name, User.Amount_of_money,\n" +
                "       Product.Product_name, Product.Price\n" +
                "FROM Cart\n" +
                "    INNER JOIN User ON Cart.user_id = User.id\n" +
                "    INNER JOIN Product ON Cart.product_id = Product.id\n" +
                "ORDER BY User.First_name;";

        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Database view: ");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id") + " | ");
                System.out.print("First name: " + resultSet.getString("First_name") + " | ");
                System.out.print("Second name: " + resultSet.getString("Last_name") + " | ");
                System.out.print("Amount of money: " + resultSet.getBigDecimal("Amount_of_money") + " | ");
                System.out.print("Product: " + resultSet.getString("Product_name") + " | ");
                System.out.println("Price: " + resultSet.getBigDecimal("Price") + " | ");
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
