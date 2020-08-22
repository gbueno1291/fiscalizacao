CREATE TABLE logradouros(
id INT AUTO_INCREMENT NOT NULL,
bairroID INT NOT NULL,
tipologradouro INT NOT NULL,
nome VARCHAR(70) NOT NULL,
cep VARCHAR(12) NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_bairro_rua FOREIGN KEY (bairroID) REFERENCES bairros(id),
CONSTRAINT fk_tipo_logradouro FOREIGN KEY(tipologradouro) REFERENCES tipo_logradouro(id)
)ENGINE=INNODB;
