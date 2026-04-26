package io.github.fatec.spring.repository.adapter;

import io.github.fatec.entity.Produto;
import io.github.fatec.spring.repository.orm.ProdutoOrmMongo;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepositoryAdapter {

    public ProdutoOrmMongo toOrm(Produto produto) {
        return new ProdutoOrmMongo(
                produto.getId(),
                produto.getNome(),
                produto.getPreco()
        );
    }

    public Produto toDomain(ProdutoOrmMongo orm) {
        return new Produto(
                orm.getId(),
                orm.getNome(),
                orm.getPreco()
        );
    }
}