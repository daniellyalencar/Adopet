package com.daniellyalencar.adopet.validacoes;

import com.daniellyalencar.adopet.dto.SolicitacaoAdocaoDto;
import com.daniellyalencar.adopet.exception.ValidacaoException;
import com.daniellyalencar.adopet.model.StatusAdocao;
import com.daniellyalencar.adopet.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorComLimiteDeAdocoes implements ValidacaoSolicitacaoAdocao {

    @Autowired
    AdocaoRepository adocaoRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        int qtdAdocoes = adocaoRepository.contAdocoesByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);
            if(qtdAdocoes >= 5) {
                throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
            }
    }

}
