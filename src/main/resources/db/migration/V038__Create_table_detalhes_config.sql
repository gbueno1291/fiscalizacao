CREATE TABLE detalhes_config(
id INT AUTO_INCREMENT NOT NULL,
config_id int NOT NULL,
chave VARCHAR(30) NOT NULL,
valor DECIMAL(8,2) NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_config_detalhes FOREIGN KEY (config_id)  REFERENCES config(id)
)ENGINE=INNODB;
