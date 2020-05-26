package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog){
        Calendar calendar = Calendar.getInstance();
        blog.setCreateDate(calendar.getTime());
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }
    @GetMapping("/blogs")
    public ModelAndView listCustomers(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog){
        Calendar calendar = Calendar.getInstance();
        blog.setCreateDate(calendar.getTime());
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("message", "blog updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }
    @GetMapping("/view-blog/{id}" )
    public ModelAndView view(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView= new ModelAndView("/blog/view");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
}
