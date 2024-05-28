package br.com.app.socialnetwork.config;

import br.com.app.socialnetwork.entities.User;
import br.com.app.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User endrickUser = new User(null, "Endrick", "endrick@gmail.com");
        User estevaoUser = new User(null, "Estevão", "estevao@gmail.com");
        User luisUser = new User(null, "Luis Guilherme", "luis@gmail.com");
        userRepository.saveAll(Arrays.asList(endrickUser, estevaoUser, luisUser));
    }
}
