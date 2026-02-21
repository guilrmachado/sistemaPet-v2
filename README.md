
# Sistema Pet API

API REST desenvolvida com Java e Spring Boot para gerenciamento de pets.

Projeto criado com foco em arquitetura em camadas, aplicação de regras de negócio, tratamento adequado de exceções e testes unitários — simulando um ambiente real de desenvolvimento backend.

⸻

## Funcionalidades

• CRUD completo de pets
• Validação de regras de negócio
• Atualização parcial com PATCH
• Tratamento global de exceções
• Retorno adequado de status HTTP
• Testes unitários na camada de serviço

⸻

##  Regras de Negócio

• Nome deve conter nome e sobrenome
• Peso deve estar entre 0.5kg e 60kg
• Idade deve ser menor ou igual a 20 anos
• Campos obrigatórios não podem ser nulos
• Operações inválidas retornam status HTTP apropriado (400, 404, etc.)

⸻

## Tecnologias Utilizadas

• Java
• Spring Boot
• Spring Web
• Spring Data JPA
• SQL Server
• Docker
• Maven
• JUnit 5
• Mockito

⸻

##  Arquitetura

O projeto segue arquitetura em camadas:
• Controller → Exposição dos endpoints REST
• Service → Regras de negócio e validações
• Repository → Persistência com Spring Data JPA
• Model → Entidades do domínio

Separação clara de responsabilidades, facilitando manutenção e testabilidade.

⸻

##  Configuração do Banco

### 🔹 Opção 1 - Banco local
1. Copie application-example.properties
2. Renomeie para application.properties
3. Configure usuário, senha e nome do banco

O arquivo application.properties está no .gitignore.

⸻

### 🔹 Opção 2 - Usando Docker

Com Docker em execução, rode na raiz do projeto:

docker compose up -d

O SQL Server será iniciado na porta 1433.

⸻

##  Execução
1. Configurar o banco (local ou Docker)
2. Executar a aplicação Spring Boot
3. Testar endpoints via Postman

⸻

##  Endpoints

Criar Pet - POST /pets
Listar Pets - GET /pets
Buscar Pet por ID - GET /pets/{id}
Atualizar Pet - PUT /pets/{id}
Atualização Parcial - PATCH /pets/{id}
Deletar Pet - DELETE /pets/{id}

⸻

##  Testes

Testes unitários implementados na camada de Service utilizando JUnit 5 e Mockito.

Cobertura de:
• Criação válida
• Validações de regra de negócio
• Lançamento de exceções
• Garantia de que o repository não é chamado em cenários inválidos

⸻

## Autor

Guilherme Machado
Estudante de Ciência da Computação – UERJ
Foco em Backend Java e Spring