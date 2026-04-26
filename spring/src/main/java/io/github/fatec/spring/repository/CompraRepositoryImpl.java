package io.github.fatec.spring.repository;

import io.github.fatec.entity.Compra;
import io.github.fatec.repository.CompraRepository;
import io.github.fatec.spring.repository.adapter.CompraRepositoryAdapter;
import io.github.fatec.spring.repository.mongo.CompraRepositoryWithMongoDB;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompraRepositoryImpl implements CompraRepository {

    private final CompraRepositoryWithMongoDB repository;
    private final CompraRepositoryAdapter adapter;

    public CompraRepositoryImpl(CompraRepositoryWithMongoDB repository,
                                CompraRepositoryAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public Compra salvar(Compra compra) {
        var orm = adapter.toOrm(compra);
        var saved = repository.save(orm);
        return adapter.toDomain(saved);
    }

    @Override
    public List<Compra> buscarPorClienteId(String clienteId) {
        return repository.findByClienteId(clienteId)
                .stream()
                .map(adapter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Compra> listarTodas() {
        return repository.findAll()
                .stream()
                .map(adapter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Compra> buscarPorId(String id) {
        return repository.findById(id)
                .map(adapter::toDomain);
    }

    @Override
    public void deletarCompra(String id) {
        repository.deleteById(id);
    }
}