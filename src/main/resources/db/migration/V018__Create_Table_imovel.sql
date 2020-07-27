CREATE TABLE IF NOT EXISTS imovel (
    id INT AUTO_INCREMENT,
    cadastro INT NOT NULL,
    contribuinteid int NOT NULL,
    setor INT NOT NULL,
    quadra INT NOT NULL,
    lote VARCHAR(8) NOT NULL,
    valorvenalterreno DECIMAL(8,2) NOT NULL,
    valorvenaledificacao DECIMAL(8,2) NOT NULL,
    valorvenalimovel DECIMAL(8,2) NOT NULL,
    logradouroid INT  NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    latitude VARCHAR(20),
    longitude VARCHAR(20),
    PRIMARY KEY(id),
    CONSTRAINT fk_contribuinte_imovel FOREIGN KEY (contribuinteid) REFERENCES contribuinte(id),
    CONSTRAINT fk_logradouro_imovel FOREIGN KEY (logradouroid) REFERENCES logradouros(id)
)  ENGINE=INNODB;
