package com.daniellyalencar.adopet.service;

import com.daniellyalencar.adopet.dto.CadastroPetDto;
import com.daniellyalencar.adopet.dto.PetDTO;
import com.daniellyalencar.adopet.model.Abrigo;
import com.daniellyalencar.adopet.model.Pet;
import com.daniellyalencar.adopet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDTO> buscarPetsDisponiveis() {
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDTO::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        Pet pet = new Pet(dto, abrigo);
        repository.save(pet);
    }

}
