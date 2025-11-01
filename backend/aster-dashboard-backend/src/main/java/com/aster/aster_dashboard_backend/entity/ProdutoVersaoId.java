package com.aster.aster_dashboard_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoVersaoId implements Serializable {

    @Column(name = "numero_versao", length = 10, nullable = false)
    private String numeroVersao;

    @Column(name = "produto_id", nullable = false)
    private Integer produtoId;

   @Override
    public String toString() {
        return "ProdutoVersaoId{" +
                "numeroVersao='" + numeroVersao + '\'' +
                ", produtoId=" + produtoId +
                '}';
}
