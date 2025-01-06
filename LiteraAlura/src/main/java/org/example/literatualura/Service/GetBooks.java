package org.example.literatualura.Service;

import org.example.literatualura.DTO.DTOMapBook;
import org.example.literatualura.Entitys.AuthorEntity;
import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.example.literatualura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetBooks {
    @Autowired
    LibroRepository libroRepository;

    public List<DTOMapBook> getBooksList(){
        List<LibroEntity> libro = libroRepository.findAll();

        if (libro.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existen registros.");
        }

        return AEntityToDTO(libro);
    }

    public List<DTOMapBook> AEntityToDTO(List<LibroEntity> libroEntity){
        List<DTOMapBook> listAuthor = new ArrayList<>();
        for (LibroEntity libroEntity1:libroEntity){
            DTOMapBook dto = new DTOMapBook();

            List<String> arrAuthor = new ArrayList<>();

            dto.setName(libroEntity1.getTitles());
            for (AuthorEntity authorEntity : libroEntity1.getAuthor()){
                arrAuthor.add(authorEntity.getNombre());
            }
            dto.setAuthor(arrAuthor);
            List<String> arr = new ArrayList<>();
            for (LenguageEntity lenguage1:libroEntity1.getLanguages()){
                arr.add(lenguage1.getLenguage());
            }
            dto.setCountDown(libroEntity1.getDownCount());
            dto.setLang(arr);
            listAuthor.add(dto);
        }

        return listAuthor;
    }

}
