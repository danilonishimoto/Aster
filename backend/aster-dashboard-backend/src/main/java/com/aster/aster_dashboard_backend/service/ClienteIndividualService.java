package com.aster.aster_dashboard_backend.service;

import com.aster.aster_dashboard_backend.converter.ClienteIndividualConverter;
import com.aster.aster_dashboard_backend.dto.ClienteIndividualDto;
import com.aster.aster_dashboard_backend.entity.Individual;
import com.aster.aster_dashboard_backend.repository.ClienteIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteIndividualService {

    private final ClienteIndividualRepository repository;
    private ClienteIndividualConverter converter;

    @Autowired
    public ClienteIndividualService(ClienteIndividualRepository repository, ClienteIndividualConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public Page<ClienteIndividualDto> findAllPaginated(int page) {
        Page<Individual> clientesIndividuais = repository.findAll(PageRequest.of(page, 15));
        return clientesIndividuais.map(converter::toDto);
    }

    public ClienteIndividualDto findByDocumento(String documento) {

        Optional<Individual> result = repository.findById(documento);

        if (result.isEmpty()) {
            throw new RuntimeException("Não há nenhum registro com esse documento!");
        }

        return converter.toDto(result.get());
    }

    @Transactional
    public void create(ClienteIndividualDto dto) {

        if (dto.getDocumento() == null) {
            throw new IllegalArgumentException("Um documento deve ser fornecido!");
        }

        if (repository.existsById(dto.getDocumento())) {
            throw new IllegalArgumentException("Esse documento já existe!");
        }

        repository.save(converter.toEntity(dto));
    }


}
