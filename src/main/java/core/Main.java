package core;

import core.dao.MysqlDAO;
import core.entity.Product;
import core.repository.ProductRepository;

public class Main {

    private final static MysqlDAO MYSQL_DAO = new MysqlDAO();
    public static void main(String[] args) {
        Product product = new Product("Laptop", 25000);

        ProductRepository productRepository = new ProductRepository(MYSQL_DAO);
//        System.out.println(productRepository.addProduct(product));
        productRepository.deleteProduct("Laptop");
        productRepository.displayAllProducts();
    }
}