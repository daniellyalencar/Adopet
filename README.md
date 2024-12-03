# Adopet :dog::cat:
Projeto desenvolvido com a criação de uma API para representar um Sistema de Adoção de Pet (a princípio gato e cachorro) incluindo a relação de Pet com um Abrigo, um Tutor e realização da Adoção em si.

### :information_source: Visão Geral
Desenvolvimento realizado buscando a aplicação de boas práticas de código de modo a garantir melhor legibilidade e manutenção. <br>
Seguindo o padrão MVC (Model-View-Controller). <br>
Criação das classes model (otimização de relacionamentos para não carregá-los desnecessariamente, criação de construtores e somente métodos setters necessários). <br>
Criação das classes controller (realizam apenas intermédia/chamada entre cliente e service). <br>
Criação das interfaces repository (camada de persistência com entidades JPA para acesso ao banco de dados) - consultas otimizadas com filtros para melhor performance. <br>


### ⚙️ Ferramentas utilizadas
- Spring
- Modelo MVC
- Intellij IDEA
- Paradigma de orintação de objetos
- Insomnia

### 🛠️ Funcionalidades
- Aprovar Adoção
- Reprovar Adoção
- Atualizar Tutor
- Cadastrar Abrigo
- Cadastrar Pet em um Abrigo
- Cadastrar Tutor
- Solicitar Adoção
- Listar Abrigos
- Listar Adoções
- Listar Pets
- Listar Pets de um Abrigo
- Listar Tutores

### :recycle: Refatoração
O projeto passou por uma refatoração significativa para melhorar a estrutura do código e a eficiência do sistema. As principais mudanças incluem:

- **Separação de responsabilidades**: As classes foram reorganizadas para seguir o princípio de responsabilidade única, facilitando a manutenção e a escalabilidade.
- **Otimização de consultas**: As consultas ao banco de dados foram otimizadas para reduzir o tempo de resposta e melhorar a performance.
- **Validações centralizadas**: As validações foram centralizadas em componentes específicos, garantindo consistência e reutilização de código.
- **Melhoria na legibilidade**: O código foi refatorado para ser mais legível e compreensível, facilitando a colaboração entre desenvolvedores.

### :white_check_mark: Vantagens da Refatoração
- **Manutenção facilitada**: Com a separação de responsabilidades e a melhoria na legibilidade, a manutenção do código se torna mais simples e eficiente.
- **Performance aprimorada**: A otimização das consultas e a centralização das validações resultam em um sistema mais rápido e responsivo.
- **Escalabilidade**: A nova estrutura do código permite que o sistema seja facilmente escalado para adicionar novas funcionalidades ou suportar um maior número de usuários.
- **Reutilização de código**: Componentes reutilizáveis reduzem a duplicação de código e facilitam a implementação de novas funcionalidades.

### 🔍 Testes
Utilização do Insomnia para testar requisições da API.<br>
<br>
![image](https://github.com/user-attachments/assets/3353804c-f8e1-4c3d-b3e6-8baa4022e4ce)

