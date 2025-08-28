package com.segurancaa.kelly.Infrascture.Entites;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;


@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
@Table(name="/cadastros")
@Entity
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private Integer idade;


}
