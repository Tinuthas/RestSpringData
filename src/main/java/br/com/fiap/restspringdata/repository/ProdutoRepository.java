package br.com.fiap.restspringdata.repository;

import br.com.fiap.restspringdata.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
