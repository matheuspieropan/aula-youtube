CREATE TABLE IF NOT EXISTS empresa (id INT PRIMARY KEY, nome varchar(20));

CREATE OR REPLACE FUNCTION populaDB()
RETURNS VOID AS '
DECLARE
    cont INT := 1;
    registros INT := 0;
BEGIN
    SELECT COUNT(*) INTO registros FROM empresa;
    IF registros = 0 THEN
        FOR cont IN 1..300000 LOOP
            INSERT INTO empresa (id, nome)
            VALUES (cont, CONCAT(''Empresa '', cont));
        END LOOP;
    END IF;
END;
'
LANGUAGE plpgsql;

SELECT populaDB();