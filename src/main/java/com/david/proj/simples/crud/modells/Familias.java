package com.david.proj.simples.crud.modells;

import com.david.proj.simples.crud.Records.FamilasCadastroDto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Familias")
@Table(name = "Familias")
public class Familias {



    // Métodos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int quantidadeMembros;

    // Contructor FamilasDto dados
    public Familias(FamilasCadastroDto dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.quantidadeMembros = dados.quantidadeMembros();
    }

}
