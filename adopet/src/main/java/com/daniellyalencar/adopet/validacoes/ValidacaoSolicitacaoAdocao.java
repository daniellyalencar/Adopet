package com.daniellyalencar.adopet.validacoes;

import com.daniellyalencar.adopet.dto.SolicitacaoAdocaoDto;
import jakarta.validation.Valid;

public interface ValidacaoSolicitacaoAdocao {

    void validar(@Valid SolicitacaoAdocaoDto dto);

}
