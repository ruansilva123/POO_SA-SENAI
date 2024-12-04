# FootbAPI

![Java](https://img.shields.io/badge/java-23%2B-orange)
![Maven](https://img.shields.io/badge/maven-3.9%2B-blue)
![Spring](https://img.shields.io/badge/spring--boot-3.3.4-brightgreen)

Este é um projeto desenvolvido no SENAI como parte da Situação de Aprendizagem (SA) da disciplina de Programação Orientada a Objetos (POO).

O objetivo desta API é realizar a manipulação e gerenciamento do histórico de partidas de futebol, permitindo interações com tabelas de times, competições, jogadores e partidas. Este projeto foi desenvolvido utilizando Spring e Java, destacando conceitos de POO.

## 📌 Funcionalidades Atuais

- **CRUD completo**: Permite criar, ler, atualizar e excluir jogadores, times, competições e partidas;
- **Banco de dados MySQL**: Gerenciamento eficiente e persistência de dados utilizando MySQL;
- **Documentação de API**: Integrada com Swagger (OpenAPI), acessível em: [Swagger UI - Documentação.](http://localhost:8082/api/v1/swagger-ui/index.html).

## ✨ Funcionalidades futuras

- **Autenticação e autorização**: Implementação de controle de acesso com Spring Security e JWT (JSON Web Tokens) para proteger os endpoints de manipulação de dados (POST, PUT e DELETE);
- **Migrações**: Automação e controle de versões do esquema de banco de dados utilizando Liquibase.

## 🚀 Começando

> ⚠️**Observação**:
>
> Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de que os seguintes requisitos serão atendidos:

#### 1. **Java 23+**

É necessário instalar o **Java Development Kit (JDK)** versão 23 ou superior.

- **Download do JDK:** [Baixar aqui](https://www.oracle.com/br/java/technologies/downloads/)  
- **Guia de instalação:** [Saiba como instalar e configurar o JDK](https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749)

#### 2. **Maven 3.9+**

O projeto utiliza o Apache Maven (versão 3.9 ou superior) como ferramenta de gerenciamento de dependências e build.

- **Download do Maven:** [Baixar aqui](https://maven.apache.org/download.cgi)  
- **Guia de instalação:** [Saiba como instalar e configurar o Maven](https://maven.apache.org/install.html)

#### 3. **MySQL 5.7+**

Para configurar o MySQL, siga a documentação oficial ou use o Docker para configurar rapidamente uma instância de MySQL.

- **Download do MySQL:** https://www.mysql.com/downloads/
- **Documentação:** [MySQL Documentation](https://dev.mysql.com/doc/)

> ⚠️**Observação**: a versão usada para desenvolvimento do projeto foi MySQL Community Server 8.3.0.

### 🔧 Instalação

Para executar a API em sua máquina local, siga os passos abaixo listados abaixo.

**1. Com o CMD ou uma IDE de sua preferência, navegue até a pasta onde o projeto será inserido:**
```
PS C:\Users\User\Documents\GitHub>
```
> ⚠️**Observação**: a IDE utilizada para este exemplo é o Visual Studio Code.

**2. Logo após, execute o seguinte comando no terminal:**
```
git clone https://github.com/ruansilva123/POO_SA-SENAI.git
```

**3. Acesse a pasta do projeto com o comando cd:**
```
cd POO_SA-SENAI\FootbAPI
```

**4. Dentro da pasta FootbAPI, crie um arquivo `.env` com o seguinte conteúdo:**

- DATABASE_URL = "url-do-seu-banco"
- DATABASE_USERNAME = "seu-nome-de-usuário"
- DATABASE_PASSWORD = "sua-senha"

Exemplo real:
> DATABASE_URL = "jdbc:mysql://localhost:3306/footbapi"
> 
> DATABASE_USERNAME = "root"
> 
> DATABASE_PASSWORD = "root"

> ⚠️**Observação**: o footbapi da DATABASE_URL é o nome do banco de dados, ele pode ser trocado caso necessário.

**5. Agora que as variáveis foram definidas, é necessário criar o banco de dados, então execute o seguinte comando abaixo e logo após, insira sua senha:**
```
mysql -u <seu-nome-de-usuário> -p
```

**6. Após acessar o MySQL, execute o seguinte DDL:**
```
CREATE DATABASE footbapi;
```

**7. Para verificar se o banco foi criado corretamente, utilize o comando:**
```
SHOW DATABASES;
```

**8. Criado o banco de dados, feche o MySQL:**
```
EXIT
```

**9. Agora, com o banco de dados criado, execute o seguinte comando para instalar as dependências:**
```
mvn clean install
```

> ⚠️**Observação**:
>
> Ao executar o trecho acima, o projeto pode acusar erro na parte de testes, porém, as dependências são instaladas correatmente.
>
> Caso aja erro ao instalar as dependências que não está relacionado aos testes, execute o seguinte comando para forçar a instalação:
> ```
> mvn dependency:purge-local-repository
> ```

**10. Execute o comando abaixo para inicializar a aplicação:**
```
mvn spring-boot:run
```

**11. Por fim, em seu navegador use a URL http://localhost:8082/api/v1/competitions/ para testar a aplicação. Caso a resposta do servidor seja igual o exemplo abaixo, o servidor foi iniciado corretamente.**
```json
{
  "objects":[]
}
```

Pronto, agora você pode testar a API localmente em sua máquina.😃

## 🔗 Rotas

Maiores informações sobre os endpoints do projeto podem ser encontradas em [ROUTES.md](https://github.com/ruansilva123/POO_SA-SENAI/blob/main/docs/ROUTES.md).

## 🛠️ Dependências

* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools) - Ferramenta para facilitar o desenvolvimento, oferecendo hot reload e outras funcionalidades.
* [dotenv-java](https://github.com/cdimascio/dotenv-java) - Biblioteca para carregar variáveis de ambiente a partir de um arquivo `.env`.
* [Spring Boot Starter Data JPA](https://spring.io/projects/spring-data-jpa) - Starter do Spring Boot para integração com JPA e gerenciamento de banco de dados.
* [MySQL Connector/J](https://dev.mysql.com/doc/connector-j/en/) - Driver JDBC para integração com o banco de dados MySQL.
* [Spring Boot Starter Security](https://spring.io/projects/spring-security) - Starter do Spring Boot para implementar autenticação e autorização.
* [Spring Security Test](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#testing) - Ferramentas para testar configurações e funcionalidades de segurança.
* [Lombok](https://projectlombok.org/) - Biblioteca que reduz o boilerplate no código, gerando automaticamente getters, setters e outros métodos.
* [Springdoc OpenAPI Starter](https://springdoc.org/) - Integração para documentação de APIs usando OpenAPI (Swagger).

## 📌 Versão 1.0.0

Este projeto segue o padrão de versionamento [SemVer](http://semver.org/) (Semantic Versioning).

## ✒️ Autores

* **Gustavo Mafra Paluski** - *Desenvolvedor Backend* - [GitHub](https://github.com/gustavsonpy)
* **Ruan Carlos da Silva** - *Desenvolvedor Backend* - [GitHub](https://github.com/ruansilva123)

## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE.md](https://github.com/ruansilva123/POO_SA-SENAI/blob/main/LICENSE) para detalhes.
