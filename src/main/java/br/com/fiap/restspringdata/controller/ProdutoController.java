package br.com.fiap.restspringdata.controller;

import br.com.fiap.restspringdata.entity.Produto;
import br.com.fiap.restspringdata.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping()
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Produto buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }


}
