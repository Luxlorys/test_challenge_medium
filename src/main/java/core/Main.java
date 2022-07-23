package core;

import core.dao.MysqlDAO;
import core.entity.Product;
import core.repository.ProductRepository;

import java.math.BigDecimal;

public class Main {

    private final static MysqlDAO MYSQL_DAO = new MysqlDAO();
    public static void main(String[] args) {
        Product product = new Product("Asus Zenbook 14 UM425UA", BigDecimal.valueOf(12000));

        ProductRepository productRepository = new ProductRepository(MYSQL_DAO);
        productRepository.addProduct(product);
//        productRepository.deleteProduct("Laptop");
        productRepository.getAllProducts();
    }
}