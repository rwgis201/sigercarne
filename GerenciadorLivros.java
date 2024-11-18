package ProjetoBiblioteca;

import java.util.ArrayList;

public class GerenciadorLivros {
    private ArrayList<livro> livros;

    public GerenciadorLivros() {
        this.livros = new ArrayList<>();
    }

    // Método para adicionar um livro ao acervo
    public void adicionarLivro(livro novoLivro) {
        livros.add(novoLivro);
        System.out.println("Livro adicionado ao acervo: " + novoLivro.getTitulo());
    }

    // Método para remover um livro do acervo
    public void removerLivro(String titulo) {
        for (livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(l);
                System.out.println("Livro removido do acervo: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado: " + titulo);
    }

    // Método para listar todos os livros no acervo
    public void listarLivros() {
        System.out.println("=== Lista de Livros no Acervo ===");
        for (livro l : livros) {
            System.out.println("- " + l.getTitulo() + " (Disponíveis: " + l.getNumExemplaresDisponiveis() + ")");
        }
    }

    // Método para pesquisar um livro pelo título
    public void pesquisarLivro(String titulo) {
        for (livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Livro encontrado:");
                System.out.println("Título: " + l.getTitulo());
                System.out.println("Autor: " + l.getAutor());
                System.out.println("Editora: " + l.getEditora());
                return;
            }
        }
        System.out.println("Livro não encontrado: " + titulo);
    }

    // Método para verificar a disponibilidade de um livro
    public void verificarDisponibilidade(String titulo) {
        for (livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Disponíveis: " + l.getNumExemplaresDisponiveis());
                return;
            }
        }
        System.out.println("Livro não encontrado: " + titulo);
    }
}




