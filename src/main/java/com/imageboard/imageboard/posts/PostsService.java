package com.imageboard.imageboard.posts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.util.List;

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

    public Boolean verifyImageSrc(String url1) {
        try {
            Image image = ImageIO.read(new URL(url1));
            if (image != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
