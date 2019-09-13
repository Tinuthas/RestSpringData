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
    private ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping()
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Produto buscar(@PathVariable int codigo){
        return produtoRepository.findById(codigo).get();
    }

    @GetMapping("/cadastrar")
    public String abrirFormulario(Produto produto){
        return "produto/form";
    }

    @GetMapping("/listar")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produto/lista";
    }


}
