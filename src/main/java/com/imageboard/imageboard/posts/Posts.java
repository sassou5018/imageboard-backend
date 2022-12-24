package com.imageboard.imageboard.posts;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Posts {
    @Id
    @SequenceGenerator(
            name= "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long postId;
    private String author;
    private String title;
    private String caption;
    private String imgSrc;
    private LocalDate postDate;

    public Posts() {
    }

    public Posts(String author, String title, String caption, String imgSrc) {
        this.author = author;
        this.title = title;
        this.caption = caption;
        this.imgSrc = imgSrc;
        this.postDate = LocalDate.now();
    }

    public Posts(String title, String caption, String imgSrc) {
        this.title = title;
        this.caption = caption;
        this.imgSrc = imgSrc;
        this.author = "Anonym";
        this.postDate = LocalDate.now();
    }

    @PrePersist
    public void preInsert(){
        if(this.postDate == null){
            this.postDate = LocalDate.now();
        }
        if(this.author == null){
            this.author = "Anonym";
        }
    }



    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }



    @Override
    public String toString() {
        return "Posts{" +
                "postId=" + postId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}


