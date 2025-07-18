# 📘 Projeto de Gerenciamento de Usuários

Este projeto é uma aplicação desenvolvida com **Spring Boot** que permite o cadastro, busca e listagem de usuários. Ideal para fins educacionais, testes e demonstração de regras de negócio com validações personalizadas.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.3**
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Validation
  - Spring Boot DevTools
  - Spring Boot Starter Test
- **Spring Data JPA**
- **Hibernate**
- **Hibernate Validator** (`@CPF`, `@Email`)
- **H2 Database** (em memória, para desenvolvimento/testes)
- **Lombok**
- **Jackson** (para serialização/desserialização JSON)
- **Maven** (build e gerenciamento de dependências)

---

## ⚙️ Regras de Negócio

As regras a seguir foram implementadas na **camada de serviço (`UsuarioService`)**:

### 📝 Cadastro de Usuário

- Campos obrigatórios: `nome`, `cpf`, `email`, `telefone`.
- O CPF e o e-mail devem estar em formatos válidos.
- CPF e e-mail devem ser **únicos** no sistema.

#### Exceções personalizadas:

- `CpfExistenteException`: `"Este CPF já está cadastrado no sistema!"`
- `EmailExistenteException`: `"Email já cadastrado no sistema!"`
- Se ambos já existirem: `"CPF e EMAIL já cadastrados no sistema!"`

---

### 🔎 Busca de Usuário

- Busca por **ID** ou **CPF**.
- Se o usuário não for encontrado:
  - Lança `UsuarioNaoEncontrado`.
- Operações de busca são **transacionais** e de **somente leitura**.

### 📄 Listagem de Usuários

- Retorna **todos os usuários cadastrados**.
- Também é uma operação transacional e de leitura.

### ▶️ Requisitos Mínimos para Executar com Postman

- **Java 21** ou superior
- **Maven**
- **Postman** (ou Insomnia, curl, etc.)

---

## 🚀 Passos para Rodar o Projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/gerenciamento-usuario.git
   cd gerenciamento-usuario
2. **Compile e execute com Maven ou no Run (Current File)**
   ```bash
   mvn spring-boot:run
-  A aplicação será iniciada em: `http://localhost:8080`

### 💾 Acessando o H2 Console (Opcional)
-  URL: `http://localhost:8080/h2-console`
-  JDBC URL: `jdbc:h2:mem:sigepsdb`
-  Username: `sa`
-  Senha: (_Deixe em branco_)
-  Clique em **Connect**

### 📬 Exemplos de Requisições (via Postman)
Todos os endpoints estão sob o prefixo: `/api/usuario`

### 1️⃣ Cadastrar Novo Usuário
- URL: `http://localhost:8080/api/usuario/cadastro`
- Método: `POST`
- Header: `Content-Type: application/json`
- Body (JSON):
  ```json
  {
    "nome": "João Silva",
    "cpf": "123.456.789-00",
    "email": "joao.silva@example.com",
    "sexo": "MASCULINO",
    "telefone": "11987654321"
  }
🔁 Tente cadastrar com CPF ou e-mail já existente para testar as exceções personalizadas.

### 2️⃣ Listar Todos os Usuários
- URL: `http://localhost:8080/api/usuario`
- Método: `GET`

### 3️⃣ Buscar Usuário por ID
- URL: `http://localhost:8080/api/usuario/{id}`
- Exemplo: `http://localhost:8080/api/usuario/1`
- Método: `GET`

### 4️⃣ Buscar Usuário por CPF
- URL: `http://localhost:8080/api/usuario/cpf/{cpf}`
- Exemplo: `http://localhost:8080/api/usuario/cpf/123.456.789-00`
- Método: `GET`

---

## 👤 *Autor / Equipe*

| Nome          | Papel                  | Contato             |
|---------------|------------------------|---------------------|
| Jhean Barbosa | *Desenvolvedor Back-End* | jheanbarbosa1233@gmail.com     |

---

## 📄 *Licença*

Este projeto está licenciado sob a **MIT License** – veja o arquivo [`LICENSE`](./LICENSE) para mais informações.

