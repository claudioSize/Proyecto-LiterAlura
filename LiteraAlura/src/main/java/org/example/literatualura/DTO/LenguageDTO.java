package org.example.literatualura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;

public class LenguageDTO {

    @JsonAlias("languages")private String lenguage;

    public LenguageDTO() {
    }

    public LenguageDTO(String lenguage) {
        this.lenguage = lenguage;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }


}