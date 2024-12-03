package com.daniellyalencar.adopet.repository;

import com.daniellyalencar.adopet.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {

    Abrigo findByNome(String nome);
    boolean existsByNomeOrTelefoneOrEmail(String nome, String telefone, String email);

}
