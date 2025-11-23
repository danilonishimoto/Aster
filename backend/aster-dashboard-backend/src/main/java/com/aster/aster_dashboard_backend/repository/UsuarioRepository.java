package com.aster.aster_dashboard_backend.repository;

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
}
