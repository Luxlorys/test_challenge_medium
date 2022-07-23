package core.entity;

import java.math.BigDecimal;

public class Product {

    private final String productName;
    private final BigDecimal productPrice;

    public Product(String productName, BigDecimal productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }
}
