-----------------------------------------------------------------------
-- Acessar o Banco de Dados
-----------------------------------------------------------------------
use Vendas_INFOM262
go

-------------------------------------------------------------------------
-- CRUD - CREATE - READ - UPDATE - DELETE
-- Read - SELECT
-------------------------------------------------------------------------

-------------------------------------------------------------------------
-- 1) Consultar todas as pessoas que são clientes
-- Objetivo: juntar dados das tabelas Pessoas com Clientes
-------------------------------------------------------------------------
-- where
select P.idPessoa as Cod_Cliente, P.nome as Cliente, P.cpf as CPF, C.renda as Renda
from Pessoas as P, Clientes as C
where P.idPessoa = C.pessoaId
go

-- INNER JOIN
select P.idPessoa as Cod_Cliente, P.nome as Cliente, P.cpf as CPF, C.renda as Renda
from Pessoas as P	INNER JOIN	 Clientes as C
on P.idPessoa = C.pessoaId
go

-------------------------------------------------------------------------
-- 2) Consultar todas as pessoas que são vendedores
-- Objetivo: juntar dados das tabelas Pessoas com Vendedores
-------------------------------------------------------------------------
-- where
select P.idPessoa as Cod_Vendedor, P.nome as Vendedor, P.cpf as CPF, V.salario as SALARIO
from Pessoas as P, Vendedores as V
where P.idPessoa = V.pessoaId
go

-- INNER JOIN
select P.idPessoa as Cod_Vendedor, P.nome as Vendedor, P.cpf as CPF, V.salario as SALARIO
from Pessoas as P	INNER JOIN	 Vendedores as V
on P.idPessoa = V.pessoaId
go

-------------------------------------------------------------------------
-- 3) Consultar todas os Clientes que fizeram pedidos
-- Saída de dados: id, nome e a renda do cliente; id, data status
-- dos Pedidos feitos pelos clientes
-- Objetivo: juntar dados das tabelas Pessoas com Clientes e com
-- Pedidos
-------------------------------------------------------------------------
-- where
select	P.idPessoa Cod_Cliente, P.nome Cliente, C.renda Renda,
		Pe.idPedido [No. Pedido], Pe.data Data_Pedido, Pe.status Sit_Pedido,
		case Pe.status
			when 1 then 'Em andamento'
			when 2 then 'Finalizado'
			when 3 then 'Cancelado'
			else 'Nao concluido'
		end Sit_Pedido
from Pessoas P, Clientes C, Pedidos Pe
where P.idPessoa = C.pessoaId and C.pessoaId = Pe.clienteId
order by P.nome
go

-- INNER JOIN
select	P.idPessoa Cod_Cliente, P.nome Cliente, C.renda Renda,
		Pe.idPedido [No. Pedido], Pe.data Data_Pedido, Pe.status Sit_Pedido,
		case Pe.status
			when 1 then 'Em andamento'
			when 2 then 'Finalizado'
			when 3 then 'Cancelado'
			else 'Nao concluido'
		end Sit_Pedido
from Pessoas P INNER JOIN Clientes C
on P.idPessoa = C.pessoaId INNER JOIN Pedidos Pe
on C.pessoaId = Pe.clienteId
order by P.nome
go 

-------------------------------------------------------------------------
-- 4) Consultar todas os Clientes que fizeram pedidos no ano de 2025
-- Saída de dados: id, nome e a renda do cliente; id, data status
-- dos Pedidos feitos pelos clientes
-- Objetivo: juntar dados das tabelas Pessoas com Clientes e com
-- Pedidos
-------------------------------------------------------------------------
-- where
select	P.idPessoa Cod_Cliente, P.nome Cliente, C.renda Renda,
		Pe.idPedido [No. Pedido], Pe.data Data_Pedido, Pe.status Sit_Pedido,
		case Pe.status
			when 1 then 'Em andamento'
			when 2 then 'Finalizado'
			when 3 then 'Cancelado'
			else 'Nao concluido'
		end Sit_Pedido
from Pessoas P, Clientes C, Pedidos Pe
where P.idPessoa = C.pessoaId and C.pessoaId = Pe.clienteId
and YEAR(Pe.data) = 2025
order by P.nome
go

-- INNER JOIN
select	P.idPessoa Cod_Cliente, P.nome Cliente, C.renda Renda,
		Pe.idPedido [No. Pedido], Pe.data Data_Pedido, Pe.status Sit_Pedido,
		case Pe.status
			when 1 then 'Em andamento'
			when 2 then 'Finalizado'
			when 3 then 'Cancelado'
			else 'Nao concluido'
		end Sit_Pedido
from Pessoas P INNER JOIN Clientes C
on P.idPessoa = C.pessoaId INNER JOIN Pedidos Pe
on C.pessoaId = Pe.clienteId
where YEAR(Pe.data) = 2025
order by P.nome
go 

-------------------------------------------------------------------------
-- 5) Consultar todas os Clientes que fizeram pedidose quais produtos
-- compraram em cada pedido
-- Saída de dados: id, nome e a renda do cliente; id, data status
-- dos Pedidos feitos pelos clientes; id descricao, qtd comprada e
-- o valor pago de cada produto em cada pedido
-- Objetivo: juntar dados das tabelas Pessoas com Clientes, com
-- Pedidos, com Itens de Pedidos e Produtos
-------------------------------------------------------------------------
-- where
select	P.idPessoa Cod_Cliente, P.nome Cliente, C.renda Renda,
		Pe.idPedido [No. Pedido], Pe.data Data,
		Pr.idProduto Cod_Produto, Pr.descricao Produto, IP.qtd Qtd_Vendida,
		IP.valor Preco_Pago, (IP.qtd * IP.valor) Total_Item, Pe.status Sit_Pedido
from Pessoas P, Clientes C, Pedidos Pe, Itens_Pedidos IP, Produtos Pr
where P.idPessoa = C.pessoaId and C.pessoaId = Pe.clienteId
and Pe.idPedido = IP.pedidoId and IP.produtoId = Pr.idProduto
order by P.nome
go

-- INNER JOIN
select	P.idPessoa Cod_Cliente, P.nome Cliente, C.renda Renda,
		Pe.idPedido [No. Pedido], Pe.data Data,
		Pr.idProduto Cod_Produto, Pr.descricao Produto, IP.qtd Qtd_Vendida,
		IP.valor Preco_Pago, (IP.qtd * IP.valor) Total_Item, Pe.status Sit_Pedido
from Pessoas P inner join Clientes C 
on P.idPessoa = C.pessoaId inner join Pedidos Pe
on C.pessoaId = Pe.clienteId inner join Itens_Pedidos IP
on Pe.idPedido = IP.pedidoId inner join Produtos Pr
on IP.produtoId = Pr.idProduto
order by P.nome
go

-------------------------------------------------------------------------
-- 6) Consultar todas as Pessoas que são ou não clientes
-------------------------------------------------------------------------
select	P.idPessoa Cod_Cliente, P.nome Cliente, P.cpf CPF,
		C.renda REnda, C.credito Credito
from	Pessoas P left join Clientes C
on		P.idPessoa = C.pessoaId
go

-------------------------------------------------------------------------
-- 6) Consultar todas as Pessoas que são ou não Vendedores
-------------------------------------------------------------------------
select	P.idPessoa Cod_Vendedor, P.nome Vendedor, P.cpf CPF,
		V.salario Salario
from	Pessoas P left join Vendedores V
on		P.idPessoa = V.pessoaId
go
