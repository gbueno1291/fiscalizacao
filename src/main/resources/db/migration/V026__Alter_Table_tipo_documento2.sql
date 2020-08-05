ALTER TABLE tipo_notificacao ADD CONSTRAINT fk_documento_departamento FOREIGN KEY (departamentoid) REFERENCES departamento (id);
