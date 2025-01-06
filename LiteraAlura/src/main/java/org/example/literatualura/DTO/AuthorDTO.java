package org.example.literatualura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO {

    @JsonAlias("name") private String nombre;
    @JsonAlias("birth_year") private Integer birthDate;
    @JsonAlias("death_year") private Integer deathdate;

    public AuthorDTO() {
    }

    public AuthorDTO(String nombre, Integer birthDate, Integer deathdate) {
        this.nombre = nombre;
        this.birthDate = birthDate;
        this.deathdate = deathdate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(Integer deathdate) {
        this.deathdate = deathdate;
    }

}