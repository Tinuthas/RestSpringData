package br.com.fiap.restspringdata.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "produto")
    private int codigo;

    private String nome;

    private double preco;

    private boolean novo;

    private LocalDate dataFabricacao;

    public Produto() {
    }

    public Produto(String nome, double preco, boolean novo, LocalDate dataFabricacao) {
        this.nome = nome;
        this.preco = preco;
        this.novo = novo;
        this.dataFabricacao = dataFabricacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}
