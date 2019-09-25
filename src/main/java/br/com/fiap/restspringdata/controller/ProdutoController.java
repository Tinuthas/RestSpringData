package br.com.fiap.restspringdata.controller;

import br.com.fiap.restspringdata.entity.Produto;
import br.com.fiap.restspringdata.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/cadastrar")
    public String cadastrar(Produto produto, Model model,  RedirectAttributes redirectAttributes) {
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/produto/listar";
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
    public String abrirFormulario(Produto produto, Model model){
        model.addAttribute("prod", produto);
        return "produto/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prod", produtoRepository.findById(codigo));
        return "produto/form";
    }

    @PostMapping("/excluir")
    public String excluir( int codigo, RedirectAttributes redirectAttributes){
        produtoRepository.deleteById(codigo);
        redirectAttributes.addFlashAttribute("msg","Produto Excluido!");
        return "redirect:/produto/listar";
    }

    @GetMapping("/listar")
    public String listarProdutos(Model model){
        model.addAttribute("prods", produtoRepository.findAll());
        return "produto/lista";
    }


}
