CREATE TABLE IF NOT EXISTS fiscal (
    id INT AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    tipofiscal VARCHAR(20) NOT NULL,
    matricula INT NOT NULL,
    foto VARCHAR(20) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
   )  ENGINE=INNODB;