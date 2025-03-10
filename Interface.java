import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGUI { // Declarando os componentes
    private JFrame frame; // Janela principal do programa
    private JTextArea areaTexto;
    private JTextField campoNomeUsuario, campoTituloItem;
    private Biblioteca biblioteca;

    public InterfaceGUI() {
        biblioteca = new Biblioteca();
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

        frame = new JFrame("Biblioteca de livros");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(144, 238, 144));
        frame.setLayout(new BorderLayout());

        // Área de texto para exibição
        areaTexto = new JTextArea();
        areaTexto.setEditable(false); // Usuário não pode modificar nada
        areaTexto.setBackground(new Color(144, 238, 144));
        JScrollPane scroll = new JScrollPane(areaTexto); // Barra de rolagem
        frame.add(scroll, BorderLayout.CENTER);

        // Exibir a lista de livros disponíveis na área de texto
        exibirLivrosDisponiveis();

        // Painel de controle
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2));

        painel.add(new JLabel("Nome do Usuário:"));
        campoNomeUsuario = new JTextField();
        painel.add(campoNomeUsuario);

        painel.add(new JLabel("Título do Item:"));
        campoTituloItem = new JTextField();
        painel.add(campoTituloItem);

        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        painel.add(btnCadastrarUsuario);

        JButton btnAlugar = new JButton("Alugar Item");
        painel.add(btnAlugar);

        JButton btnDevolver = new JButton("Devolver Item");
        painel.add(btnDevolver);

        frame.add(painel, BorderLayout.SOUTH);

        // Ação de cadastrar usuário
        btnCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUsuario = campoNomeUsuario.getText();

                // Verifica se o nome do usuário já está na biblioteca
                Usuario usuarioExistente = biblioteca.buscarUsuario(nomeUsuario);

                if (usuarioExistente != null) {
                    areaTexto.append("Erro: Usuário já cadastrado.\n");
                } else if (!nomeUsuario.isEmpty()) {
                    Usuario novoUsuario = new Usuario(nomeUsuario);
                    biblioteca.adicionarUsuarios(novoUsuario);
                    areaTexto.append("Novo usuário cadastrado: " + nomeUsuario + "\n");
                    campoNomeUsuario.setText("");
                } else {
                    areaTexto.append("Erro: O nome do usuário não pode ser vazio.\n");
                }
            }
        });

        // Ação de alugar item
        btnAlugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUsuario = campoNomeUsuario.getText();
                String tituloItem = campoTituloItem.getText();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);
                Item item = biblioteca.buscarItem(tituloItem);

                if (usuario != null && item != null) {
                    usuario.alugarItem(item);
                    areaTexto.append(usuario.getNome() + " alugou o item: " + item.getTitulo() + "\n");
                } else {
                    areaTexto.append("Erro: Usuário ou item não encontrado.\n");
                }
            }
        });

        // Ação de devolver item
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUsuario = campoNomeUsuario.getText();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    usuario.devolverItem();
                    areaTexto.append(usuario.getNome() + " devolveu um item.\n");
                } else {
                    areaTexto.append("Erro: Usuário não encontrado.\n");
                }
            }
        });

        frame.setVisible(true);
    }

    // Método para exibir a lista de livros disponíveis
    private void exibirLivrosDisponiveis() {
        areaTexto.append("Livros disponíveis:\n");
        for (Livro livro : biblioteca.getLivros()) {
            areaTexto.append(livro.getTitulo() + " - " + livro.getAutor() + "\n");
        }
    }

    public static void main(String[] args) {
        new InterfaceGUI();
    }
}

