package org.example.literatualura.Repository;

import org.example.literatualura.Entitys.LenguageEntity;
import org.example.literatualura.Entitys.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {
    @Query(value = "SELECT * FROM lenguage_entity WHERE lenguage = :elect", nativeQuery = true)
    List<LenguageEntity> findLenguage(@Param("elect") String elect);

    boolean existsByTitles(String titles);

    @Query("SELECT l FROM LibroEntity l JOIN l.author a WHERE a.birthDate BETWEEN :year AND (:year - MOD(:year, 100) + 99)")
    List<LibroEntity> findBooksByAuthorBirthYear(@Param("year") Integer year);

    @Query("SELECT l FROM LibroEntity l JOIN l.languages a WHERE a.lenguage = :languageQuery")
    List<LibroEntity> findBooksByLanguages(@Param("languageQuery") String languageQuery);

}
