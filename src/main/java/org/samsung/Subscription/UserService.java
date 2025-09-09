package org.samsung.Subscription;

import java.util.Random;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User userRegister(String name, String email) {
        if(userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already exists!");
        }
        Random random = new Random();
        User user = new User(random.nextInt(10), name,email);
        return  userRepository.save(user);
    }

}
