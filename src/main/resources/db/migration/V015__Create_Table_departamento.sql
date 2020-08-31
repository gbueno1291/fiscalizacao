CREATE TABLE IF NOT EXISTS departamento (
    id INT  PRIMARY KEY AUTO_INCREMENT,
    emitente_id INT NOT NULL,
    nome VARCHAR(60),
    divisao VARCHAR(50),
    responsavel VARCHAR(30),
    logradouro VARCHAR(60),
    numero VARCHAR(20),
    complemento VARCHAR(10),
    bairro VARCHAR(80),
    cidade VARCHAR(60),
    CONSTRAINT fk_emitente_departamento FOREIGN KEY (emitente_id) REFERENCES emitente (id)
)  ENGINE=INNODB;
