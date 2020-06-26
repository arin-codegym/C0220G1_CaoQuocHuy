package com.rin.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cataloges")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "blogs_id")
    private List<Blog> blogs;

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Blog> blogs) {
        this.name = name;
        this.blogs = blogs;
    }
//    public Category(String name) {
//        this.name = name;
//    }
//
//
//
//    public Category(Long id, String name, List<Blog> blogs) {
//        this.id = id;
//        this.name = name;
//        this.blogs = blogs;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Blog> getBlogs() {
//        return blogs;
//    }
//
//    public void setBlogs(List<Blog> blogs) {
//        this.blogs = blogs;
//    }
}