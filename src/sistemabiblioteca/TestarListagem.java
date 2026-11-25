/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;
import java.util.List;
/**
 *
 * @author giuli
 */
public class TestarListagem {
    
    public static void main(String[] args){
        
        LivroDAO dao = new LivroDAO();

        List<Livro> livros = dao.listarLivros();

        for (Livro livro : livros) {

            System.out.println("ID: " + livro.getId());
            System.out.println("Livro: " + livro.getNomeLivro());
            System.out.println("Autor: " + livro.getNomeAutor());
            System.out.println("----------------------");

        }
    }
}
