connect easyprocess/easyprocess;

-- CRIAR TABELA TIPO_PROCESSO
CREATE TABLE TIPO_PROCESSO (
ID NUMBER(10) PRIMARY KEY NOT NULL ,
nome VARCHAR(100) NOT NULL
);

-- CRIAR SEQUENCE TIPO_PROCESSO ID
CREATE SEQUENCE tproc_seq INCREMENT BY 1 START WITH 1;

-- CRIAR TRIGGER TIPO_PROCESSO
CREATE OR REPLACE TRIGGER tproc_tri
  BEFORE INSERT ON tipo_processo
  FOR EACH ROW
BEGIN
  :new.id := tproc_seq.nextval;
END;
/

-- CRIAR TABELA PROCESSO
CREATE TABLE PROCESSO (
id NUMBER(10) PRIMARY KEY NOT NULL ,
numero VARCHAR(100) NOT NULL,
data_entrada DATE NOT NULL,
valor_recurso NUMBER(19,4) NOT NULL,
objetivo VARCHAR(255),
CONSTRAINT numero_unique UNIQUE (numero)
);

-- ADICIONAR CHAVE ESTRANGEIRA
ALTER TABLE PROCESSO
ADD tipo_processo_id number(10) NOT NULL CONSTRAINT tipo_processo_processo_fk
  REFERENCES tipo_processo(id);

-- CRIAR SEQUENCE PROCESSO
CREATE SEQUENCE proc_seq INCREMENT BY 1 START WITH 1;

-- CRIAR TRIGGER PROCESSO
CREATE OR REPLACE TRIGGER proc_tri
  BEFORE INSERT ON processo
  FOR EACH ROW
BEGIN
  :new.id := proc_seq.nextval;
END;
/

COMMIT;

exit;