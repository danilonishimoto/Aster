package com.aster.aster_dashboard_backend.controller.api;

import com.aster.aster_dashboard_backend.entity.ProdutoInicio;
import com.aster.aster_dashboard_backend.service.ProdutoInicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerInicio {

    private ProdutoInicioService service;

    @Autowired
    public ControllerInicio(ProdutoInicioService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoInicio> findAll() {
        return service.findAll();
    }
}
