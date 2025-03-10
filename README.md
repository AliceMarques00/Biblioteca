# BibliotecaProjeto

Este é um projeto simples de uma biblioteca em Java, que permite adicionar livros, revistas e usuários, além de permitir que os usuários aluguem e devolvam itens.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

- `Main`: Classe principal que contém o método `main` e o menu de interação com o usuário.
- `Biblioteca`: Classe que gerencia os livros, revistas e usuários.
- `Pessoa`: Classe base para representar uma pessoa.
- `Usuario`: Classe que herda de `Pessoa` e representa um usuário da biblioteca.
- `Item`: Classe base abstrata para representar um item da biblioteca.
- `Livro`: Classe que herda de `Item` e representa um livro.
- `Revista`: Classe que herda de `Item` e representa uma revista.

## Funcionalidades

- Adicionar livros, revistas e usuários à biblioteca.
- Alugar e devolver livros e revistas.
- Exibir mensagens apropriadas para entradas inválidas e exceções.

## Como Executar

1. Clone o repositório para sua máquina local.
2. Compile os arquivos `.java` usando o comando:
    ```sh
    javac -d bin src/*.java
    ```
3. Execute o programa usando o comando:
    ```sh
    java -cp bin Main
    ```

## Exemplo de Uso
Ao executar o programa, você verá um menu com as seguintes opções:
1 - Alugar item 2 - Devolver item 3 - Sair 
Escolha uma opção:

### Adicionar Livros e Revistas

Os livros e revistas são adicionados no início do programa, no método `main` da classe `Main`:

```java
biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien"));
biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));
biblioteca.adicionarItem(new Revista("Science", "Editora Nature"));

Adicionar Usuários
Os usuários também são adicionados no início do programa:

biblioteca.adicionarUsuarios(new Usuario("Alice"));
biblioteca.adicionarUsuarios(new Usuario("Luiz"));

Alugar e Devolver Itens
Os usuários podem alugar e devolver itens através do menu interativo. O programa solicitará o nome do usuário e o título do item para realizar as operações.

Tratamento de Exceções
O programa inclui tratamento de exceções para entradas inválidas e outros erros:

catch (InputMismatchException e) {
    System.out.println("Entrada inválida! Por favor, insira um número.");
    sc.nextLine(); // consumir a entrada inválida
} catch (Exception e) {
    System.out.println("Ocorreu um erro: " + e.getMessage());
}


