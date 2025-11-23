package com.aster.aster_dashboard_backend.repository;

import com.aster.aster_dashboard_backend.entity.Adquire;
import com.aster.aster_dashboard_backend.entity.id.AdquireId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdquireRepository extends JpaRepository<Adquire, AdquireId> {
    
}
