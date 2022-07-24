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
import core.exceptions.NotEnoughMoneyToBuy;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepository {

    private final DAO dao;

    public CartRepository(DAO dao) {
        this.dao = dao;
    }


    public final void addProductToCart(int userId, int productId) {
        String query = "INSERT INTO Cart (user_id, product_id) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);

            if(preparedStatement.executeUpdate() == 1) {
                System.out.println("Product to user cart successfully added");
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }

    }

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

    public final void deleteOrder(int id) {
        String query = "DELETE FROM Cart WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);

            preparedStatement.setInt(1, id);

            if(preparedStatement.executeUpdate() == 1) {
                System.out.println("Order successfully deleted");
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public final void getUserCart(String userName) {
        String query = "SELECT Cart.id, User.First_name, User.Last_name, User.Amount_of_money,\n" +
                "       Product.Product_name, Product.Price\n" +
                "FROM Cart\n" +
                "    INNER JOIN User ON Cart.user_id = User.id\n" +
                "    INNER JOIN Product ON Cart.product_id = Product.id\n" +
                "WHERE User.First_name = ?;";

        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);
            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            BigDecimal orderSum = BigDecimal.valueOf(0);

            System.out.println("Database view: ");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id") + " | ");
                System.out.print("First name: " + resultSet.getString("First_name") + " | ");
                System.out.print("Second name: " + resultSet.getString("Last_name") + " | ");
                System.out.print("Amount of money: " + resultSet.getBigDecimal("Amount_of_money") + " | ");
                System.out.print("Product: " + resultSet.getString("Product_name") + " | ");
                System.out.println("Price: " + resultSet.getBigDecimal("Price") + " | ");
                orderSum = orderSum.add(resultSet.getBigDecimal("Price"));
            }
            System.out.println("Order price: " + orderSum);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


    public final void buyProduct(String userName) {
        String query = "SELECT Cart.id, User.First_name, User.Last_name, User.Amount_of_money,\n" +
                "       Product.Product_name, Product.Price\n" +
                "FROM Cart\n" +
                "    INNER JOIN User ON Cart.user_id = User.id\n" +
                "    INNER JOIN Product ON Cart.product_id = Product.id\n" +
                "WHERE User.First_name = ?";

        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);
            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            BigDecimal orderSum = BigDecimal.valueOf(0);
            BigDecimal userAmountOfMoney = BigDecimal.valueOf(0);

            while (resultSet.next()) {
                orderSum = orderSum.add(resultSet.getBigDecimal("Price"));
                userAmountOfMoney = resultSet.getBigDecimal("Amount_of_money");
            }

            if(userAmountOfMoney.compareTo(orderSum) < 0) {
                throw new NotEnoughMoneyToBuy("Not enough money to buy these products");
            } else {
                updateUserAmountOfMoney(userName, userAmountOfMoney.subtract(orderSum));
                System.out.println("Products purchased successfully");
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


    private final void updateUserAmountOfMoney(String userName, BigDecimal amountOfMoney) {
        String query = "UPDATE Uset SET Amount_of_money = ? WHERE First_name = ?";
        try{
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);
            preparedStatement.setBigDecimal(1, amountOfMoney);
            preparedStatement.setString(2, userName);

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
