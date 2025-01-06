package org.example.literatualura.DTO;

import java.util.List;

public class DTOMapBook {
    private String name;

    private List<String> Author;

    private List<String> lang;

    private Integer countDown;

    public DTOMapBook() {
    }

    public DTOMapBook(String name, List<String> author, List<String> lang, Integer countDown) {
        this.name = name;
        Author = author;
        this.lang = lang;
        this.countDown = countDown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthor() {
        return Author;
    }

    public void setAuthor(List<String> author) {
        Author = author;
    }

    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    public Integer getCountDown() {
        return countDown;
    }

    public void setCountDown(Integer countDown) {
        this.countDown = countDown;
    }
}
