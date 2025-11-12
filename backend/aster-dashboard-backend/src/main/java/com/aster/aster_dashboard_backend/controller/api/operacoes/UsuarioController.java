package com.aster.aster_dashboard_backend.controller.api.operacoes;

import com.aster.aster_dashboard_backend.dto.PageResponseDto;
import com.aster.aster_dashboard_backend.dto.UsuarioDto;
import com.aster.aster_dashboard_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/operacoes/usuario")
public class UsuarioController {

    UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public PageResponseDto<UsuarioDto> findAllPaginated(@RequestParam int page) {
        Page<UsuarioDto> pagina = service.findAllPaginated(page);
        return new PageResponseDto<>(pagina);
    }
}
