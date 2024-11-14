package com.daniellyalencar.adopet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdocaoDTO(@NotNull Long idPet, @NotNull Long idTutor, @NotBlank String motivo) {
    public Long getPetId() {
        return idPet;
    }

    public Long getTutorId() {
        return idTutor;
    }

    public String getMotivo() {
        return motivo;
    }

}
