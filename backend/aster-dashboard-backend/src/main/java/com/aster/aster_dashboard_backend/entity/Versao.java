package com.aster.aster_dashboard_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="versao")
public class Versao{

    // Número da versão
    @Id
    @Column(name="numero")
    private String numero;

    // Arquivo instalador
    @Column(name="extensao")
    private String extensao;

    // Data de lançamento
    @Column(name="data")
    private String data;

    // Patch notes
    @Column(name="notes")
    private String notes;

    @Override
    public String toString() {
        return "Versao{" +
                "número da versão='" + numero + '\'' +
                ", data de lançamento='" + data + '\'' +
                ", arquivo instalador='" + extensao + '\'' +
                ", patch notes='" + notes + '\'' +
                '}';
    }
}
