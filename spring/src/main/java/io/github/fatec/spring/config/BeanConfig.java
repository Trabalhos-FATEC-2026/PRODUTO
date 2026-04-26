package io.github.fatec.spring.config;

import io.github.fatec.repository.CompraRepository;
import io.github.fatec.repository.ProdutoRepository;
import io.github.fatec.service.CompraService;
import io.github.fatec.service.ProdutoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProdutoService produtoService(ProdutoRepository produtoRepository) {
        return new ProdutoService(produtoRepository);
    }

    @Bean
    public CompraService compraService(
            CompraRepository compraRepository,
            ProdutoRepository produtoRepository
    ) {
        return new CompraService(compraRepository, produtoRepository);
    }
}