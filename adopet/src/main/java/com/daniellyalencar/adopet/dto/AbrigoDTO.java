package com.daniellyalencar.adopet.dto;

import com.daniellyalencar.adopet.model.Abrigo;

public record AbrigoDTO(Long id, String nome) {

    public AbrigoDTO(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
