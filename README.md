# loja
Projeto Alura 
### Criação do projeto maven
* criado uma aplicação Maven e adicionado o Hibernate como dependência.
### Configurações e EntityManager
* Adicionamos também o tipo de transação, transaction-type, que é "RESOURCE_LOCAL", no caso de gerenciarmos a transação, ou JTA, se tivermos usando algum Java EE, e o servidor se encarregará de cuidar do controle transacional. 
* Dentro da tag persistence-unit, temos properties e as propriedades da JPA: driver do banco de dados; URL; usuário; e senha do banco de dados. Como implementação do Hibernate, temos o dialeto.
### Mapeando a entidade
* mapeamos quais classes vão representar tabelas no banco de dados.
* Entidades da JPA. É uma classe que faz o mapeamento de uma tabela do banco de dados.
* Uma entidade JPA funciona como um espelho de uma tabela no banco de dados
### Persistindo uma entidade
* Na JPA, tem algo parecido, que não é bem uma conexão, mas uma interface que faz a ligação do Java com o banco de dados, que é uma interface chamada EntityManager. Essa classe funciona como se fosse o gerente, o "manager" das entidades, ou ainda, o gestor das entidades.
* Toda vez que desejarmos acessar o banco de dados, seja para salvar, excluir, atualizar, carregar, fazer um select, ou qualquer outra operação que quisermos fazer no banco de dados com a JPA, nós utilizaremos a interface EntityManager.
* Finalizamos o nosso código para inserir e integrar de fato com o banco de dados, falar para JPA ir lá, pegar o objeto e salvar no banco de dados. A parte de iniciar transação, criar EntityManager é um pouco complexa e podemos melhorar, extrair para classes, mas isso será assunto para depois. 



