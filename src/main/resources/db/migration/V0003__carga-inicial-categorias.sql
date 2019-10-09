INSERT INTO CATEGORIA (categoria) VALUES('HARDWARE');
INSERT INTO CATEGORIA (categoria) VALUES('SMARTPHONES');
INSERT INTO CATEGORIA (categoria) VALUES('PERIFÉRICOS');
INSERT INTO CATEGORIA (categoria) VALUES('COMPUTADORES');
INSERT INTO CATEGORIA (categoria) VALUES('PLACAS DE VÍDEO');
INSERT INTO CATEGORIA (categoria) VALUES('MONITORES');
INSERT INTO CATEGORIA (categoria) VALUES('GAMES');
INSERT INTO CATEGORIA (categoria) VALUES('AUTOMOTIVO');
INSERT INTO CATEGORIA (categoria) VALUES('PRESENTES');
INSERT INTO CATEGORIA (categoria) VALUES('BRINQUEDOS');


INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'HARDWARE', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'HARDWARE', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'SMARTPHONES', 'Loren Ipsum', 180.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'SMARTPHONES', 'Loren Ipsum', 180.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'COMPUTADORES', 'Loren Ipsum', 190.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'COMPUTADORES', 'Loren Ipsum', 190.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'MONITORES', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'MONITORES', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'GAMES', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'GAMES', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'AUTOMOTIVO', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'AUTOMOTIVO', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'PERIFÉRICOS', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');
INSERT INTO PRODUTO (categoria_id, produto, preco, quantidade, descricao, foto) VALUES (SELECT ID FROM CATEGORIA WHERE CATEGORIA = 'PERIFÉRICOS', 'Loren Ipsum', 150.99, 300, 'Loren Ipsum Creative Labs', 'https://images5.kabum.com.br/produtos/fotos/84505/84505_index_gg.jpg');