package io.github.fatec.entity;

import java.time.LocalDateTime;
import java.util.List;


public class Compra {

    private String id;
    private String clienteId;
    private List<ItemCompra> itens;
    private LocalDateTime dataCompra;
    private Double total;

    public Compra(String id, String clienteId, List<ItemCompra> itens, LocalDateTime dataCompra, Double total) {
        this.id = id;
        this.clienteId = clienteId;
        this.itens = itens;
        this.dataCompra = dataCompra;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Double getTotal() {
        return total;
    }
}