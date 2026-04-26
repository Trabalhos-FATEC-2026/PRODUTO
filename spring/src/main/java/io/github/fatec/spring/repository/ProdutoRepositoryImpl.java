package io.github.fatec.spring.repository;

import io.github.fatec.entity.Produto;
import io.github.fatec.repository.ProdutoRepository;
import io.github.fatec.spring.repository.adapter.ProdutoRepositoryAdapter;
import io.github.fatec.spring.repository.mongo.ProdutoRepositoryWithMongoDB;
import io.github.fatec.spring.repository.orm.ProdutoOrmMongo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoRepositoryWithMongoDB repository;
    private final ProdutoRepositoryAdapter adapter; 

    public ProdutoRepositoryImpl(ProdutoRepositoryWithMongoDB repository, 
                                ProdutoRepositoryAdapter adapter) {  
        this.repository = repository;
        this.adapter = adapter; 
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoOrmMongo orm = adapter.toOrm(produto);  
        ProdutoOrmMongo saved = repository.save(orm);
        return adapter.toDomain(saved); 
    }

    @Override
    public List<Produto> listarTodos() {
        return repository.findAll().stream()
                .map(adapter::toDomain) 
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarPorId(String id) {
        return repository.findById(id)
                .map(adapter::toDomain);  
    }


    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}