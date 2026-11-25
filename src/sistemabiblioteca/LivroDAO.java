package sistemabiblioteca;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    public boolean inserirLivro(String nomeLivro, String nomeAutor, String genero, String editora, int anoLivro, String localizacao, int quantidadeDisponivel) {
        String sql = "INSERT INTO livros (nome_livro, nome_autor, genero, editora, ano_livro, localizacao, quantidade_disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar()) {

            if (conn == null) {
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, nomeLivro);
                stmt.setString(2, nomeAutor);
                stmt.setString(3, genero);
                stmt.setString(4, editora);
                stmt.setInt(5, anoLivro);
                stmt.setString(6, localizacao);
                stmt.setInt(7, quantidadeDisponivel);

                stmt.executeUpdate();
                System.out.println("Livro inserido com sucesso na base de dados local!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o livro: " + e.getMessage());
            return false;
        }
    }

    public List<Livro> listarLivros() {

        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livros ORDER BY id";

        try (Connection conn = Conexao.conectar()) {

            if (conn == null) {
                return livros;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Livro livro = new Livro(
                            rs.getInt("id"),
                            rs.getString("nome_livro"),
                            rs.getString("nome_autor"),
                            rs.getString("genero"),
                            rs.getString("editora"),
                            rs.getInt("ano_livro"),
                            rs.getString("localizacao"),
                            rs.getInt("quantidade_disponivel")
                    );

                    livros.add(livro);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }

        return livros;
    }

    public Livro buscarLivroPorId(int id) {

        String sql = "SELECT * FROM livros WHERE id = ?";

        try (Connection conn = Conexao.conectar()) {

            if (conn == null) {
                return null;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {

                    if (rs.next()) {

                        return new Livro(
                                rs.getInt("id"),
                                rs.getString("nome_livro"),
                                rs.getString("nome_autor"),
                                rs.getString("genero"),
                                rs.getString("editora"),
                                rs.getInt("ano_livro"),
                                rs.getString("localizacao"),
                                rs.getInt("quantidade_disponivel")
                        );
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizarLivro(Livro livro) {

        String sql = "UPDATE livros SET "
                + "nome_livro = ?, "
                + "nome_autor = ?, "
                + "genero = ?, "
                + "editora = ?, "
                + "ano_livro = ?, "
                + "localizacao = ?, "
                + "quantidade_disponivel = ? "
                + "WHERE id = ?";

        try (Connection conn = Conexao.conectar()) {

            if (conn == null) {
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, livro.getNomeLivro());
                stmt.setString(2, livro.getNomeAutor());
                stmt.setString(3, livro.getGenero());
                stmt.setString(4, livro.getEditora());
                stmt.setInt(5, livro.getAnoLivro());
                stmt.setString(6, livro.getLocalizacao());
                stmt.setInt(7, livro.getQuantidadeDisponivel());
                stmt.setInt(8, livro.getId());

                return stmt.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
            return false;
        }
    }
}
