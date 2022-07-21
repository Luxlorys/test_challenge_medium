package core.entity;

public class Cart {

    private final Product product;
    private final User user;

    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
