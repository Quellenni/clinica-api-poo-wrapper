# Clínica API POO

Projeto-base da disciplina **Projeto e Implementação Orientada a Objetos**.

## Objetivo

Desenvolver uma API REST para gestão de uma clínica médica, aplicando conceitos de:

- Programação Orientada a Objetos
- Arquitetura em camadas
- API REST
- Persistência com JPA
- Validações
- Tratamento de erros
- Swagger/OpenAPI

## Tecnologias

- Java 17 ou superior
- Spring Boot
- Maven Wrapper
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation
- Swagger/OpenAPI

## Como executar no Windows

Não é necessário instalar Maven. Use o Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Na primeira execução, o script baixa o Maven automaticamente. Isso pode demorar alguns minutos.

## Como executar no Linux/macOS

```bash
./mvnw spring-boot:run
```

## Swagger

Acesse:

```text
http://localhost:8080/swagger-ui.html
```

ou:

```text
http://localhost:8080/swagger-ui/index.html
```

## H2 Console

Acesse:

```text
http://localhost:8080/h2-console
```

Dados:

```text
JDBC URL: jdbc:h2:mem:clinicadb
User: sa
Password: deixe em branco
```

## Funcionalidades iniciais

- Cadastrar paciente
- Listar pacientes

## Teste inicial no Swagger

POST `/pacientes`

```json
{
  "nome": "Maria Silva",
  "cpf": "12345678900",
  "telefone": "82999999999"
}
```

Depois teste GET `/pacientes`.

## Estrutura de pacotes

```text
br.com.clinica
├── controller
├── dto
├── exception
├── model
├── repository
└── service
```

## Evolução prevista nas aulas

- Aula prática 1: cadastro e listagem de pacientes
- Aula prática 2: médicos e especialidades
- Aula prática 3: consultas, regras de negócio e validações
- Aula prática 4: padrões, tratamento de erros e consolidação do Swagger
