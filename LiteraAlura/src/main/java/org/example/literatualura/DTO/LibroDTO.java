package org.example.literatualura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LibroDTO {

    @JsonAlias("results")
    List<DatesWrapper> response;

    public LibroDTO() {
    }

    public LibroDTO(List<DatesWrapper> response) {
        this.response = response;
    }

    public List<DatesWrapper> getResponse() {
        return response;
    }

    public void setResponse(List<DatesWrapper> response) {
        this.response = response;
    }

}
