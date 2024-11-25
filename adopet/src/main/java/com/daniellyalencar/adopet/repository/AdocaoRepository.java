package com.daniellyalencar.adopet.repository;

import com.daniellyalencar.adopet.model.Adocao;
import com.daniellyalencar.adopet.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByIdAndStatus(Long idPet, StatusAdocao status);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Adocao a WHERE a.pet.id = :petId AND a.status = :status")
    boolean existsPetComAdocaoEmAndamento(@Param("petId") Long idPet, @Param("status") StatusAdocao status);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Adocao a WHERE a.tutor.id = :idTutor AND a.status = :statusAdocao")
    boolean existsTutorComAdocaoEmAndamento(Long idTutor, StatusAdocao statusAdocao);

    default boolean contAdocoesByTutorIdAndStatus(Long id, StatusAdocao statusAdocao) {
        long count = countByTutorIdAndStatus(id, statusAdocao); // Certifique-se de que isso retorna um 'long'
        return count > 5;
    }

    long countByTutorIdAndStatus(Long id, StatusAdocao statusAdocao);

}
