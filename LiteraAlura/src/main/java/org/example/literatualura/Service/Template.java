package org.example.literatualura.Service;

import org.example.literatualura.DTO.LibroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Template {

    @Autowired
    private RestTemplate restTemplate;
    private final String url = "https://gutendex.com/books?search=";

    //Metodo para tomar la busqueda del libro y mapearlo en dto
    public LibroDTO response(String search) {
        String srR = search.replace(" ", "+");
        return restTemplate.getForObject(url+srR, LibroDTO.class);
    }


}