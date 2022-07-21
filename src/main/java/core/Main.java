package core;

import core.dao.MysqlDAO;
import core.entity.User;
import core.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        User user = new User("Andrew", "Burcev", 15000);
        MysqlDAO mysql = new MysqlDAO();

        UserRepository userRepository = new UserRepository(mysql);
        System.out.println(userRepository.registerNewUser(user));
    }
}