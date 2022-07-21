package core.entity;

import java.math.BigInteger;

public class Product {

    private final User user;
    private final String productName;
    private final BigInteger productPrice;

    public Product(User user, String productName, BigInteger productPrice) {
        this.user = user;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public User getUser() {
        return user;
    }

    public String getProductName() {
        return productName;
    }

    public BigInteger getProductPrice() {
        return productPrice;
    }
}
