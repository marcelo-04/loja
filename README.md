# loja
Projeto Alura 
### Criação do projeto maven
* criado uma aplicação Maven e adicionado o Hibernate como dependência.
### Configurações e EntityManager
* Adicionamos também o tipo de transação, transaction-type, que é "RESOURCE_LOCAL", no caso de gerenciarmos a transação, ou JTA, se tivermos usando algum Java EE, e o servidor se encarregará de cuidar do controle transacional. 
* Dentro da tag persistence-unit, temos properties e as propriedades da JPA: driver do banco de dados; URL; usuário; e senha do banco de dados. Como implementação do Hibernate, temos o dialeto.


