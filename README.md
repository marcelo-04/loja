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
### Organizando o código com classe ProdutoDAO e a classe JPAUtil
* O objetivo da classe JPAUtil é isolar a criação do EntityManager e esconder também o EntityManagerFactory().
* A única coisa que precisamos passar é o EntityManager, por isso, precisamos criar um. Faremos, EntityManager em = JPAUtil.getEntityManager();. 
* A criação e a transação do EntityManager, em uma aplicação real, um projeto ou aplicação web, não teria esses elementos. 
* Provavelmente, usaríamos algum framework, como o Spring, que tem injeção de dependências. 
* Logo, receberíamos injetada a classe DAO, que também teria a injeção do EntityManager automaticamente. 
* Portanto, não teríamos nenhuma das linhas anteriores, com exceção da dao.cadastrar(celular);. 
* Teríamos apenas um atributo da classe DAO que seria injetado. Os frameworks facilitariam o processo. 
* Mas, como não estamos usando nenhum framework, e aprendendo JPA puro, precisaremos das linhas apresentadas anteriormente para criar.
### Tipos de atributos
* podemos mapear sem a necessidade de configurações adicionais via anotações da JPA!
* Os tipos primitivos, atributos do tipo String e algumas classes do Java, como LocalDate e BigDecimal.
* Esses tipos podem ser mapeados automaticamente, sem a necessidade de configurações adicionais.
### Cardinalidade do relacionamento
* Utilizamos a anotação @ManyToOne para indicar a cardinalidade de um relacionamento. 
* Qual a cardinalidade padrão assumida pela JPA, no caso de um atributo que representa um relacionamento não possuir anotações?
* É obrigatório adicionar alguma anotação de cardinalidade em todos os atributos que representam relacionamentos.
* A JPA não assume uma cardinalidade padrão quando não anotamos um atributo.
### Ciclo de vida de uma entidade
* Como funciona o ciclo de vida de entidade JPA.
* As transições de estados de uma entidade ao ser persistida;
* As  transições de estados de uma entidade ao ser atualizada;
* As transições de estados de uma entidade ao ser removida.
### Nessa aula, aprendemos:
* A mapear novas entidades na aplicação conforme a modelagem do banco de dados;
* A mapear um relacionamento com cardinalidade muitos-para-muitos;
* A mapear um relacionamento bidirecional;
* Como persistir entidades que possuam relacionamentos bidirecionais.
### Parâmetro cascade
* Propagar as operações realizadas em uma entidade em seu relacionamento.
* O cascade cria um efeito cascata nas operações realizadas em uma entidade.
