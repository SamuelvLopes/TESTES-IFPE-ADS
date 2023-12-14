package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Vaga implements Serializable {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @Column(name= "descricao")
    private String descricao;

    @Column(name= "habilidades")
    private String habilidades;

    @Column(name= "beneficios")
    private String beneficios;

    @Column(name= "categoria")
    private String categoria;

    @Column(name= "temp_max")
    private Integer temp_max;
    @Column(name= "temp_min")
    private Integer temp_min;
    @Column(name= "imagem")
    private String imagem;
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;



}
