package io.github.fatec.spring.controller.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record CompraResponse(
        String id,
        String clienteId,
        List<Item> itens,
        LocalDateTime dataCompra,
        Double total  
) {
    public record Item(
            String produtoId,
            Integer quantidade
    ) {}
}