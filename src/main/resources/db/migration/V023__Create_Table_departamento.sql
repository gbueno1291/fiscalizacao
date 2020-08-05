CREATE TABLE IF NOT EXISTS departamento (
    id INT  PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    divisao VARCHAR(50) NOT NULL,
    responsavel VARCHAR(30) NOT NULL,
    logradouroid INT  NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    latitude VARCHAR(20),
    longitude VARCHAR(20),
    CONSTRAINT fk_logradouro_departamento FOREIGN KEY (logradouroid) REFERENCES logradouros(id)
)  ENGINE=INNODB;
