package com.rin.blogopen.service.impl;


import com.rin.blogopen.model.Blog;
import com.rin.blogopen.model.Category;
import com.rin.blogopen.repository.BlogRepository;
import com.rin.blogopen.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Service
public class BlogServiecImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findBlogByCreateDateContainingCustom(String s, Pageable pageable) {
        return blogRepository.findBlogByCreateDateContainingCustom(s,pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }



    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findBlogByContentOrTitleOrCreateDate(String content, String title, Date createDate, Pageable pageable) {
        return blogRepository.findBlogByContentOrTitleOrCreateDate(content, title, createDate, pageable);
    }

    @Override
    public Page<Blog> findBlogByCreateDate(Date createDate, Pageable pageable) {
        return blogRepository.findBlogByCreateDate(createDate, pageable);
    }

    @Override
    public Page<Blog> findBlogByContentOrTitle(String content, String title, Pageable pageable) {
        return blogRepository.findBlogByContentOrTitle(content, title, pageable);
    }

    @Override
    public Page<Blog> findBlogByCategoryOrderById(Category category, Pageable pageable) {
        return blogRepository.findBlogByCategoryOrderById(category, pageable);
    }

//    @Override
//    public Page<Blog> findBlogByCreateDateContainingCustom( String s, Pageable pageable)  {
//    int calendar = Calendar.getInstance().get(Calendar.YEAR);
//        s= s+"-"+calendar;
//       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//       java.util.Date format1= format.parse();
////        Date format2 = new Date(format1.getTime());
//        return blogRepository.findBlogByCreateDateContainingCustom(format2, pageable);
//    }
}