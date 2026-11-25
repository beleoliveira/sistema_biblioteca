/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author giuli
 */
public class Livro {

    private int id;
    private String nomeLivro;
    private String nomeAutor;
    private String genero;
    private String editora;
    private int anoLivro;
    private String localizacao;
    private int quantidadeDisponivel;

    public Livro(int id, String nomeLivro, String nomeAutor, String genero, String editora, int anoLivro, String localizacao, int quantidadeDisponivel) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.genero = genero;
        this.editora = editora;
        this.anoLivro = anoLivro;
        this.localizacao = localizacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getId() {
        return id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getGenero() {
        return genero;
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoLivro() {
        return anoLivro;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
}
