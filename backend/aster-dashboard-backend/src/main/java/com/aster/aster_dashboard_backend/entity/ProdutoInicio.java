package com.aster.aster_dashboard_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProdutoInicio {

    @Id
    private int id;

    private float mediaAvaliacoes;

    private String versaoAtual;

}
