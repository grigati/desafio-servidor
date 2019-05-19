É necessário inserir os tipos de usuário no banco de dados antes de executar chamadas à API. Para isso, faça:

```
INSERT INTO tb_roles VALUES(1, 'ROLE_USER');
INSERT INTO tb_roles VALUES(2, 'ROLE_ADMIN');
```

Para popular a tabela, use:

```
INSERT INTO `tb_email` VALUES (2,'emanuellyclaudiafernandaporto@yool.com.br'),(1,'giovannifilipedavidepaula@telefonica.com');

INSERT INTO `tb_telefone` VALUES (1,'8236164375','residencial'),(2,'82992954594','celular'),(3,'8338931962','residencial'),(4,'83983258869','celular');

INSERT INTO `tb_usuario` VALUES (1,'Cristo Redentor','58071340','João Pessoa','427','12345678910','Loteamento Cidade Redenção','Giovanni Paula','$2a$10$GakM8HM7uLTdVBBmQojiW.H2ROMrFVuAZtbP7ZER.jnCcqJ4COxZq','PB'),(2,'Senador Arnon de Melo','57315794','Arapiraca','298','79293996307','Rua Josefa Antônia do Nascimento','Emanuelly Claudia Fernanda Porto','$2a$10$aSbPAh6z6SBgAlup/Mv8Xed.MkMoaGAxAqeU.W1ZIZMO8BRK9STYS','AL');

INSERT INTO `tb_usuario_tb_email` VALUES (1,1),(2,2);
INSERT INTO `tb_usuario_tb_roles` VALUES (1,2),(2,1);
INSERT INTO `tb_usuario_tb_telefone` VALUES (1,1),(1,2),(2,3),(2,4);

```

Para rodar o projeto:

`mvn spring-boot:run`

Para acessar o sistema, use os seguintes dados:

- Usuário admin
  - CPF: 12345678910
  - senha: 123456

- Usuário comum:
  - CPF: 79293996307
  - senha: 123456
