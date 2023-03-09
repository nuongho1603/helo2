package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.blogDto.BlogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Create by : LinhPT
 * Date create: 27/02/2023
 * Description: create repository Blog use listBlog and detail Blog
 * @return Page<allList>, findByIdBlog(id)
/ * @param pageable
 */


public interface IBlogService {
    Page<BlogDto> allPageBlog(Pageable pageable);

    BlogDto findById(long id);
}
