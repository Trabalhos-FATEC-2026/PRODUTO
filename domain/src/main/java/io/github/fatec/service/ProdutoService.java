package io.github.fatec.service;


import io.github.fatec.entity.Compra;
import io.github.fatec.entity.ItemCompra;
import io.github.fatec.entity.Produto;
import io.github.fatec.repository.CompraRepository;
import io.github.fatec.repository.ProdutoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProdutoService {

    private final ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
}

    public Produto criarProduto(String nome, Double preco) {
        Produto produto = new Produto(
                UUID.randomUUID().toString(),
                nome,
                preco
        );
        return produtoRepository.salvar(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.listarTodos();
    }

    public Optional<Produto> buscarProduto(String id) {
        return produtoRepository.buscarPorId(id);
    }

    public Produto atualizarProduto(String id, String nome, Double preco) {
        Produto produto = produtoRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.atualizar(nome, preco);

        return produtoRepository.salvar(produto);
    }

    public void deletarProduto(String id) {
        produtoRepository.deletar(id);
    }


}