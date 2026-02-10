
# 🐾 Sistema Pet v2

Projeto em Java para cadastro de pets, criado com foco em aprendizado de backend e preparação para estágio.

## Tecnologias utilizadas

- Java
- Maven
- Docker
- SQL Server
- JDBC

## Objetivo

Refatoração da primeira versão do projeto adicionando:

- Gerenciamento de dependências com Maven
- Banco de dados com SQL Server
- Containerização com Docker
- Estrutura preparada para futura integração com Spring

Atualmente o sistema ainda utiliza arquivos .txt para persistência de dados.
A estrutura com banco de dados já foi preparada com Docker e SQL Server.
A próxima etapa é migrar a persistência para o banco.

## Estrutura do Projeto

src/main/java -> Classes principais
docker-compose.yml -> Banco de dados SQL Server
pom.xml -> Dependências Maven


## Como rodar o banco de dados

É necessário ter Docker instalado.
Certifique-se de que o Docker esteja aberto.

No terminal, dentro da pasta do projeto:

docker compose up -d

Isso irá subir o SQL Server em container.

## Banco de Dados

- Tipo: SQL Server
- Porta padrão: 1433
- Usuário: sa
- Senha: definida no docker-compose

## Próximos passos

- Integração com Spring Boot
- API REST
- CRUD completo
- Testes unitários

## Autor

Guilherme Rodrigues

