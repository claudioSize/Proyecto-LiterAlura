package org.example.literatualura.Service;

import org.example.literatualura.DTO.DTOMapAuthorLang;
import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAuthor {
    @Autowired
    LibroRepository libroRepository;
    @Autowired
    private Template template;
    //Metodo que devuelve todos los autores en la BD
    public List<DTOMapAuthorLang> getAuthor(){

        List<LibroEntity> libro = libroRepository.findAll();


        return AEntityToDTO(libro);
    }

    public List<DTOMapAuthorLang> AEntityToDTO(List<LibroEntity> libroEntity){
        List<DTOMapAuthorLang> listAuthor = new ArrayList<>();
        for (LibroEntity libroEntity1:libroEntity){
            DTOMapAuthorLang authorDTO = new DTOMapAuthorLang();
            for (AuthorEntity authorEntity : libroEntity1.getAuthor()){
                authorDTO.setName(authorEntity.getNombre());
                authorDTO.setBirthDate(authorEntity.getBirthDate());
                authorDTO.setDeathDate(authorEntity.getDeathdate());
                authorDTO.setBookNames(libroEntity1.getTitles());
            }
            List<String> arr = new ArrayList<>();
            for (LenguageEntity lenguage1:libroEntity1.getLanguages()){
                arr.add(lenguage1.getLenguage());
            }

            authorDTO.setLang(arr);
            listAuthor.add(authorDTO);
        }

        return listAuthor;
    }
}
