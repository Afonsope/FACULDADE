-----------------------------------------------------------------
--CRIANDO O BANCO DE DADOS
-----------------------------------------------------------------

CREATE DATABASE VENDAS_INFOM262
GO

--ACESSAR O BANCO DE DADOS--
USE VENDAS_INFOM262
GO

-----------------------------------------------------------------
--CRIANDO AS TABELAS DE BANCO DE DADOS
-----------------------------------------------------------------

-----------------------------------------------------------------
-- TABELA PESSOAS
-----------------------------------------------------------------
CREATE TABLE PESSOAS
(
    IDPESSOA        INT             NOT NULL        PRIMARY KEY     IDENTITY,
    NOME            VARCHAR(50)     NOT NULL,
    CPF             VARCHAR(14)     NOT NULL        UNIQUE,
    STATUS          INT                 NULL        CHECK(STATUS = 1 OR STATUS = 2)
)
GO

-----------------------------------------------------------------
--TABELA CLIENTES
-----------------------------------------------------------------
CREATE TABLE CLIENTES
(
    PESSOAID        INT             NOT NULL        PRIMARY KEY     REFERENCES PESSOAS(IDPESSOA),
    RENDA           DECIMAL(10,2)   NOT NULL        CHECK(RENDA >= 700.00),
    CREDITO         DECIMAL(10,2)   NOT NULL        CHECK(CREDITO >= 100.00),
)
GO

-----------------------------------------------------------------
--TABELA VENDEDORES
-----------------------------------------------------------------
CREATE TABLE VENDEDORES
(
    PESSOAID        INT             NOT NULL        PRIMARY KEY     REFERENCES PESSOAS(IDPESSOA),
    SALARIO         DECIMAL(10,2)   NOT NULL        CHECK(SALARIO >= 1000.00)
)
GO

-----------------------------------------------------------------
--TABELA PEDIDOS
-----------------------------------------------------------------
CREATE TABLE PEDIDOS
(
    IDPEDIDO        INT             NOT NULL        PRIMARY KEY     IDENTITY,
    DATA            DATETIME        NOT NULL,
    VALOR           DECIMAL(10,2)       NULL,
    STATUS          INT                 NULL        CHECK(STATUS IN(1,2,3)),
    VENDEDORID      INT             NOT NULL,
    CLIENTEID       INT             NOT NULL,

    ---DEFINIÇÃO DAS CHAVES ESTRANGEIRAS
    FOREIGN KEY(VENDEDORID)         REFERENCES      VENDEDORES(PESSOAID),
    FOREIGN KEY(CLIENTEID)          REFERENCES      CLIENTES(PESSOAID)
)
GO

-----------------------------------------------------------------
--TABELA PRODUTOS
-----------------------------------------------------------------
CREATE TABLE PRODUTOS
(
    IDPRODUTO   INT             NOT NULL        PRIMARY KEY IDENTITY,
    DESCRICAO       VARCHAR(100)    NOT NULL,
    QTD             INT                 NULL        CHECK(QTD >= 0),
    VALOR           DECIMAL(10,2)       NULL        CHECK(VALOR > 0.00),
    STATUS          INT                 NULL        CHECK(STATUS IN(1,2))
)
GO

-----------------------------------------------------------------
--TABELA ITENS PEDIDOS
--TABELA N PARA N
-----------------------------------------------------------------
CREATE TABLE ITENS_PEDIDOS
(
    PEDIDOID        INT             NOT NULL,
    PRODUTOID       INT             NOT NULL,
    QTD             INT                 NULL        CHECK(QTD > 0),
    VALOR           DECIMAL(10,2)       NULL        CHECK(VALOR > 0.00),

    ---DEFINIÇÃO DAS CHAVES ESTRANGEIRAS
    FOREIGN KEY(PEDIDOID)           REFERENCES      PEDIDOS(IDPEDIDO),
    FOREIGN KEY(PRODUTOID)          REFERENCES      PRODUTOS(IDPRODUTO),
    PRIMARY KEY(PEDIDOID,PRODUTOID)
)
GO