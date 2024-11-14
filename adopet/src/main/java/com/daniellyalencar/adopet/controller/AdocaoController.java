package com.daniellyalencar.adopet.controller;

import com.daniellyalencar.adopet.dto.AdocaoDTO;
import com.daniellyalencar.adopet.model.Adocao;
import com.daniellyalencar.adopet.model.Pet;
import com.daniellyalencar.adopet.model.StatusAdocao;
import com.daniellyalencar.adopet.model.Tutor;
import com.daniellyalencar.adopet.repository.AdocaoRepository;
import com.daniellyalencar.adopet.repository.PetRepository;
import com.daniellyalencar.adopet.repository.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/adocao")
public class AdocaoController {

    @Autowired
    AdocaoRepository repository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    TutorRepository tutorRepository;

    @PostMapping(consumes = "application/json")
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid AdocaoDTO adocaoDTO) {

        Pet pet = petRepository.getReferenceById(adocaoDTO.getPetId());
        Tutor tutor = tutorRepository.getReferenceById(adocaoDTO.getTutorId());

        try {
            if (repository.existsPetComAdocaoEmAndamento(pet.getId(), StatusAdocao.AGUARDANDO_AVALIACAO)) {
                return ResponseEntity.badRequest().body("Já existe uma adoção em andamento para este pet");
            }
            if (repository.existsTutorComAdocaoEmAndamento(tutor.getId(), StatusAdocao.AGUARDANDO_AVALIACAO)) {
                return ResponseEntity.badRequest().body("Já existe uma adoção em andamento para este tutor");
            }
            if(repository.contAdocoesByTutorIdAndStatus(tutor.getId(), StatusAdocao.APROVADO)) {
                return ResponseEntity.badRequest().body("Este tutor já atingiu o limite de adoções");
            }

            Adocao novaAdocao = new Adocao(pet, tutor, adocaoDTO.getMotivo());
            repository.save(novaAdocao);
            return ResponseEntity.ok("Adoção solicita com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao solicitar adoção");
        }

}

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid Adocao adocao) {
    adocao.setStatus(StatusAdocao.APROVADO);
    repository.save(adocao);
    return ResponseEntity.ok().build();
}

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid Adocao adocao) {
        adocao.setStatus(StatusAdocao.REPROVADO);
        repository.save(adocao);
        return ResponseEntity.ok().build();
    }

}
