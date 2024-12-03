package com.daniellyalencar.adopet.controller;

import com.daniellyalencar.adopet.dto.PetDTO;
import com.daniellyalencar.adopet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pet", consumes = "application/json")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDTO>> listarDisponiveis() {
        List<PetDTO> pets = service.buscarPetsDisponiveis();
        return ResponseEntity.ok(pets);
    }

}
