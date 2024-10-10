package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_ENDERECO")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue
    @Column(name="cd_endereco")
    private Long id;

    @Column(name = "ds_logradouro", nullable = false, length = 150)
    private String logradouro;

    @Column(name = "nr_cep", length = 8)
    private String cep;

    @Column(name = "nr_endereco", length = 10)
    private String numero;

}
