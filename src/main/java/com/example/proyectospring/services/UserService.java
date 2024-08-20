package com.example.proyectospring.services;
import com.example.proyectospring.dao.UserRepository;
import com.example.proyectospring.modelentity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findUsersWithLessThanPosts(Long postCount) {
        return userRepository.findUsersWithLessThanPosts(postCount);
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User findUserWithMostPosts() {
        return userRepository.findUserWithMostPosts();
    }
}
