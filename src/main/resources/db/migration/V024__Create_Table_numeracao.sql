CREATE TABLE IF NOT EXISTS numeracao (
id INT PRIMARY KEY AUTO_INCREMENT,
tiponotificacaoid INT NOT NULL,
numerodocumento INT NOT NULL,
CONSTRAINT fk_tiponotificacao_numero FOREIGN KEY (tiponotificacaoid) REFERENCES     tipo_notificacao (id)
)  ENGINE=INNODB;
