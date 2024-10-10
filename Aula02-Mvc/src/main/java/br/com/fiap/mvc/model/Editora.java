package br.com.fiap.mvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_EDITORA")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editora {

    @Id
    @GeneratedValue
    @Column(name="cd_editora")
    private Long id;

    @NotBlank @Size(max = 50)
    @Column(name = "nm_editora", nullable = false, length = 50)
    private String nome;

    @Column(name="nr_cnpj", nullable = false, length = 21)
    private String cnpj;

    @Column(name="ds_email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_endereco")
    private Endereco endereco;

}
