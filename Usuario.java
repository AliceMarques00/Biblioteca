import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private List<Item> itensAlugados = new ArrayList<>();

    public Usuario(String nome) {
        super(nome);
    }

    public void alugarItem(Item item) {
        if (!itensAlugados.isEmpty()) {
            System.out.println("Por favor, devolva o livro antes de alugar outro.");
            return;
        }

        if (item.isDisponivel()) {
            itensAlugados.add(item);
            item.setDisponivel(false);
            System.out.println(getNome() + " alugou o livro: " + item.getTitulo());
        } else {
            System.out.println("O livro " + item.getTitulo() + " não está disponível.");
        }
    }

    public void devolverItem(Item item) {
        if (itensAlugados.contains(item)) {
            itensAlugados.remove(item);
            item.setDisponivel(true);
            System.out.println(getNome() + " devolveu o livro: " + item.getTitulo());
        } else {
            System.out.println(getNome() + " não tem este livro para devolver.");
        }
    }

    public boolean possuiLivroAlugado() {
        return !itensAlugados.isEmpty();
    }
}
