package com.aster.aster_dashboard_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public enum StatusProdutoCheck{
    EM_DESENVOLVIMENTO("Em desenvolvimento"),
    COMERCIALIZAVEL("Comercializável"),
    DESCONTINUADO("Descontinuado");

    private final String texto;

    StatusProdutoCheck(String texto){
      this.texto = texto;

    public String getTexto(){
        return texto;
    }
}

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="produto")
public class Produto{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusProdutoCheck status;

    @Column(length = 20)
    private String icone;

    @Column(name="descricao_breve", length = 150)
    private String descricaoBreve;

    @Column(length = 30, nullable = false)
    private String nome;

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", ícone='" + icone + '\'' +
                ", descrição breve notes='" + descricaoBreve + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
