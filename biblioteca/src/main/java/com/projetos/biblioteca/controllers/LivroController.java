package com.projetos.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.biblioteca.service.ServicoLivros;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private ServicoLivros servicoLivros;

    @GetMapping
    public ResponseEntity<?> listarLivros() {
        return servicoLivros.listar();
    }

    @GetMapping("/{termo}")
    public ResponseEntity<?> listarLivros(@PathVariable String termo) {
        return servicoLivros.listar(termo);
    }
}
