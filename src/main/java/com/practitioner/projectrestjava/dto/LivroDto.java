package com.practitioner.projectrestjava.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

public class LivroDto extends RepresentationModel<LivroDto> {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String autor;
    private String sobrenome;
    private Date dataLancamento;
    private Double preco;
    private String titulo;

    public LivroDto() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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
