# 📋 API Documentation

---

## 📦 Produtos

### Criar Produto

```
POST http://localhost:8080/produtos
```

```json
{
  "nome": "Monitor UltraWide 29 Pol",
  "preco": 1250.90
}
```

```json
{
  "nome": "Mouse Logitech",
  "preco": 150.90
}
```

---

### Listar Todos os Produtos

```
GET http://localhost:8080/produtos
```

> Retorna todos os produtos.

---

### Buscar Produto por ID

```
GET http://localhost:8080/produtos/ID_PRODUTO
```

> Retorna produto específico.

---

### Atualizar Produto

```
PUT http://localhost:8080/produtos/ID_PRODUTO
```

```json
{
  "nome": "Monitor UltraWide 300 Pol",
  "preco": 1250.90
}
```

> Atualiza o Produto.

---

### Deletar Produto

```
DELETE http://localhost:8080/produtos/ID_PRODUTO
```

> Deleta Produto.

---

## 🛒 Compras

### Criar Compra

```
POST http://localhost:8080/compras
```

```json
{
  "clienteId": "{{CLIENTE_ID}}",
  "itens": [
    {
      "produtoId": "{{PRODUTO_ID_1}}",
      "quantidade": 10
    },
    {
      "produtoId": "{{PRODUTO_ID_2}}",
      "quantidade": 2
    }
  ]
}
```

---

### Listar Todas as Compras

```
GET http://localhost:8080/compras
```

> Listar todas as compras.

---

### Buscar Compra por ID

```
GET http://localhost:8080/compras/COMPRA_ID
```

> Buscar compra por ID.

---

### Listar Compras por Cliente

```
GET http://localhost:8080/compras/cliente/CLIENTE_ID
```

> Listar compras por cliente.

---

### Atualizar Compra

```
PUT http://localhost:8080/compras/COMPRA_ID
```

```json
{
  "clienteId": "{{CLIENTE_ID}}",
  "itens": [
    {
      "produtoId": "{{PRODUTO_ID_1}}",
      "quantidade": 1
    }
  ]
}
```

> Atualizar compra.

---

### Deletar Compra

```
DELETE http://localhost:8080/compras/COMPRA_ID
```

> Deletar compra.
