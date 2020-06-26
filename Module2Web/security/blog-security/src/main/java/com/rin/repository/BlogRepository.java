package com.rin.repository;


import com.rin.model.Blog;
import com.rin.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findBlogByCreateDate(Date createDate, Pageable pageable);

    Page<Blog> findBlogByContentOrTitle(String content, String title, Pageable pageable);

    Page<Blog> findBlogByContentOrTitleOrCreateDate(String content, String title, Date date, Pageable pageable);

    Page<Blog> findBlogByCategoryOrderById(Category category, Pageable pageable);


}