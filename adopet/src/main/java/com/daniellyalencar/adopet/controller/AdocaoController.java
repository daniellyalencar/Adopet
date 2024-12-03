package com.daniellyalencar.adopet.controller;

import com.daniellyalencar.adopet.dto.AprovacaoAdocaoDto;
import com.daniellyalencar.adopet.dto.ReprovacaoAdocaoDto;
import com.daniellyalencar.adopet.dto.SolicitacaoAdocaoDto;
import com.daniellyalencar.adopet.exception.ValidacaoException;
import com.daniellyalencar.adopet.model.Adocao;
import com.daniellyalencar.adopet.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    AdocaoService adocaoService;

    @PostMapping(consumes = "application/json")
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoAdocaoDto dto) {
        try {
            this.adocaoService.solicitar(dto);
            return ResponseEntity.ok("Solicitação de adoção enviada com sucesso!");
        } catch (ValidacaoException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

}

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovacaoAdocaoDto dto) {
        this.adocaoService.aprovar(dto);
        return ResponseEntity.ok().build();
}

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovacaoAdocaoDto dto) {
        this.adocaoService.reprovar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Adocao>> listar() {
        List<Adocao> adocoes = adocaoService.listar();
        return ResponseEntity.ok(adocoes);
    }

}
