Desafio Backend

Neste desafio você deverá implementar uma API REST para um sistema simples de
contas a pagar. O sistema permitirá realizar o CRUD de uma conta a pagar, alterar a
situação dela quando for efetuado pagamento, obter informações sobre as contas
cadastradas no banco de dados, e importar um lote de contas de um arquivo CSV, conforme
descrito abaixo.
Requisitos Gerais
1. Utilizar a linguagem de programação Java, versão 17 ou superior.
2. Utilizar Spring Boot.
3. Utilizar o banco de dados PostgreSQL.
4. A aplicação deve ser executada em um container Docker.
5. Tanto a aplicação, banco de dados, quanto outros serviços necessários para
executar a aplicação, devem ser orquestrados utilizando Docker Compose.
6. O código do projeto deve ser hospedado no GitHub ou GitLab.
7. Utilizar mecanismo de autenticação.
8. Organizar o projeto com Domain Driven Design.
9. Utilizar o Flyway para criar a estrutura de banco de dados.
10. Utilizar JPA.
11. Todas as APIs de consulta devem ser paginadas.
Requisitos Específicos
1. Cadastrar a tabela no banco de dados para armazenar as contas a pagar. Deve
incluir no mínimo os seguintes campos: (Faça a tipagem conforme achar adequado)
a. id
b. data_vencimento
c. data_pagamento
d. valor
e. descricao
f. situacao
2. Implementar a entidade “Conta” na aplicação, de acordo com a tabela criada
anteriormente.
3. Implementar as seguintes APIs:
a. Cadastrar conta;
b. Atualizar conta;
c. Alterar a situação da conta;
d. Obter a lista de contas a pagar, com filtro de data de vencimento e descrição;
e. Obter conta filtrando o id;
f. Obter valor total pago por período.
4. Implementar mecanismo para importação de contas a pagar via arquivo csv.
a. O arquivo será consumido via API.
5. Implementar testes unitários.
