package org.example.literatualura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatesWrapper {
    @JsonAlias("id") private Integer id;
    @JsonAlias("title") private String titles;
    @JsonAlias("authors") private List<AuthorDTO> authot;
    @JsonAlias("languages") private List<LenguageDTO> languages;
    @JsonAlias("download_count") private Integer downCount;

    public DatesWrapper(Integer id, String titles, List<AuthorDTO> author, List<LenguageDTO> languages, Integer downCount) {
        this.id = id;
        this.titles = titles;
        this.authot = author;
        this.languages = languages;
        this.downCount = downCount;
    }

    public DatesWrapper() {
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

    public List<AuthorDTO> getAuthot() {
        return authot;
    }

    public void setAuthot(List<AuthorDTO> authot) {
        this.authot = authot;
    }

    public List<LenguageDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LenguageDTO> languages) {
        this.languages = languages;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }



}