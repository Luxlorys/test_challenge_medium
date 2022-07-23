package core.repository;

/*
create table Product (
    Id           int auto_increment,
    Product_name varchar(32) not null,
    Price        int         not null,
    constraint Product_pk
        primary key (Id)
);

create unique index Product_Product_name_uindex
    on Product (Product_name);

*/

import core.dao.DAO;
import core.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {
    private final DAO dao;

    public ProductRepository(DAO dao) {
        this.dao = dao;
    }

    public final void addProduct(Product product) {
        String query = "INSERT INTO Product (Product_name, price) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setBigDecimal(2, product.getProductPrice());

            if(preparedStatement.executeUpdate() == 1) {
                System.out.println("Product: " + product.getProductName() + " successfully added");
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }


    public final void deleteProduct(String productName) {
        String query = "DELETE FROM Product WHERE Product_name = ?";
        try {
            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);

            preparedStatement.setString(1, productName);

            if(preparedStatement.executeUpdate() == 1) {
                System.out.println("Product: " + productName + " successfully deleted");
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public final void getAllProducts() {
        try {
            String query = "SELECT  * FROM Product";

            PreparedStatement preparedStatement = dao.connectionToDB().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Database view: ");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id") + " | ");
                System.out.print("Product: " + resultSet.getString("Product_name") + " | ");
                System.out.println("Product price: " + resultSet.getBigDecimal("Price") + " | ");

            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
