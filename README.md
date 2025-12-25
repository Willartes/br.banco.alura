# 🏦 Sistema Bancário Simples em Java
Um projeto desenvolvido para praticar **Programação Orientada a Objetos (POO)** em Java, aplicando herança, encapsulamento, polimorfismo e separação de responsabilidades.  
O sistema simula operações bancárias reais, como cadastro de clientes, criação de contas, saques, depósitos e transferências.

---

## 🚀 Funcionalidades

O sistema permite:

### 👤 Clientes
- Cadastrar novos clientes
- Cada cliente pode possuir no máximo:
  - **1 Conta Corrente**
  - **1 Conta Poupança**

### 💳 Contas
- Criar conta corrente ou poupança
- Listar clientes e suas respectivas contas
- Consultar saldo

### 💰 Operações Bancárias
- Saque com validação de saldo
- Depósito
- Transferência entre contas

---

## 🧱 Arquitetura do Projeto

Organizado em classes independentes, seguindo boas práticas:

### 📂 **Cliente**
Representa a entidade cliente, contendo:
- Nome
- CPF
- Lista de contas (ArrayList)

### 📂 **Conta (classe mãe)**
Classe base responsável por:
- Número da conta  
- Saldo  
- Titular  
- Métodos: depositar, sacar, transferir

### 📂 **ContaCorrente**
Herda de `Conta`.
- Possui taxa de manutenção
- Sobrescreve `toString()`

### 📂 **ContaPoupanca**
Herda de `Conta`.
- Possui taxa de rendimento
- Método para aplicar rendimento

### 📂 **ServicoBancario**
Classe que concentra toda a lógica:
- Cadastro de clientes
- Criação de contas com restrições
- Saques, depósitos e transferências
- Verificação de cliente e conta via Stream API

### 📂 **Main**
Classe responsável por:
- Menu interativo
- Controle do fluxo do programa

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- Programação Orientada a Objetos
- **Stream API e Lambda Expressions**
- Estrutura de dados: ArrayList
- Text Blocks (""" ")
- Scanner para entrada de dados

---

## 📸 Exemplo do Menu

SISTEMA SIMPLES DE BANCO

1- Cadastrar Cliente
2- Criar Conta
3- Listar Clientes e Contas
4- Sacar
5- Depositar
6- Transferir
7- Saldo
0- Sair
---

## 📚 Objetivo Pedagógico

Este projeto foi desenvolvido para:

- Consolidar conceitos básicos e intermediários de OOP
- Praticar modelagem de entidades
- Aplicar Stream API em cenários reais
- Criar uma base sólida para projetos mais avançados
- Adquirir experiência com código limpo e organizado

---

## 📂 Estrutura do Repositório
src/ ├── Cliente.java ├── Conta.java ├── ContaCorrente.java ├── ContaPoupanca.java ├── ServicoBancario.java └── Main.java

---

## ⭐ Melhorias Futuras

- Persistência em arquivo ou banco de dados
- Interface gráfica com JavaFX
- Implementação de extratos bancários
- Testes automatizados (JUnit)
- Tratamento de exceções mais robusto
- Login e autenticação por senha

---

## 📄 Licença
Projeto livre para estudo e modificações.  
Sinta-se à vontade para contribuir ou abrir issues!

---

## 🙌 William Rodrigues da Silva

Desenvolvido com dedicação para fins de estudo.  
Feedbacks e sugestões são sempre bem-vindos!  
