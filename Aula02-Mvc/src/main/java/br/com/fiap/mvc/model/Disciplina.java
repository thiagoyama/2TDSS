package br.com.fiap.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    private Double media;
    private Double cp;
    private Double gs;
    private Double challenge;

    public Double calcularMediaSemestre(){
        return cp * 0.2 + gs * 0.6 + challenge * 0.2;
    }

    public Double calcularMediaAnual(){
        return calcularMediaSemestre() * 0.6 + media * 0.4;
    }

}
