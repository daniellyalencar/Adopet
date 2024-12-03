package com.daniellyalencar.adopet.validacoes;

import com.daniellyalencar.adopet.dto.SolicitacaoAdocaoDto;
import com.daniellyalencar.adopet.exception.ValidacaoException;
import com.daniellyalencar.adopet.model.StatusAdocao;
import com.daniellyalencar.adopet.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        boolean tutorTemAdocaoEmAndamento = adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO);
            if (tutorTemAdocaoEmAndamento) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }

    }

}
