CREATE TABLE IF NOT EXISTS contribuinte (
    id INT AUTO_INCREMENT,
    cadastro INT NOT NULL,
    nome VARCHAR(60) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    celular VARCHAR(14) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    email VARCHAR(40) NOT NULL,
    logradouroid INT  NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    latitude VARCHAR(20),
    longitude VARCHAR(20),
    PRIMARY KEY(id),
    CONSTRAINT fk_logradouro_contribuinte FOREIGN KEY (logradouroid) REFERENCES logradouros(id)
)  ENGINE=INNODB;
