package com.c0822g1primaryschoolbe.blogDto;

//Created: LinhPT,
//Date create: 27/02/2023
//Description: BlogDto create use Blog list and find by id

public interface BlogDto {
    Long getId();
    String getTitle();
    String getContents();
    String getStart_date();
    String getPoster();
    String getImg();
}
