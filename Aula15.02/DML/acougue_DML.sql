INSERT INTO db_cidade_das_carnes.tb_categoria(categoria)
VALUE
("CARNE VERMELHA"),
("FRANGO"),
("PEIXEI"),
("PORCO");

INSERT INTO tb_produto (nome_produto,preco_produto,peso_produto,origem_produto,fk_id_categoria)
VALUE
("COSTELA DE BOI", 52.00,1,"BRASIL",1),
("PICANHA", 75.00,900,"JAPÃO",1),
("COSTELA DE PORCO", 42.00,1,"BRASIL",4),
("COXA DE FRANGO", 32.00,1,"BRASIL",2),
("SALMÃO", 72.00,1,"NORUEGA",3),
("BACON", 36.00,7,"BRASIL",4),
("TILÁPIA", 42.00,1,"BRASIL",3);

SELECT * FROM tb_produto
WHERE preco_produto > 50.00;

SELECT * FROM tb_produto
WHERE preco_produto BETWEEN 3.00 AND 60.00;

SELECT * FROM tb_produto
WHERE nome_produto LIKE "C%";

SELECT *
FROM tb_produto
INNER JOIN tb_categoria ON tb_produto.fk_id_categoria = tb_categoria.id_categoria;

SELECT *
FROM tb_produto
INNER JOIN tb_categoria ON tb_produto.fk_id_categoria = tb_categoria.id_categoria
WHERE id_categoria IN (1);
