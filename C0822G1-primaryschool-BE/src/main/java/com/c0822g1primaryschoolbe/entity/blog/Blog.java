package com.c0822g1primaryschoolbe.entity.blog;
import javax.persistence.*;
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)")
    private String title;
    @Column(columnDefinition = "longtext")
    private String contents;
    private String startDate;
    private String poster;
    private String img;

    public Blog() {
    }

    public Blog(Long id, String title, String contents, String startDate, String poster, String img) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.poster = poster;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return contents;
    }

    public void setContent(String content) {
        this.contents = content;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}