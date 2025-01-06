package org.example.literatualura.DTO;

import java.util.List;

public class DTOMapAuthorLang {

    private String name;
    private Integer birthDate;
    private Integer deathDate;

    private String bookNames;

    private List<String> lang;

    public DTOMapAuthorLang() {
    }

    public DTOMapAuthorLang(String name, Integer birthDate, Integer deathDate, String bookNames, List<String> lang) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.bookNames = bookNames;
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Integer deathDate) {
        this.deathDate = deathDate;
    }

    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    public String getBookNames() {
        return bookNames;
    }

    public void setBookNames(String bookNames) {
        this.bookNames = bookNames;
    }

}
