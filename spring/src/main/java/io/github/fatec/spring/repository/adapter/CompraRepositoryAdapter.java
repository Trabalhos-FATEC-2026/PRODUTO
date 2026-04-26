package io.github.fatec.spring.repository.adapter;

import io.github.fatec.entity.Compra;
import io.github.fatec.entity.ItemCompra;
import io.github.fatec.spring.repository.orm.CompraOrmMongo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompraRepositoryAdapter {

    public CompraOrmMongo toOrm(Compra compra) {

        List<CompraOrmMongo.Item> itens = compra.getItens().stream()
                .map(i -> {
                    CompraOrmMongo.Item item = new CompraOrmMongo.Item();
                    item.produtoId = i.getProdutoId();
                    item.quantidade = i.getQuantidade();
                    return item;
                })
                .collect(Collectors.toList());

        return new CompraOrmMongo(
                compra.getId(),
                compra.getClienteId(),
                itens,
                compra.getDataCompra(),
                compra.getTotal()
        );
    }

    public Compra toDomain(CompraOrmMongo orm) {

        List<ItemCompra> itens = orm.getItens().stream()
                .map(i -> new ItemCompra(i.produtoId, i.quantidade))
                .collect(Collectors.toList());

        return new Compra(
                orm.getId(),
                orm.getClienteId(),
                itens,
                orm.getDataCompra(),
                orm.getTotal()
        );
    }
}