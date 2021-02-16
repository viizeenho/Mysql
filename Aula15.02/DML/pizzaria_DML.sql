INSERT INTO db_pizzaria_legal.tb_categoria(categoria_pizza)
VALUE
('SALGADA'),
('DOCE'),
('VEGANA');

INSERT INTO tb_pizza(sabor_pizza,massa_pizza,preco_pizza,fk_id_categoria)
VALUE
("Bacon","Massa Fina",40.00,1),
("Chocolate","Massa Fina",35.00,2),
("Portuguesa","Massa Frita",45.00,1),
("Rome e Julieta","Massa Fina",50.00,2),
("Palmito","Massa Fina",35.00,3),
("Brigadeiro","Massa Grossa",29.00,2),
("Mussarela","Massa Fina",35.00,1),
("Rúcula","Massa Fina",26.00,3);

SELECT sabor_pizza, preco_pizza FROM tb_pizza
WHERE preco_pizza > 45;

SELECT sabor_pizza, preco_pizza FROM tb_pizza
WHERE preco_pizza between 29.00 and 60.00;

SELECT sabor_pizza, preco_pizza FROM tb_pizza
WHERE sabor_pizza LIKE "%C%";

SELECT *
FROM tb_categoria
INNER JOIN tb_pizza
ON tb_categoria.id_categoria = tb_pizza.fk_id_categoria;

SELECT *
FROM tb_categoria
INNER JOIN tb_pizza
ON tb_categoria.id_categoria = tb_pizza.fk_id_categoria
WHERE tb_categoria.id_categoria IN (2)