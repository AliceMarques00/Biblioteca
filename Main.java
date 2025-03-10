import java.util.InputMismatchException;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        //add livros e usuários
        biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis"));
        biblioteca.adicionarLivro(new Livro("A Moreninha", "Joaquim Manuel de Macedo"));
        biblioteca.adicionarLivro(new Livro("Moby Dick", "Herman Melville"));
        biblioteca.adicionarLivro(new Livro("Crime e Castigo", "Fyodor Dostoevsky"));
        biblioteca.adicionarLivro(new Livro("O Grande Gatsby", "F. Scott Fitzgerald"));
        biblioteca.adicionarLivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez"));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        biblioteca.adicionarLivro(new Livro("A Revolução dos Bichos", "George Orwell"));
        biblioteca.adicionarLivro(new Livro("O Processo", "Franz Kafka"));
        biblioteca.adicionarLivro(new Livro("O Estrangeiro", "Albert Camus"));
        biblioteca.adicionarLivro(new Livro("A Metamorfose", "Franz Kafka"));
        biblioteca.adicionarLivro(new Livro("A Arte da Guerra", "Sun Tzu"));
        biblioteca.adicionarLivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        biblioteca.adicionarUsuarios(new Usuario("Alice"));
        biblioteca.adicionarUsuarios(new Usuario("Luiz"));



        // adicionar revistas
        biblioteca.adicionarItem(new Revista("Science", "Editora Nature"));

        //menu
        while (true) {
            try {
                System.out.println("1 - Alugar item");
                System.out.println("2 - Devolver item");
                System.out.println("3 - Sair");
                System.out.println("Escolha uma opção: ");
                int opcao = sc.nextInt();
                sc.nextLine(); // consumir nova linha

                if (opcao == 1) {
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = sc.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                    if (usuario != null) {
                        System.out.println("Digite o nome do item: ");
                        String tituloItem = sc.nextLine();
                        Item item = biblioteca.buscarItem(tituloItem);

                        if (item != null) {
                            usuario.alugarItem(item);
                        } else {
                            System.out.println("Item indisponível!");
                        }
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                } else if (opcao == 2) {
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = sc.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                    if (usuario != null) {
                        usuario.devolverItem();
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                } else if (opcao == 3) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                sc.nextLine(); // consumir a entrada inválida
            }
            catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        sc.close();
    }
}
