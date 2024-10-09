package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @Size(max = 80)
    @NotBlank(message = "Título é obrigatório")
    @Column(name = "ds_titulo", length = 80, nullable = false)
    private String titulo;

    @Size(max = 200, min = 10)
    @NotBlank
    @Column(name="ds_sinopse", length = 200, nullable = false)
    private String sinopse;

    @Min(0)
    @Column(name = "vl_livro", precision = 5)
    private Double preco;

    @Min(1)
    @Column(name = "nr_paginas", precision = 4)
    private Integer paginas;

    @Size(max = 60, min = 2)
    @Column(name="nr_isbn", length = 60)
    private String isbn;

    @Column(name="st_disponivel")
    private Boolean disponivel;

    @Past
    @Column(name="dt_publicacao")
    private LocalDate dataPublicacao;

    @Column(name="ds_genero")
    private Genero genero;

}
