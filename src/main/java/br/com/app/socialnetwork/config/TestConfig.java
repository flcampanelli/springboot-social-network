package br.com.app.socialnetwork.config;

import br.com.app.socialnetwork.dto.AuthorDTO;
import br.com.app.socialnetwork.entities.Post;
import br.com.app.socialnetwork.entities.User;
import br.com.app.socialnetwork.repositories.PostRepository;
import br.com.app.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User endrickUser = new User(null, "Endrick", "endrick@gmail.com");
        User estevaoUser = new User(null, "Estevão", "estevao@gmail.com");
        User luisUser = new User(null, "Luis Guilherme", "luis@gmail.com");
        userRepository.saveAll(Arrays.asList(endrickUser, estevaoUser, luisUser));

        Post endrickFirstPost = new Post(
            null,
            dateFormat.parse("30/05/2024"),
            "Partiu viagem",
            "Vamos meu palmeiras, acompanhando vocês de onde eu estiver!",
            new AuthorDTO(endrickUser)
        );
        Post endrickSecondPost = new Post(
            null,
            dateFormat.parse("01/06/2024"),
            "Você é fera Vini Jr.",
            "Gols importantes!",
            new AuthorDTO(endrickUser)
        );
        postRepository.saveAll(Arrays.asList(endrickFirstPost, endrickSecondPost));

        endrickUser.getPosts().addAll(Arrays.asList(endrickFirstPost, endrickSecondPost));
        userRepository.save(endrickUser);
    }
}
