public class Revista extends Item {
    private String editora;

    public Revista(String titulo, String editora) {
        super(titulo);
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Revista{" +
                "titulo='" + getTitulo() + '\'' +
                ", editora='" + editora + '\'' +
                ", disponivel=" + isDisponivel() +
                '}';
    }
}
