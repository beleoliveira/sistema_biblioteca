package sistemabiblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:5432/postgres";
    private static final String USUARIO = "postgres.ysmescvrwtfdrxhdltch";
    private static final String SENHA = "bibliotecaa3010202";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Ligação à base de dados efetuada com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro detalhado ao ligar à base de dados:");
            e.printStackTrace(); // Isto vai mostrar o erro exato na consola
            return null;
        }
    }
}