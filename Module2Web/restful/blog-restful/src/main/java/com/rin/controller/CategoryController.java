package com.rin.controller;


import com.rin.model.Blog;
import com.rin.model.Category;
import com.rin.service.BlogService;
import com.rin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

//    @GetMapping(value = "/getBlog")
//    public ResponseEntity<List<Blog>> listAllBlog() {
//
//        List<Blog> blogs =  blogService.findAll();
//        if (blogs.isEmpty()) {
//            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
//    }

    @GetMapping(value = "/getBlog")
    public ResponseEntity<List<Blog>> listAllBlog() {
        List<Category> categories = categoryService.findAll();
        List<Blog> blogs =new ArrayList<>();
        for (Category cate : categories) {
            blogs.addAll(cate.getBlogs());
          //  blogs.addAll(cate.getBlogs());
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
}