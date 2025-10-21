-- v2: migrations para add a coluna de img url na tabela de persons

ALTER TABLE tb_person
ADD COLUMN img_url VARCHAR(255);