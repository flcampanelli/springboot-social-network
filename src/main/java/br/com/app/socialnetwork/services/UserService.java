package br.com.app.socialnetwork.services;

import br.com.app.socialnetwork.entities.User;
import br.com.app.socialnetwork.repositories.UserRepository;
import br.com.app.socialnetwork.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
