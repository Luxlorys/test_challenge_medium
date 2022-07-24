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

//       Deal with products
        Product product = new Product("Product name", BigDecimal.valueOf(123));
        ProductRepository productRepository = new ProductRepository(MYSQL_DAO);
        productRepository.addProduct(product);
        productRepository.getAllProducts();
        productRepository.deleteProduct("Product name");



//        Deal with user
        User user = new User("First name", "Second name", BigDecimal.valueOf(1234));
        UserRepository userRepository = new UserRepository(MYSQL_DAO);
        userRepository.addNeUser(user);
        userRepository.getAllUsers();
        userRepository.deleteUser("User name");



        CartRepository cartRepository = new CartRepository(MYSQL_DAO);
        cartRepository.addProductToCart(1, 1); // id of user and product
        cartRepository.getUserCart("User name"); // get all products certain user in cart
        cartRepository.deleteOrder(1);
        cartRepository.getAllOrders();
        cartRepository.buyProduct("User name"); // buy all products certain user

    }
}