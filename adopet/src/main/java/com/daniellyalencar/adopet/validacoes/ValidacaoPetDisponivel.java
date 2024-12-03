package com.daniellyalencar.adopet.validacoes;

import com.daniellyalencar.adopet.dto.SolicitacaoAdocaoDto;
import com.daniellyalencar.adopet.exception.ValidacaoException;
import com.daniellyalencar.adopet.model.StatusAdocao;
import com.daniellyalencar.adopet.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    AdocaoRepository adocaoRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        boolean petJaAdotado = adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.APROVADO);
        if (petJaAdotado) {
            throw new ValidacaoException("Pet não disponível para adoção!");
        }
    }

}
