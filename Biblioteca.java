import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;
    private ArrayList<Revista> revistas;

    public Biblioteca() {
        usuarios = new ArrayList<Usuario>();
        revistas = new ArrayList<Revista>();
        livros = new ArrayList<Livro>();
    }

    public Item buscarItem(String titulo) {
        ArrayList<Item> itens = new ArrayList<Item>();
        itens.addAll(livros);
        itens.addAll(revistas);
        for (Item item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        //System.out.println("Livro adicionando: " + livro.getTitulo());
    }

    public void adicionarUsuarios(Usuario usuario) {
        usuarios.add(usuario);
        //System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    public void adicionarItem(Revista revista) {
        revistas.add(revista);
        //System.out.println("Revista adicionada: " + revista.getTitulo());
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro: livros){
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario: usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }
}
