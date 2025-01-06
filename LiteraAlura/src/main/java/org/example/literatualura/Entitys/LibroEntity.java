package org.example.literatualura.Entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book_entity")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titles;
    @OneToMany(mappedBy = "libroEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AuthorEntity> author;

    @OneToMany(mappedBy = "libroEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LenguageEntity> languages;
    private Integer downCount;

    public LibroEntity(Integer id, String titles, List<AuthorEntity> author, List<LenguageEntity> languages, Integer downCount) {
        this.id = id;
        this.titles = titles;
        this.author = author;
        this.languages = languages;
        this.downCount = downCount;
    }

    public LibroEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public List<AuthorEntity> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorEntity> author) {
        this.author = author;
    }

    public List<LenguageEntity> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LenguageEntity> languages) {
        this.languages = languages;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

}