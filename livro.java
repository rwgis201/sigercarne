package ProjetoBiblioteca;

import java.util.ArrayList;

public class livro implements Emprestavel, Acervo {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private String editora;
    private int numExemplares;
    private int numExemplaresDisponiveis;

    public livro(String titulo, String autor, String isbn, int anoPublicacao, String editora, int numExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.numExemplares = numExemplares;
        this.numExemplaresDisponiveis = numExemplares;
    }

    public void emprestar() {
        if (numExemplaresDisponiveis > 0) {
            numExemplaresDisponiveis--;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Não há exemplares disponíveis para empréstimo.");
        }
    }

    public void devolver() {
        if (numExemplaresDisponiveis < numExemplares) {
            numExemplaresDisponiveis++;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Todos os exemplares já estão disponíveis.");
        }
    }

    public void pesquisar(String termo) {
        if (titulo.contains(termo) || autor.contains(termo)) {
            System.out.println("Livro encontrado: " + titulo);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    @Override
    public void emprestavel() {
        System.out.println("Este livro está disponível para empréstimo.");
    }

    @Override
    public void localizacao() {
        System.out.println("Localização: Seção de livros.");
    }

    public String getNumExemplaresDisponiveis() {
        return numExemplaresDisponiveis + "";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }
}
