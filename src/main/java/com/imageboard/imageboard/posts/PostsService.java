package com.imageboard.imageboard.posts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    public List<Posts> getAllPosts(){
        return postsRepository.findAll();
    }

    public List<Posts> getAllPaginated(Pageable pageable){
        Page<Posts> page = postsRepository.findAll(pageable);
        return page.toList();
    }

    public Long getPostsCount(){
        return postsRepository.count();
    }

    public Boolean verifyImageSrc(String url1) {
        try {
            Image image = ImageIO.read(new URL(url1));
            return image != null;
        } catch (Exception e){
            return false;
        }
    }

    public Posts addNewPost(Posts post){
        if(!this.verifyImageSrc(post.getImgSrc())){
            throw new IllegalStateException("Link doesn't contain an image");
        }
        postsRepository.save(post);
        return post;
    }

    public Optional<Posts> getPostById(Long id){
        Optional<Posts> post = postsRepository.findById(id);
        if(!post.isPresent()){
            throw new IllegalStateException("No post with: " + id + " Exists");
        }
        return post;
    }
}
