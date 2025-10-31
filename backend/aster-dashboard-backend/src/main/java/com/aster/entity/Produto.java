package com.aster.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Categorias dos status
public enum Status{
}

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="produto")
public class Produto {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="categoria")
    private String categoria;

    @Column(name="nome")
    private String nome;

    // Descrição breve
    @Column(name="descricao")
    private String descricao;

    @Column(name="status")
    private Status status;

    @Column(name="icone")
    private File icone;

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", status='" + status + '\'' +
                ", descrição breve='" + descricao + '\'' +
                '}';
    }
}
