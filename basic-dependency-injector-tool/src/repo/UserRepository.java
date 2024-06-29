package repo;

import entity.User;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private List<User> users = Arrays.asList(new User("a"),
                                            new User("b"),
                                            new User("c"));

    public User findByName(String name) {

        return users.stream().filter(user -> {
            return user.getName().equalsIgnoreCase(name);
        }).findFirst().orElseThrow(null);
    }
}
