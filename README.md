# Projeto Aplicado 4 - PC2D (Backend)
PC2D (Programa de Cadastro de Pessoas com Deficiência) é um banco de dados de pessoas com deficiência e suas necessidades.
Nele é possível criar, ler, alterar e deletar registros realizados em conformidade com o padrão CRUD. Também é possível
gerar relatórios sobre as necessidades por região.

Projeto foi criado ao longo do quarto semeste do curso Análise e Desenvolvimento de Sistemas do Senai/SC.

Foram aproveitadas partes do [Projeto Aplicado 2](https://github.com/MauroJoseVieiraJr/Projeto-Final)</a> de semestres anteriores.

## Autores
- [Carla Kobielski](https://github.com/CarlaKobielski)
- [Filipe de Freitas](https://github.com/Filipedefreitas)
- [Mauro José Vieira Junior](https://github.com/MauroJoseVieiraJr)

## Pré-requisitos
Para rodar este projeto é necessário ter o Java versão 20.0.1 (2023-04-18), PostgreSQL 15.2 build 1914 e Spring Boot 3.2.0 ou versões mais recentes instaladas em sua máquina.

Caso utilize a IDE Eclipse EE importe o projeto após clonar este repositório para poder editá-lo.

Não se esqueça de ir no arquivo application.properties e alterar a porta de 5433 para 5432 caso tenha recém instalado o PostgreSQL.

**A modelagem do banco de dados está em "/src/main/resources/Modelagem do Banco de Dados (PostgreSQL).txt"**

Para testar os endpoints do backend foi utilizado o software Insomnia (https://insomnia.rest/download)

## Dependências
- Spring Boot Dev Tools
- Spring Web
- Lombok
- Spring Data JPA
- PostgreSQL Driver

## Bibliografia
- **Vídeos tutoriais do professor Julio Cezar Rutke na plataforma AVA Sesi/Senai**
- Projeto inicial gerado com a ferramenta Spring Initializr (utilizando as dependências citadas anteriormente)
	- https://start.spring.io/
- Java 20.0.1
	- https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html
- PostgreSQL 15.2 (versão acessada em 2023-11-19 é a 15.5)
	- https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
- Criando Aplicação Fullstack do Zero com Java Spring e React - Parte 1: Desenvolvimento do Backend
	- https://www.youtube.com/watch?v=lUVureR5GqI
- Projeto Web API Java Spring Boot - 2 (Front-end HTML/CSS)
	- https://www.youtube.com/watch?v=Vhc1oAYXqTk
- Projeto Web API Java Spring Boot - 3 ( Front-end JavaScript)
	- https://www.youtube.com/watch?v=JOzFVnMzcXI
- Projeto Web API Java Spring Boot - 5 (Model e DAO)
	- https://www.youtube.com/watch?v=a_yxI-stMsM
- Projeto Web API Java Spring Boot - 6 (Endpoints)
	- https://www.youtube.com/watch?v=ga3Fj47hBLU
- Projeto Web API Java Spring Boot - 7 (Conectando Front/Back)
	- https://www.youtube.com/watch?v=hsewph3Xphw
- innerHTML with For Loop in Javascript
	- https://stackoverflow.com/questions/12996763/innerhtml-with-for-loop-in-javascript
- JavaScript | How to Fetch Data from an API
	- https://www.youtube.com/watch?v=zOrejGF0oBA
- REST API design - optional request parameters
	- https://stackoverflow.com/questions/61033474/rest-api-design-optional-request-parameters