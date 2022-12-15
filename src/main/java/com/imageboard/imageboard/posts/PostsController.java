package com.imageboard.imageboard.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/posts")
public class PostsController {
    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService){
        this.postsService = postsService;
    }

    @GetMapping
    public List<Posts> getAllPosts(){
        return postsService.getAllPosts();
    }

    @GetMapping(path="/paginated")
    public List<Posts> getAllPaginated(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1") int size
    ){
        Pageable pageable = PageRequest.of(page,size);
        return postsService.getAllPaginated(pageable);
    }

    @PostMapping
    public Posts addNewPost(@RequestBody Posts post){
        return postsService.addNewPost(post);
    }

    @GetMapping(path = "{id}")
    public Optional<Posts> getPostById(@PathVariable Long id){
        return postsService.getPostById(id);
    }

    @GetMapping(path="/count")
    public Long getCount(){
        return postsService.getPostsCount();
    }
}
