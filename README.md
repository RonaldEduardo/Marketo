# Sistema de Gerenciamento de Tarefas

## Descrição
Este projeto é um sistema de gerenciamento de tarefas desenvolvido em Java, projetado para facilitar a organização e o acompanhamento de tarefas dentro de uma equipe ou organização. Ele permite a criação de usuários, setores e tarefas, além de fornecer funcionalidades para listar esses elementos.

## Funcionalidades
- **Cadastro de Usuários:** Permite o cadastro de usuários no sistema, incluindo informações como nome, e-mail e setor.
- **Listagem de Usuários:** Exibe uma lista de todos os usuários cadastrados, incluindo seus respectivos setores.
- **Cadastro de Setores:** Permite o cadastro de setores dentro da organização.
- **Listagem de Setores:** Exibe uma lista de todos os setores cadastrados.
- **Cadastro de Tarefas:** Permite o cadastro de tarefas, associando-as a um requerente, um responsável e um setor específico.
- **Listagem de Tarefas:** Exibe uma lista de todas as tarefas cadastradas, incluindo informações detalhadas sobre cada uma.

## Tecnologias Utilizadas
- **Java:** Linguagem de programação utilizada para o desenvolvimento do sistema.
- **Java Collections Framework:** Utilizado para gerenciamento de coleções de objetos, como listas.

## Estrutura do Projeto
O projeto é dividido em várias classes, organizadas em pacotes específicos:

- **model:** Contém as classes de modelo para Usuário, Tarefa e Setor.
- **service:** Contém as classes de serviço que implementam a lógica de negócios do sistema.
- **util:** Contém classes auxiliares, como a classe `UserInteract` que lida com a interação do usuário através do console.

## Como Executar
Para executar o sistema, é necessário ter o JDK instalado em sua máquina. Após clonar o repositório, navegue até o diretório do projeto e execute o seguinte comando no terminal:

```bash
java -cp bin App
