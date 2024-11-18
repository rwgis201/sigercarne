package ProjetoBiblioteca;

import java.util.ArrayList;

public class Relatorio {


    public void gerarRelatorioDevolucoes(ArrayList<livro> livros){
        System.out.println("Relatório de Devolucoes:");
        for (livro l : livros) {
            System.out.println("Título: " + l.getTitulo() + ", Disponíveis: " + l.getNumExemplaresDisponiveis());
        }
    }
    public void gerarRelatorioEmprestimos(ArrayList<livro> livros) {
        System.out.println("Relatório de Empréstimos:");
        for (livro l : livros) {
            System.out.println("Título: " + l.getTitulo() + ", Disponíveis: " + l.getNumExemplaresDisponiveis());
        }
    }
}

