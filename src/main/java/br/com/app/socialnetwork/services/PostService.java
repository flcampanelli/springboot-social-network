package br.com.app.socialnetwork.services;

import br.com.app.socialnetwork.entities.Post;
import br.com.app.socialnetwork.repositories.PostRepository;
import br.com.app.socialnetwork.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text); // Just for study purpose
        //return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // add one day
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
