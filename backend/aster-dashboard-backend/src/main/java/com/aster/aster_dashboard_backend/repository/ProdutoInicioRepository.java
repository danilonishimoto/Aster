package com.aster.aster_dashboard_backend.repository;

import com.aster.aster_dashboard_backend.entity.ProdutoInicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoInicioRepository extends JpaRepository<ProdutoInicio,Integer> {

    @Query("""
        SELECT new com.aster.aster_dashboard_backend.entity.ProdutoInicio(p.id, AVG(f.avaliacao), (
                SELECT pv2.id.numeroVersao
                FROM ProdutoVersao pv2
                WHERE pv2.dataLancamento = (
                        SELECT MAX(pv1.dataLancamento)
                        FROM ProdutoVersao pv1
                )
                )
        )
        FROM Produto p
        LEFT JOIN ProdutoVersao pv3 ON pv3.produtoId = p.id
        LEFT JOIN Devolutiva d ON d.produtoId = p.id
        LEFT JOIN Feedback f ON f.devolutivaId = d.id
        """)
    public List<ProdutoInicio> findAll();
}
