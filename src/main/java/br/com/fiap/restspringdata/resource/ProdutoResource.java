package br.com.fiap.restspringdata.resource;

import br.com.fiap.restspringdata.entity.Produto;
import br.com.fiap.restspringdata.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoResource {

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

    @GetMapping("nome/{nome}")
    public List<Produto> buscarPorNome(@PathVariable String nome){return repository.findByNome(nome);}

    @GetMapping("pesquisa")
    public List<Produto> buscarPorNome(@PathVariable String nome, @PathVariable boolean novo){
        return nome!=null?
                repository.findByNomeAndNovo(nome, novo):
                repository.findByNovo(novo);
    }

    @GetMapping("novo/{novo}")
    public List<Produto> buscarNovo(@PathVariable boolean novo){return repository.findByNovoOrderByNomeDesc(novo);}

    @GetMapping("nomepreco/{nomePreco}")
    public List<Produto> buscarNomePorPreco(@PathVariable String nomePreco){
        return repository.findByNomeIgnoreCaseOrderByPrecoAsc(nomePreco);}

    @GetMapping("nome/{nome}/novo{novo}")
    public List<Produto> buscarPorNomeAndNovo(@PathVariable String nome, @PathVariable boolean novo){
        return repository.findByNomeAndNovo(nome, novo);
    }

    @GetMapping("preco/{preco}")
    public List<Produto> buscarPorPreco(@PathVariable String preco){
        try{
            return repository.findByPrecoGreaterThan(Double.parseDouble(preco));
        }catch (Exception e) {
            return new ArrayList<>();
        }

    }

    @GetMapping("dataInicio/{dataInicio}/dataFim{dataFim }")
    public List<Produto> buscarPorDataFabricacao(@PathVariable String dataInicio, @PathVariable String dataFim){
        //return repository.findByDataFabricacaoBetween();
        return new ArrayList<>();
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto,
                             @PathVariable int id){
        produto.setCodigo(id);
        return repository.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }
}
