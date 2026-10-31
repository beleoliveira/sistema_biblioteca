package sistemabiblioteca;

public class TestarInsercao {
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.inserirLivro("Os Maias", "Eça de Queirós", "Romance", "Editora Exemplo", 1888, "Estante 2", 3);
    }
}