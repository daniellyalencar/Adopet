package com.daniellyalencar.adopet.service;

import com.daniellyalencar.adopet.dto.AbrigoDTO;
import com.daniellyalencar.adopet.dto.CadastroAbrigoDto;
import com.daniellyalencar.adopet.dto.PetDTO;
import com.daniellyalencar.adopet.exception.ValidacaoException;
import com.daniellyalencar.adopet.model.Abrigo;
import com.daniellyalencar.adopet.repository.AbrigoRepository;
import com.daniellyalencar.adopet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDTO> listar() {
        return abrigoRepository
                .findAll()
                .stream()
                .map(AbrigoDTO::new)
                .toList();
    }

    public void cadastrar(CadastroAbrigoDto dto) {
        boolean jaCadastrado = abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());
        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }

        abrigoRepository.save(new Abrigo(dto));
    }


    public List<PetDTO> listarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);
        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDTO::new)
                .toList();
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional = Optional.empty();
        try {
            Long id = Long.parseLong(idOuNome);
            optional = abrigoRepository.findById(id);
        } catch (NumberFormatException e) {
            Abrigo abrigo = abrigoRepository.findByNome(idOuNome);
        }
            return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado!"));
    }

}
