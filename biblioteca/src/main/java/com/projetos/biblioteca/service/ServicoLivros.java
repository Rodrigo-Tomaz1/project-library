package com.projetos.biblioteca.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.projetos.biblioteca.repositorys.LivroRepository;

@Service
public class ServicoLivros {
    @Autowired
    private LivroRepository livroRepository;
    private Mensagem mensagem = new Mensagem();

    public ResponseEntity<?> listar(){
        return new ResponseEntity<>(livroRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listar(String termo){
        if(livroRepository.findByNomeLivroContaining(termo).isEmpty()){
            mensagem.setMensagem("Erro! Livro não encontrado.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(livroRepository.findByNomeLivroContaining(termo), HttpStatus.OK);
    }
}
