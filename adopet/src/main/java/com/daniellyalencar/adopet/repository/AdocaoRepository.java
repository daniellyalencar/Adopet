package com.daniellyalencar.adopet.repository;

import com.daniellyalencar.adopet.model.Adocao;
import com.daniellyalencar.adopet.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    boolean existsByTutorIdAndStatus(Long idTutor, StatusAdocao status);

    @Query("SELECT COUNT(a) FROM Adocao a WHERE a.tutor.id = :idTutor AND a.status = :status")
    int contAdocoesByTutorIdAndStatus(@Param("idTutor") Long idTutor, @Param("status") StatusAdocao status);

}
