package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name= "rua")
    private String rua;
    @Column(name= "numero")
    private Integer numero;
    @Column(name= "complemento")
    private String complemento;
    @Column(name= "bairro")
    private String bairro;
    @Column(name= "cep")
    private Integer cep;
    @Column(name= "estado")
    private String estado;
    @Column(name= "cidade")
    private String cidade;
    @Column(name= "pais")
    private String pais;


}
