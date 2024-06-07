package br.com.app.socialnetwork.services;

import br.com.app.socialnetwork.entities.Post;
import br.com.app.socialnetwork.repositories.PostRepository;
import br.com.app.socialnetwork.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
