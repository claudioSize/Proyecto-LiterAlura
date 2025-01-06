package org.example.literatualura.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "lenguage_entity")
public class LenguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lenguage;

    @ManyToOne
    @JoinColumn(name = "book_entity_id")
    @JsonIgnore
    private LibroEntity libroEntity;

    public LenguageEntity() {
    }

    public LenguageEntity(Integer id, String lenguage, LibroEntity libroEntity) {
        this.id = id;
        this.lenguage = lenguage;
        this.libroEntity = libroEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public LibroEntity getLibroEntity() {
        return libroEntity;
    }

    public void setLibroEntity(LibroEntity libroEntity) {
        this.libroEntity = libroEntity;
    }


}