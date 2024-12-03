package com.daniellyalencar.adopet.dto;

import com.daniellyalencar.adopet.model.Pet;
import com.daniellyalencar.adopet.model.TipoPet;

public record PetDTO(Long id, TipoPet tipo, String nome, String raca, Integer idade) {

    public PetDTO(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }

}
