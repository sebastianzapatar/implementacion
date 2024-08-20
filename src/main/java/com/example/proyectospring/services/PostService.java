package com.example.proyectospring.services;

import com.example.proyectospring.dao.PostRepository;
import com.example.proyectospring.modelentity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }
    @Transactional
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
