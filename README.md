Selenium Java Automation - Training Project 🚀

Este repositório é dedicado ao aprendizado e prática de automação de testes utilizando o site Automation Exercise. O foco é a implementação de um framework robusto, escalável e seguindo as melhores práticas de Quality Assurance.


🎯 Objetivo do Projeto

Validar os principais fluxos de um e-commerce, garantindo a integridade de funcionalidades críticas como:

    Registro de usuário e Login/Logout.

    Fluxo de navegação e busca de produtos.

    Adição de itens ao carrinho e checkout.

    Validação de formulários e mensagens de erro (Negative Testing).

🛠️ Stack Tecnológica & Padrões

    Linguagem: Java 17 (via SDKMAN!)

    Automação: Selenium WebDriver (v4.25.0)

    Framework de Teste: JUnit 5

    Design Pattern: Page Object Model (POM)

    Reporting: Allure Report com captura de screenshots em falhas.

    Configuração: Dotenv para gestão de URLs e credenciais de teste.

🏗️ Estrutura de Pastas

src/
 ├── main/java/
 │    ├── pages/          # Classes com elementos e ações (POM)
 │    └── utils/          # Configurações de ambiente (.env) e Helpers
 └── test/java/
      ├── base/           # Setup/Teardown e Hooks de Screenshot
      └── tests/          # Cenários de teste divididos por funcionalidade

🚀 Como Executar

Este projeto foi desenvolvido seguindo padrões de portabilidade e pode ser executado em Windows, Linux ou macOS.
Pré-requisitos

    Java JDK 17 ou superior.

    Maven instalado e configurado no PATH.

    Google Chrome instalado (o WebDriverManager cuidará do driver compatível).

Configuração de Ambiente

    Na raiz do projeto, crie um arquivo .env (utilize o .env.example como referência).

    Certifique-se de que as credenciais e a BASE_URL estão corretas para o site Automation Exercise.

Execução

mvn clean verify

📊 Visualizando o Relatório (Allure)

Após a execução, gere o relatório visual para analisar os resultados e evidências:

allure serve target/allure-results
