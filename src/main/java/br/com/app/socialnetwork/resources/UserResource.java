package br.com.app.socialnetwork.resources;

import br.com.app.socialnetwork.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User endrick = new User("1", "Endrick", "endrick@gmail.com");
        User estevao = new User("2", "Estevão", "estevao@gmail.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(endrick, estevao));
        return ResponseEntity.ok().body(users);
    }
}
