package dao;

import repo.UserRepository;

public class UserDao {

    private final UserRepository userRepository;


    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
