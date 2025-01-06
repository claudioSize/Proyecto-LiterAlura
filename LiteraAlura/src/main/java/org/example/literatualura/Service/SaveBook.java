package org.example.literatualura.Service;

import org.example.literatualura.DTO.AuthorDTO;
import org.example.literatualura.DTO.DatesWrapper;
import org.example.literatualura.DTO.LenguageDTO;
import org.example.literatualura.DTO.LibroDTO;
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
public class SaveBook {
    @Autowired
    Template template;
    @Autowired
    LibroRepository libroRepository;

    //Metodo que permite la busqueda del libro en la api y si la encuentra convierte los dto en entidades y lo guarda en la base de datos
    public LibroEntity saveBook(String name){
        LibroEntity libro = new LibroEntity();

        String peti = name.replace(" ","+");
        LibroDTO dto = template.response(peti);

        if (dto == null || dto.getResponse().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        DatesWrapper response = dto.getResponse().get(0);


        convertAuthorToEntity(response, libro);
        converLengToEntity(response, libro);

        if (libroRepository.existsByTitles(response.getTitles())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El registro ya existe.");
        }

        libro.setTitles(response.getTitles());
        libro.setDownCount(response.getDownCount());

        try {
            libroRepository.save(libro);
            return libro;
        }catch (Exception e){
            throw new IllegalArgumentException("Error al hacer el registro");
        }

    }
//Metodo para convertir el dto de autor en la entidad autor para guardarlo en la base de datos
    public void convertAuthorToEntity(DatesWrapper datesWrapper, LibroEntity libro){
        List<AuthorEntity> authorList = new ArrayList<>();
        List<AuthorDTO> authorDTO = datesWrapper.getAuthot();
        for (AuthorDTO auto : authorDTO){
            AuthorEntity author = new AuthorEntity();
            author.setNombre(auto.getNombre());
            author.setBirthDate(auto.getBirthDate());
            author.setDeathdate(auto.getDeathdate());
            author.setLibroEntity(libro);
            authorList.add(author);
        }
        libro.setAuthor(authorList);
    }
    //Tambien para convertir dto en entity
    public void converLengToEntity(DatesWrapper datesWrapper, LibroEntity libro){
        List<LenguageEntity> lenguList = new ArrayList<>();
        List<LenguageDTO> lenDTO = datesWrapper.getLanguages();
        for (LenguageDTO lenguageDTO : lenDTO){
            LenguageEntity lenguage = new LenguageEntity();
            lenguage.setLenguage(lenguageDTO.getLenguage());
            lenguage.setLibroEntity(libro);
            lenguList.add(lenguage);
        }
        libro.setLanguages(lenguList);
    }

}

