package com.rin.blogopen.service;

import com.rin.blogopen.model.Blog;
import com.rin.blogopen.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.sql.Date;


public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
    Page<Blog> findBlogByCreateDate(Date createDate, Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findBlogByContentOrTitleOrCreateDate(String content, String title, Date createDate, Pageable pageable);
    Page<Blog> findBlogByContentOrTitle(String content, String title, Pageable pageable);
    Page<Blog> findBlogByCategoryOrderById(Category category, Pageable pageable);

}
