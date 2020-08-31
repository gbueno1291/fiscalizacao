CREATE TABLE config(
id INT AUTO_INCREMENT NOT NULL,
emitente_id INT NOT NULL,
descricao_config VARCHAR(50) NOT NULL,
ano_vigente VARCHAR(4) NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_emitente_config FOREIGN KEY (emitente_id) REFERENCES emitente(id)
)ENGINE=INNODB;
