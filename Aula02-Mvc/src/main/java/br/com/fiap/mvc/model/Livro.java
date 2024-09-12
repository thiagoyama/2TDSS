package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TB_LIVRO")
@Getter @Setter
public class Livro {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "ds_titulo", length = 80, nullable = false)
    private String titulo;
    @Column(name="ds_sinopse", length = 200, nullable = false)
    private String sinopse;
    @Column(name = "vl_livro", precision = 5)
    private Double preco;
    @Column(name = "nr_paginas", precision = 4)
    private Integer paginas;
    @Column(name="nr_isbn", length = 60)
    private String isbn;
    @Column(name="st_disponivel")
    private Boolean disponivel;
    @Column(name="dt_publicacao")
    private LocalDate dataPublicacao;

}
