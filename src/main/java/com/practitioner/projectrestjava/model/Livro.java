package com.practitioner.projectrestjava.model;

import com.practitioner.projectrestjava.dto.LivroDto;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Entity
@Table(name = "livros")
public class Livro extends RepresentationModel<LivroDto> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String sobrenome;
    @Column(name = "data_lancamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    private Double preco;

    private String titulo;

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
