INSERT INTO db_farmacia_do_bem.tb_categoria(categoria_farmacia)
VALUE
("REMEDIOS"),
("COSMETICOS"),
("HIGIENE PESSOAL");

INSERT INTO tb_produto(nome_produto,preco_produto,descricao_produto,fk_id_categoria)
VALUES
("Agua Micellar",30.00,"Limpeza de pele",2),
("DorFlex",6.00,"Alivio para dores no corpo",1),
("Sabonete Liquido",15.00,"Sabonete Neutro",3),
("Protetor Solar",45.00,"FPS 60",2),
("Escova de dente",10.00,"Oral-B",3),
("Gel de Limpeza",60.00,"Vichy limpeza intensa",2),
("Esfoliante",53.00,"Neutrogena",2),
("Amoxilina",35.00,"Anti inFlamatório",1);

SELECT * FROM tb_produto
WHERE preco_produto > 50.00;

SELECT * FROM tb_produto
WHERE preco_produto BETWEEN 3.00 AND 60.00;

SELECT * FROM tb_produto
WHERE nome_produto LIKE "%a%";

SELECT *
FROM tb_categoria INNER JOIN tb_produto ON tb_categoria.id_categoria = tb_produto.id_produto;

SELECT *
FROM tb_categoria
INNER JOIN tb_produto
ON tb_categoria.id_categoria = tb_produto.fk_id_categoria
WHERE tb_categoria.id_categoria IN (2);

SELECT * FROM tb_produto





