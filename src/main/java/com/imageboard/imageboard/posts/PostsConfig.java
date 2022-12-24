package com.imageboard.imageboard.posts;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PostsConfig {
    @Value("${corsorigin}")
    private String corsOrigin;

    @Bean
    CommandLineRunner commandLineRunner(PostsRepository repository){
        return args->{
            Posts post1 = new Posts(
                    "FerjaniSassi",
                    "My First Post",
                    "Hello this is a caption",
                    "imgSource"
            );
            Posts post2 = new Posts(
                    "NaiimSliti",
                    "Here's a cool post",
                    "Woohoo this is a caption",
                    "imgSrc"
            );
            repository.saveAll(
                    List.of(post1, post2)
            );
            System.out.println("Allowed Origins Are: " + corsOrigin);

        };
    }
}
