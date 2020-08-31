CREATE TABLE IF NOT EXISTS pessoa (
    id INT AUTO_INCREMENT,
    nome_razao_social VARCHAR(100),
    rg_ie VARCHAR(15),
    cpf_cnpj VARCHAR (20),
    logradouro VARCHAR(80),
    numero VARCHAR(10),
    complemento VARCHAR(50),
    cep VARCHAR(15),
    bairro VARCHAR(75),
    cidade VARCHAR(45),
    telefone VARCHAR(20),
    email VARCHAR(60),
    telefone_recado VARCHAR(20),
    responsavel_recado VARCHAR(50),
    PRIMARY KEY(id)
)  ENGINE=INNODB;



