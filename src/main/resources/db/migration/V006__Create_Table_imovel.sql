CREATE TABLE IF NOT EXISTS imovel (
    id INT AUTO_INCREMENT,
    cadastro INT NOT NULL,
<<<<<<< HEAD
    contribuinteid int,
=======
    contribuinteid int NOT NULL,
>>>>>>> remodelagemDB
    setor INT NOT NULL,
    quadra INT NOT NULL,
    lote VARCHAR(8) NOT NULL,
    valorvenalterreno DECIMAL(8,2) NOT NULL,
    valorvenaledificacao DECIMAL(8,2) NOT NULL,
    valorvenalimovel DECIMAL(8,2) NOT NULL,
    cep VARCHAR(12) NOT NULL,
    logradouro VARCHAR(40)  NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    bairro  VARCHAR(40) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_contribuinte_imovel FOREIGN KEY (contribuinteid) REFERENCES contribuinte(id)
)  ENGINE=INNODB;