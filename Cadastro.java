package ProjetoBiblioteca;

import java.util.Scanner;

public class Cadastro {

    Scanner scanner;

    public Cadastro() {
        this.scanner = new Scanner(System.in);
    }

    // Método para cadastrar um aluno
    public Usuario cadastroAluno() {
        try {
            System.out.println("=== Cadastro de Aluno ===");
            System.out.print("Digite a matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();

            Usuario aluno = new Usuario(matricula, nome, endereco, telefone);
            System.out.println("Aluno cadastrado com sucesso!");
            return aluno;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
            scanner.nextLine(); // Limpar entrada inválida
            return null;
        }
    }

    // Método para cadastrar um professor
    public Usuario cadastroProfessor() {
        try {
            System.out.println("=== Cadastro de Professor ===");
            System.out.print("Digite a matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();

            Usuario professor = new Usuario(matricula, nome, endereco, telefone);
            System.out.println("Professor cadastrado com sucesso!");
            return professor;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
            scanner.nextLine(); // Limpar entrada inválida
            return null;
        }
    }

    // Método para cadastrar um livro
    public livro cadastroLivro() {
        try {
            System.out.println("=== Cadastro de Livro ===");
            System.out.print("Digite o título: ");
            String titulo = scanner.nextLine();

            System.out.print("Digite o autor: ");
            String autor = scanner.nextLine();

            System.out.print("Digite o ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Digite o ano de publicação: ");
            int anoPublicacao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            System.out.print("Digite a editora: ");
            String editora = scanner.nextLine();

            System.out.print("Digite o número de exemplares: ");
            int numExemplares = scanner.nextInt();

            livro novoLivro = new livro(titulo, autor, isbn, anoPublicacao, editora, numExemplares);
            System.out.println("Livro cadastrado com sucesso!");
            return novoLivro;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
            scanner.nextLine(); // Limpar entrada inválida
            return null;
        }
    }

    // Método para cadastrar um funcionário
    public Usuario cadastroFuncionario() {
        try {
            System.out.println("=== Cadastro de Funcionário ===");
            System.out.print("Digite a matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();

            Usuario funcionario = new Usuario(matricula, nome, endereco, telefone);
            System.out.println("Funcionário cadastrado com sucesso!");
            return funcionario;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
            scanner.nextLine(); // Limpar entrada inválida
            return null;
        }
    }
}
