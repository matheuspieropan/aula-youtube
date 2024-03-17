CREATE OR REPLACE FUNCTION populaDB()
RETURNS VOID AS $$
DECLARE
cont int := 1;
BEGIN
FOR cont IN 1.. 100000 LOOP
		INSERT INTO empresa (id, nome, data_criacao)
		VALUES (contador,CONCAT('Empresa ', cont), now())
END;
$$ LANGUAGE plpgsql;


CREATE TABLE IF NOT EXISTS empresa (id INT PRIMARY KEY, razao_social nome varchar,data_criacao date);