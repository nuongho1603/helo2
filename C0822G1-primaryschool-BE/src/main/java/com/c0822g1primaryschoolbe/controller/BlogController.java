package com.c0822g1primaryschoolbe.controller;


import com.c0822g1primaryschoolbe.blogDto.BlogDto;
import com.c0822g1primaryschoolbe.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by: LinhPT,
 * Date created: 27/02/2023,
 * Function: allPageBlog,
 * return: HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result blogPage
 */

@Controller
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<BlogDto>> getAll(@PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<BlogDto> blogPage = blogService.allPageBlog(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogDto> findByIdBlog(@PathVariable long id) {
        BlogDto blogDto = blogService.findById(id);
        if (blogDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogDto, HttpStatus.OK);
    }

//
    @GetMapping("/detail/{id}")
    public ResponseEntity<BlogDto> detail(@PathVariable long id) {
        BlogDto blogDto = blogService.findById(id);
        if (blogDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogDto, HttpStatus.OK);
    }

}
