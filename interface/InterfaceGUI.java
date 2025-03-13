import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGUI {
    private Biblioteca biblioteca;
    private JFrame frame;
    private JPanel telaBoasVindas, telaMenuPrincipal, telaSistemaBiblioteca, telaCadastrarLivro;
    private JTextField campoNomeLivro, campoAutorLivro;

    public InterfaceGUI() {
        biblioteca = new Biblioteca(); // Instancia a Biblioteca

        // Configuração da janela principal
        frame = new JFrame("Biblioteca Virtual");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());

        // Cria as telas
        criarTelaBoasVindas();
        criarTelaMenuPrincipal();
        criarTelaSistemaBiblioteca();
        criarTelaCadastrarLivro();

        // Adiciona as telas ao frame
        frame.add(telaBoasVindas, "BoasVindas");
        frame.add(telaMenuPrincipal, "MenuPrincipal");
        frame.add(telaSistemaBiblioteca, "SistemaBiblioteca");
        frame.add(telaCadastrarLivro, "CadastrarLivro");

        // Exibe a tela de boas-vindas
        ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "BoasVindas");
        frame.setVisible(true);
    }

    // Tela 1: Boas-Vindas
    private void criarTelaBoasVindas() {
        telaBoasVindas = new JPanel();
        telaBoasVindas.setLayout(new BorderLayout());
        telaBoasVindas.setBackground(new Color(245, 222, 179)); // Cor de papel antigo

        // Título
        JLabel lblTitulo = new JLabel("Bem-vindo à Biblioteca Virtual", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 30));
        lblTitulo.setForeground(new Color(139, 69, 19)); // Cor marrom
        telaBoasVindas.add(lblTitulo, BorderLayout.CENTER);

        // Botão para continuar
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setFont(new Font("Serif", Font.PLAIN, 18));
        btnContinuar.setBackground(new Color(139, 69, 19)); // Cor marrom
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navega para a Tela 2 (Menu Principal)
                ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "MenuPrincipal");
            }
        });
        telaBoasVindas.add(btnContinuar, BorderLayout.SOUTH);
    }

    // Tela 2: Menu Principal
    private void criarTelaMenuPrincipal() {
        telaMenuPrincipal = new JPanel();
        telaMenuPrincipal.setLayout(new GridLayout(3, 1, 10, 10));
        telaMenuPrincipal.setBackground(new Color(245, 222, 179)); // Cor de papel antigo
        telaMenuPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnAcessarSistema = criarBotao("Acessar Sistema");
        JButton btnSair = criarBotao("Sair");

        btnAcessarSistema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navega para a Tela 3 (Sistema da Biblioteca)
                ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "SistemaBiblioteca");
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha o programa
            }
        });

        telaMenuPrincipal.add(btnAcessarSistema);
        telaMenuPrincipal.add(btnSair);
    }

    // Tela 3: Sistema da Biblioteca
    private void criarTelaSistemaBiblioteca() {
        telaSistemaBiblioteca = new JPanel();
        telaSistemaBiblioteca.setLayout(new GridLayout(6, 1, 10, 10));
        telaSistemaBiblioteca.setBackground(new Color(245, 222, 179)); // Cor de papel antigo
        telaSistemaBiblioteca.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnCadastrarUsuario = criarBotao("Cadastrar Usuário");
        JButton btnAlugarLivro = criarBotao("Alugar Livro");
        JButton btnDevolverLivro = criarBotao("Devolver Livro");
        JButton btnVerLivros = criarBotao("Ver Lista de Livros");
        JButton btnCadastrarLivro = criarBotao("Cadastrar Livro");
        JButton btnVoltar = criarBotao("Voltar ao Menu Principal");

        btnCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        btnAlugarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alugarLivro();
            }
        });

        btnDevolverLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLivro();
            }
        });

        btnVerLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verListaLivros();
            }
        });

        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navega para a Tela 4 (Cadastrar Livro)
                ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "CadastrarLivro");
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a Tela 2 (Menu Principal)
                ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "MenuPrincipal");
            }
        });

        telaSistemaBiblioteca.add(btnCadastrarUsuario);
        telaSistemaBiblioteca.add(btnAlugarLivro);
        telaSistemaBiblioteca.add(btnDevolverLivro);
        telaSistemaBiblioteca.add(btnVerLivros);
        telaSistemaBiblioteca.add(btnCadastrarLivro);
        telaSistemaBiblioteca.add(btnVoltar);
    }

    // Tela 4: Cadastrar Livro
    private void criarTelaCadastrarLivro() {
        telaCadastrarLivro = new JPanel();
        telaCadastrarLivro.setLayout(new GridLayout(4, 1, 10, 10));
        telaCadastrarLivro.setBackground(new Color(245, 222, 179)); // Cor de papel antigo
        telaCadastrarLivro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNomeLivro = new JLabel("Nome do Livro:");
        lblNomeLivro.setFont(new Font("Serif", Font.PLAIN, 18));
        campoNomeLivro = new JTextField();

        JLabel lblAutorLivro = new JLabel("Nome do Autor:");
        lblAutorLivro.setFont(new Font("Serif", Font.PLAIN, 18));
        campoAutorLivro = new JTextField();

        JButton btnCadastrar = criarBotao("Cadastrar");
        JButton btnVoltar = criarBotao("Voltar");

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a Tela 3 (Sistema da Biblioteca)
                ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "SistemaBiblioteca");
            }
        });

        telaCadastrarLivro.add(lblNomeLivro);
        telaCadastrarLivro.add(campoNomeLivro);
        telaCadastrarLivro.add(lblAutorLivro);
        telaCadastrarLivro.add(campoAutorLivro);
        telaCadastrarLivro.add(btnCadastrar);
        telaCadastrarLivro.add(btnVoltar);
    }

    // Método para criar botões estilizados
    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Serif", Font.PLAIN, 18));
        botao.setBackground(new Color(139, 69, 19)); // Cor marrom
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }

    // Métodos para operações
    private void cadastrarUsuario() {
        String nomeUsuario = JOptionPane.showInputDialog(frame, "Digite o nome do usuário:");
        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
            try {
                biblioteca.adicionarUsuario(new Usuario(nomeUsuario)); // Instancia um novo Usuário e adiciona à biblioteca(CRIADO EM BIBLIOTECA)
                biblioteca.salvarUsuarios();
                JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!");
            } catch (UsuarioJaCadastradoException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void alugarLivro() {
        String nomeUsuario = JOptionPane.showInputDialog(frame, "Digite o nome do usuário:");
        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
            Usuario usuario = biblioteca.buscarUsuario(nomeUsuario); // Busca o usuário na biblioteca (CRIADO NA BIBLIOTECA)
            if (usuario != null) {
                String tituloLivro = JOptionPane.showInputDialog(frame, "Digite o título do livro:");
                if (tituloLivro != null && !tituloLivro.isEmpty()) {
                    Livro livro = (Livro) biblioteca.buscarItem(tituloLivro); // Busca o livro na biblioteca(CRIADO NA BIBLIOTECA)
                    if (livro != null && livro.isDisponivel()) {
                        usuario.alugarItem(livro); // Aluga o livro para o usuário(CRIADA EM USUARIO)
                        biblioteca.salvarLivros(); // Atualiza o arquivo de livros(CRIADA EM BIBLIOTECA)
                        JOptionPane.showMessageDialog(frame, "Livro alugado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Livro indisponível ou não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void devolverLivro() {
        String nomeUsuario = JOptionPane.showInputDialog(frame, "Digite o nome do usuário:");
        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
            Usuario usuario = biblioteca.buscarUsuario(nomeUsuario); // Busca o usuário na biblioteca
            if (usuario != null) {
                String tituloLivro = JOptionPane.showInputDialog(frame, "Digite o título do livro:");
                if (tituloLivro != null && !tituloLivro.isEmpty()) {
                    Livro livro = (Livro) biblioteca.buscarItem(tituloLivro); // Busca o livro na biblioteca
                    if (livro != null) {
                        usuario.devolverItem(livro); // Devolve o livro
                        biblioteca.salvarLivros(); // Atualiza o arquivo de livros
                        JOptionPane.showMessageDialog(frame, "Livro devolvido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Livro não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void verListaLivros() {
        StringBuilder lista = new StringBuilder("===== LIVROS DISPONÍVEIS =====\n");
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.isDisponivel()) { //CRIADA NA CLASS ITEM
                lista.append(livro.getTitulo()).append(" - ").append(livro.getAutor()).append("\n");
            }
        }
        lista.append("\n===== LIVROS INDISPONÍVEIS =====\n");
        for (Livro livro : biblioteca.getLivros()) {
            if (!livro.isDisponivel()) { // CRIADA NA CLASS ITEM
                lista.append(livro.getTitulo()).append(" - ").append(livro.getAutor()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(frame, lista.toString(), "Lista de Livros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cadastrarLivro() {
        String titulo = campoNomeLivro.getText();
        String autor = campoAutorLivro.getText();

        if (!titulo.isEmpty() && !autor.isEmpty()) {
            biblioteca.adicionarLivro(new Livro(titulo, autor)); // Instancia um novo Livro e adiciona à biblioteca
            JOptionPane.showMessageDialog(frame, "Livro cadastrado com sucesso!");
            campoNomeLivro.setText("");
            campoAutorLivro.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new InterfaceGUI(); // Inicia a interface gráfica
    }
}