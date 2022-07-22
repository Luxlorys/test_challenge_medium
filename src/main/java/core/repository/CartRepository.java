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

public class CartRepository {

    private final DAO dao;

    public CartRepository(DAO dao) {
        this.dao = dao;
    }
}
