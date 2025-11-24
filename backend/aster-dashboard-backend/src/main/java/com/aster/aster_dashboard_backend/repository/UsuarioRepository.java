package com.aster.aster_dashboard_backend.repository;

import com.aster.aster_dashboard_backend.dto.UsuariosMensaisProdutoDto;
import com.aster.aster_dashboard_backend.dto.UsuariosProdutoDto;
import com.aster.aster_dashboard_backend.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    public Page<Usuario> findAll(Pageable pageable);

    @Query("""
        SELECT new com.aster.aster_dashboard_backend.dto.UsuariosProdutoDto(p.nome, COUNT(u.id.usuarioChaveUso))
        FROM Usa u
        LEFT JOIN Licenca l ON u.id.licencaId = l.id
        LEFT JOIN Produto p ON l.produto.id = p.id
        GROUP BY p.nome
    """)
    public List<UsuariosProdutoDto> findUsuariosProduto();

    @Query(value = """
        WITH meses_licenca AS (
            SELECT
                u.usuario_chave_uso,
                l.id AS licenca_id,
                l.tipo,
                l.data_registro,
                l.ativa,
                u.cliente_documento,
                l.produto_id,
        
                -- gera os meses de contabilização da licença
                generate_series(
                    date_trunc('month', l.data_registro),
                    CASE\s
                        WHEN l.tipo = 'Mensal' THEN date_trunc('month', l.data_registro)
                        WHEN l.tipo = 'Anual' THEN date_trunc('month', l.data_registro) + interval '11 month'
                        WHEN l.tipo = 'Vitalícia' THEN date_trunc('month', CURRENT_DATE)
                        ELSE NULL
                    END,
                    interval '1 month'
                ) AS mes
            FROM USA u
            JOIN LICENCA l ON l.id = u.licenca_id
            WHERE l.ativa = TRUE
        )
        
        SELECT
            pr.nome AS produto,
            m.mes::date AS data,
            COUNT(DISTINCT m.usuario_chave_uso) AS usuarios
        FROM meses_licenca m
        JOIN PRODUTO pr ON pr.id = m.produto_id
        WHERE pr.status = 'Comercializável'
        GROUP BY pr.nome, m.mes
        ORDER BY pr.nome, m.mes
    """, nativeQuery = true)
    public List<Object[]> findUsuariosMensaisProduto();
}
