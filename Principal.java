package ProjetoBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    private Biblioteca biblioteca;

    public Principal() {
        super("Sistema de Biblioteca");
        biblioteca = new Biblioteca();

        // Configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        add(painelPrincipal);

        // Título
        JLabel titulo = new JLabel("Biblioteca Unifor", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel de abas
        JTabbedPane abas = new JTabbedPane();
        painelPrincipal.add(abas, BorderLayout.CENTER);

        // Aba de Cadastro
        JPanel abaCadastro = new JPanel();
        abaCadastro.setLayout(new GridLayout(5, 1, 10, 10));
        abas.addTab("Cadastro", abaCadastro);

        JButton botaoCadastrarAluno = new JButton("Cadastrar Aluno");
        JButton botaoCadastrarProfessor = new JButton("Cadastrar Professor");
        JButton botaoCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        JButton botaoCadastrarLivro = new JButton("Cadastrar Livro");
        abaCadastro.add(botaoCadastrarAluno);
        abaCadastro.add(botaoCadastrarProfessor);
        abaCadastro.add(botaoCadastrarFuncionario);
        abaCadastro.add(botaoCadastrarLivro);

        // Ações dos botões de cadastro
        botaoCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroUsuario("Aluno");
            }
        });
        // ... (ActionListeners para os outros botões de cadastro)

        // Aba de Pesquisa
        JPanel abaPesquisa = new JPanel();
        abas.addTab("Pesquisa", abaPesquisa);
        // ... (implementar a interface de pesquisa)

        // Aba de Empréstimo
        JPanel abaEmprestimo = new JPanel();
        abas.addTab("Empréstimo", abaEmprestimo);
        // ... (implementar a interface de empréstimo)

        // Aba de Devolução
        JPanel abaDevolucao = new JPanel();
        abas.addTab("Devolução", abaDevolucao);
        // ... (implementar a interface de devolução)

        setVisible(true);
    }

    // Método para abrir a tela de cadastro de usuário (Aluno, Professor, Funcionário)
    private void abrirTelaCadastroUsuario(String tipoUsuario) {
        // ... (implementar a lógica de cadastro de usuário,
        //      adaptando o código da classe InterfaceGrafica)
    }

    // ... (métodos para abrir as telas de cadastro de livro,
    //      pesquisa, empréstimo e devolução)

    public static void main(String[] args) {
        new Principal();
    }
}