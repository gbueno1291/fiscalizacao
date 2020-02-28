CREATE TABLE IF NOT EXISTS contribuinte (
    id INT AUTO_INCREMENT,
    cadastro INT NOT NULL,
    nome VARCHAR(60) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    celular VARCHAR(14) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    email VARCHAR(40) NOT NULL,
    cep VARCHAR(12) NOT NULL,
    logradouro VARCHAR(40)  NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    bairro  VARCHAR(40) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    PRIMARY KEY(id)
)  ENGINE=INNODB;