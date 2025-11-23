package com.aster.aster_dashboard_backend.repository;

import com.aster.aster_dashboard_backend.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    public Page<Usuario> findAll(Pageable pageable);
}
