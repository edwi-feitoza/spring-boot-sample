ALTER TABLE PEDIDO ADD FOREIGN KEY (cliente_id) REFERENCES CLIENTE (id);
ALTER TABLE PRODUTO ADD FOREIGN KEY (categoria_id) REFERENCES CATEGORIA (id);
ALTER TABLE PEDIDO_ITEM ADD FOREIGN KEY (pedido_id) REFERENCES PEDIDO (id);
ALTER TABLE PEDIDO_ITEM ADD FOREIGN KEY (produto_id) REFERENCES PRODUTO (id);