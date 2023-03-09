package com.c0822g1primaryschoolbe.repository;
import com.c0822g1primaryschoolbe.blogDto.BlogDto;
import com.c0822g1primaryschoolbe.entity.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/** Create by : LinhPT
 * Date create: 27/02/2023
 * Description: get bulletin list and detail blog
 * @return Page<allList>, findByIdBlog(id)
// * @param pageable
 */

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blog order by start_date desc", nativeQuery = true)
    Page<BlogDto> allList(Pageable pageable);

    @Query(value = "select * from blog where id = :idBlog", nativeQuery = true)
    BlogDto findByIdBlog(@Param("idBlog") long idBlog);

}
