package com.daniellyalencar.adopet.repository;

import com.daniellyalencar.adopet.model.Abrigo;
import com.daniellyalencar.adopet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByAdotadoFalse();
    List<Pet> findByAbrigo(Abrigo abrigo);


}
