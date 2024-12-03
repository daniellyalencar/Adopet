package com.daniellyalencar.adopet.service;

import com.daniellyalencar.adopet.dto.AtualizacaoTutorDto;
import com.daniellyalencar.adopet.dto.CadastroTutorDto;
import com.daniellyalencar.adopet.exception.ValidacaoException;
import com.daniellyalencar.adopet.model.Tutor;
import com.daniellyalencar.adopet.repository.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(@Valid CadastroTutorDto dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());
        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }

        repository.save(new Tutor(dto));
    }

    public void atualizar(@Valid AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizar(dto);
    }

    public List<CadastroTutorDto> listar() {
        return repository
                .findAll()
                .stream()
                .map(tutor -> new CadastroTutorDto(tutor.getNome(), tutor.getEmail(), tutor.getTelefone()))
                .toList();
    }

}
