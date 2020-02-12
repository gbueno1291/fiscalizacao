CREATE TABLE IF NOT EXISTS emitente (
    id INT AUTO_INCREMENT,
    razao_social VARCHAR(70) NOT NULL,
    nome_fantasia VARCHAR(14) NOT NULL,
    cnpj VARCHAR(20) NOT NULL,
    logo VARCHAR(100) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    email VARCHAR(40) NOT NULL,
    site VARCHAR(40) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(10),
    bairro_id INT NOT NULL,
    PRIMARY KEY(id)
)  ENGINE=INNODB;