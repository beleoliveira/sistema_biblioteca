package sistemabiblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    public boolean inserirLivro(String nomeLivro, String nomeAutor, String genero, String editora, int anoLivro, String localizacao, int quantidadeDisponivel) {
        String sql = "INSERT INTO livros (nome_livro, nome_autor, genero, editora, ano_livro, localizacao, quantidade_disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar()){
                
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
}