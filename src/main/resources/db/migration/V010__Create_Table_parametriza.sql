CREATE TABLE parametriza(
id INT AUTO_INCREMENT NOT NULL,
valor_ufm DECIMAL(4,2) NOT NULL,
valor_terreno DECIMAL(4,2) NOT NULL,
preco_metro_quadrado DECIMAL(4,2) NOT NULL,
ano_vigente date NOT NULL,
PRIMARY KEY(id)
)ENGINE=INNODB;