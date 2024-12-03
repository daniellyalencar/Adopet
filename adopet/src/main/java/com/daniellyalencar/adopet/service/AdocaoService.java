package com.daniellyalencar.adopet.service;

import com.daniellyalencar.adopet.dto.AprovacaoAdocaoDto;
import com.daniellyalencar.adopet.dto.ReprovacaoAdocaoDto;
import com.daniellyalencar.adopet.dto.SolicitacaoAdocaoDto;
import com.daniellyalencar.adopet.model.Adocao;
import com.daniellyalencar.adopet.model.Pet;
import com.daniellyalencar.adopet.model.Tutor;
import com.daniellyalencar.adopet.repository.AdocaoRepository;
import com.daniellyalencar.adopet.repository.PetRepository;
import com.daniellyalencar.adopet.repository.TutorRepository;
import com.daniellyalencar.adopet.validacoes.ValidacaoSolicitacaoAdocao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

//    @Autowired
//    private EmailService emailService;

    @Autowired
    private List<ValidacaoSolicitacaoAdocao> validacoes;

    public void solicitar(@Valid SolicitacaoAdocaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

        validacoes.forEach(v -> v.validar(dto));
        Adocao adocao = new Adocao(pet, tutor, dto.motivo());
        repository.save(adocao);

    }

    public void aprovar(@Valid AprovacaoAdocaoDto dto) {
        Adocao adocao = repository.getReferenceById(dto.idAdocao());
        adocao.marcarComoAprovado();

//        emailService.enviarEmail(
//            adocao.getTutor().getEmail(),
//            "Adoção aprovada",
//            "Olá " +adocao.getTutor().getNome() +"!\n\nSua solicitação de adoção para o pet " +adocao.getPet().getNome() +
//                    " foi aprovada. \nEntre em contato com o abrigo para combinar a entrega do pet.");
    }

    public void reprovar(@Valid ReprovacaoAdocaoDto dto) {
        Adocao adocao = repository.getReferenceById(dto.idAdocao());
        adocao.marcarComoReprovado(dto.justificativa());

//        emailService.enviarEmail(
//            adocao.getTutor().getEmail(),
//            "Adoção reprovada",
//            "Olá " +adocao.getTutor().getNome() +"!\n\nInfelizmente sua solicitação de adoção para o pet " +adocao.getPet().getNome() +
//                    ", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
//                    +" foi reprovada. \nEntre em contato com o abrigo para mais informações.");
    }

    public List<Adocao> listar() {
        System.out.println("Listando adocoes");
        System.out.println(repository.findAll());
        return repository.findAll();
    }

}
