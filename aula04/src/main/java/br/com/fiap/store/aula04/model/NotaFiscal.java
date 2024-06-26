package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="aula4_nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue
    @Column(name="cd_nota_fiscal")
    private Long codigo;

    @Column(name="vl_nota_fiscal", nullable = false, scale = 2, precision = 9)
    private BigDecimal valor;

    @Column(name="dt_nota_fiscal")
    private LocalDateTime data;

    //Relacionamento 1:1
    @OneToOne
    @JoinColumn(name = "cd_pedido", nullable = false)
    private Pedido pedido;

}
