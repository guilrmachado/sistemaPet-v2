
<<<<<<< HEAD
#  Sistema PET API

##  Descrição
API RESTful para gerenciamento de pets.  
Permite cadastrar, listar, atualizar e remover pets de um banco de dados SQL Server.

Este projeto é a evolução de uma versão anterior sem Spring.  
Agora utiliza Spring Boot, Docker e JPA.

---

##  Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Docker
- SQL Server
- Postman (para testes)

---

##  Estrutura do Projeto


src
└── main
├── java
│   └── com.guilherme.sistema_pet
│       ├── controller
│       ├── model
│       ├── repository
│       └── service
└── resources
├── application.properties
└── application-example.properties


- model → Entidades do banco de dados
- repository → Interfaces JPA
- controller → Endpoints REST
- service → Regras de negócio (em desenvolvimento)

---

##  Configuração

### Banco de Dados
O projeto utiliza SQL Server rodando via Docker.

O arquivo application.properties não é enviado ao GitHub por segurança.

Use o arquivo:

application-example.properties

Copie ele e renomeie para:

application.properties

Depois ajuste:

- username
- password
- nome do banco

---

##  Docker

Para subir o banco de dados:

docker-compose up -d

---

##  Como Rodar o Projeto

1. Subir o Docker
2. Configurar application.properties
3. Abrir o projeto no IntelliJ
4. Rodar a aplicação Spring Boot
5. Testar endpoints no Postman

---

##  Endpoints Principais

### Criar Pet

POST /pets

### Listar Pets

GET /pets

### Buscar Pet por ID

GET /pets/{id}

### Atualizar Pet

PUT /pets/{id}

### Atualização Parcial

PATCH /pets/{id}

### Deletar Pet

DELETE /pets/{id}

---

##  Observações

- Projeto em evolução
- Camada Service será adicionada
- Testes unitários serão implementados
- Senhas reais não são armazenadas no repositório
- Arquivo application.properties está no .gitignore

---

##  Autor

Guilherme Machado
=======
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

>>>>>>> 762cc785ea69d214a31a8c5621e690d88db369c9
