package br.com.fiap.restspringdata.repository;

import br.com.fiap.restspringdata.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    List<Produto> findByNome(String prod);

    List<Produto> findByNovoOrderByNomeDesc(boolean novo);

    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);

    List<Produto> findByNomeAndNovo(String nome, boolean novo);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByNovo(boolean novo);

    List<Produto> findByDataFabricacaoBetween(LocalDate i, LocalDate f);

}
