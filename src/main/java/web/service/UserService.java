package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return userRepository.list();
    }

    public User user(int id) {
        return userRepository.user(id);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
    @Transactional
    public void update(User user, int id) {
        userRepository.update(user, id);
    }

    @Transactional
    public void delete(int id) {
        userRepository.delete(id);
    }
}
