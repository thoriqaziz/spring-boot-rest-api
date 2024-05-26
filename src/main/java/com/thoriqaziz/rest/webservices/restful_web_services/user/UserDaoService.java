package com.thoriqaziz.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Laura", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Stephanie", LocalDate.now().minusYears(26)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteUserById(int id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
