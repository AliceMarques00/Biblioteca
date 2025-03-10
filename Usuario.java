import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private Livro livroAlugado;
    private List<Item> itensAlugados = new ArrayList<>();

    public Usuario(String nome) {
        super(nome);
        this.livroAlugado = null;
    }

    public Livro getLivroAlugado() {
        return livroAlugado;
    }

    public void setLivroAlugado(Livro livroAlugado) {
        this.livroAlugado = livroAlugado;
    }

    public void alugarItem(Item item) {
        itensAlugados.add(item);
        System.out.println(getNome() + " alugou o item: " + item.getTitulo());
    }

    public void devolverItem() {
        if (!itensAlugados.isEmpty()) {
            itensAlugados.remove(itensAlugados.size() - 1);
            System.out.println("Item devolvido com sucesso!");
        } else {
            System.out.println("Nenhum item para devolver!");
        }
    }

    public void alugarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livroAlugado = livro;
            livro.setDisponivel(false);
            System.out.println(getNome() + " alugou o livro: " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível.");
        }
    }

    public void devolverLivro() {
        if (livroAlugado != null) {
            livroAlugado.setDisponivel(true);
            System.out.println(getNome() + " devolveu o livro: " + livroAlugado.getTitulo());
            livroAlugado = null;
        } else {
            System.out.println(getNome() + " não tem nenhum livro para devolver.");
        }
    }
}
