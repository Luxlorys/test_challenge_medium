package core;

import core.dao.MysqlDAO;
import core.entity.Product;
import core.entity.User;
import core.repository.CartRepository;
import core.repository.ProductRepository;
import core.repository.UserRepository;

import java.math.BigDecimal;

public class Main {

    private final static MysqlDAO MYSQL_DAO = new MysqlDAO();
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository(MYSQL_DAO);
        UserRepository userRepository = new UserRepository(MYSQL_DAO);
        CartRepository cartRepository = new CartRepository(MYSQL_DAO);
//
//        User user = new User("123", "123", BigDecimal.valueOf(12));
//        Product product = new Product("321", BigDecimal.valueOf(15));
//
//        System.out.println("Add new user");
//        userRepository.registerNewUser(user);
//
//        System.out.println("Add new product");
//        productRepository.addProduct(product);

//        cartRepository.getAllOrders();

//        cartRepository.getUserCart("TestName");
        cartRepository.addProductToCart(6, 5);

    }
}