package com.aster.aster_dashboard_backend.service;

import com.aster.aster_dashboard_backend.entity.ProdutoInicio;
import com.aster.aster_dashboard_backend.repository.ProdutoInicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoInicioService {

    private ProdutoInicioRepository repository;

    @Autowired
    public ProdutoInicioService(ProdutoInicioRepository produtoInicioRepository) {
        repository = produtoInicioRepository;
    }

    public List<ProdutoInicio> findAll() {
        return repository.findAll();
    }
}
