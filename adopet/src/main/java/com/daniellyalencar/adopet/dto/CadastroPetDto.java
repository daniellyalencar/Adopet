package com.daniellyalencar.adopet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CadastroPetDto(@NotBlank String nome,
                             @NotBlank String tipo,
                             @Positive double peso,
                             @NotBlank String raca,
                             @Positive int idade,
                             @NotBlank String cor) {

}
