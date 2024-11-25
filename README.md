# Adopet :dog::cat:
Projeto desenvolvido com a criação de uma API para representar um Sistema de Adoção de Pet (a princípio gato e cachorro) incluindo a relação de Pet com um Abrigo, um Tutor e realização da Adoção em si.

### :information_source: Visão Geral
Desenvolvimento realizado buscando a aplicação de boas práticas de código de modo a garantir melhor legibilidade e manutenção. <br>
Seguindo o padrão MVC (Model-View-Controller). <br>
Criação das classes model (otimização de relacionamentos para não carregá-los desnecessariamente, criação de construtores e somente métodos setters necessários). <br>
Criação das classes controller (realizam apenas intermédia/chamada entre cliente e service). <br>
Criação das interfaces repository (camada de persistência com entidades JPA para acesso ao banco de dados) - consultas otimizadas com filtros para melhor performance. <br>


### 🛠️ Ferramentas utilizadas
- Spring
- Modelo MVC
- Intellij IDEA
- Paradigma de orintação de objetos
- Insomnia

### Funcionalidades
- Cadastrar Abrigo
- Cadastrar Pet em um Abrigo
- Cadastrar Tutor
- Solicitar Adoção
- Listar Abrigos
- Listar Pets
- Listar Pets de um Abrigo

