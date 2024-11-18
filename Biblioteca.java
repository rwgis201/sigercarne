package ProjetoBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca extends JFrame {
    private ArrayList<livro> livros; // Lista de livros no acervo
    private HashMap<Integer, Usuario> usuarios; // Mapeia matrícula para o usuário
    private Map<String, String> logins = new HashMap<>(); // Usuários e suas senhas
    private List<String> livrosDisponiveis = new ArrayList<>(); // Lista de livros disponíveis
    private String usuarioLogado = null;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new HashMap<>();

        // Configuração básica da janela
        setTitle("Sistema de Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicia com alguns livros disponíveis
        livrosDisponiveis.add("O Senhor dos Anéis");
        livrosDisponiveis.add("1984");
        livrosDisponiveis.add("Dom Quixote");

        // Abre a tela de login
        abrirTelaLogin();
    }

    // Método para adicionar um livro ao acervo
    public void adicionarLivro(livro novoLivro) {
        livros.add(novoLivro);
        System.out.println("Livro adicionado ao acervo: " + novoLivro.getTitulo());
    }

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(Usuario novoUsuario) {
        if (usuarios.containsKey(novoUsuario.getMatricula())) {
            System.out.println("Usuário com matrícula " + novoUsuario.getMatricula() + " já está cadastrado.");
        } else {
            usuarios.put(novoUsuario.getMatricula(), novoUsuario);
            System.out.println("Usuário cadastrado com sucesso: " + novoUsuario.getNome());
        }
    }

    // Método para realizar empréstimo de um livro
    public void emprestarLivro(int matriculaUsuario, String tituloLivro) {
        Usuario usuario = usuarios.get(matriculaUsuario);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        for (livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(tituloLivro)) {
                l.emprestar();
                return;
            }
        }
        System.out.println("Livro não encontrado no acervo.");
    }

    // Método para devolver um livro
    public void devolverLivro(String tituloLivro) {
        for (livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(tituloLivro)) {
                l.devolver();
                return;
            }
        }
        System.out.println("Livro não encontrado no acervo.");
    }

    // Método para exibir todos os livros
    public void listarLivros() {
        System.out.println("Lista de Livros no Acervo:");
        for (livro l : livros) {
            System.out.println("- " + l.getTitulo() + " (Disponíveis: " + l.getNumExemplaresDisponiveis() + ")");
        }
    }

    // Método para listar todos os usuários cadastrados
    public void listarUsuarios() {
        System.out.println("Lista de Usuários Cadastrados:");
        for (Usuario u : usuarios.values()) {
            System.out.println("- " + u.getNome() + " (Matrícula: " + u.getMatricula() + ")");
        }
    }

    private void abrirTelaLogin() {
        getContentPane().removeAll();
        setLayout(new GridLayout(4, 2));

        JLabel lblUsuario = new JLabel("Usuário:");
        JTextField txtUsuario = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnCadastro = new JButton("Cadastro");

        add(lblUsuario);
        add(txtUsuario);
        add(lblSenha);
        add(txtSenha);
        add(btnLogin);
        add(btnCadastro);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (logins.containsKey(usuario) && logins.get(usuario).equals(senha)) {
                    usuarioLogado = usuario;
                    abrirTelaPrincipal();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                }
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        revalidate();
        repaint();
    }

    private void abrirTelaCadastro() {
        getContentPane().removeAll();
        setLayout(new GridLayout(4, 1, 10, 10)); // Layout para os botões

        JButton botaoCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        JButton botaoAdicionarLivro = new JButton("Adicionar Livro");
        JButton botaoVoltar = new JButton("Voltar");

        add(botaoCadastrarFuncionario);
        add(botaoAdicionarLivro);
        add(botaoVoltar);

        botaoCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroFuncionario();
            }
        });

        botaoAdicionarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaAdicionarLivro();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin(); // Volta para a tela de login
            }
        });

        revalidate();
        repaint();
    }

    private void abrirTelaCadastroFuncionario() {
        // Lógica para cadastrar funcionário
        getContentPane().removeAll();
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblMatricula = new JLabel("Matrícula:");
        JTextField txtMatricula = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField();
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int matricula = Integer.parseInt(txtMatricula.getText());
                    String nome = txtNome.getText();
                    String endereco = txtEndereco.getText();
                    String telefone = txtTelefone.getText();
                    String senha = new String(txtSenha.getPassword());

                    Usuario novoFuncionario = new Usuario(matricula, nome, endereco, telefone);
                    cadastrarUsuario(novoFuncionario);
                    logins.put(nome, senha); // Armazena login e senha

                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                    // Limpar os campos após o cadastro
                    txtMatricula.setText("");
                    txtNome.setText("");
                    txtEndereco.setText("");
                    txtTelefone.setText("");
                    txtSenha.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Matrícula inválida. Digite um número inteiro.");
                }
            }
        });

        add(lblMatricula);
        add(txtMatricula);
        add(lblNome);
        add(txtNome);
        add(lblEndereco);
        add(txtEndereco);
        add(lblTelefone);
        add(txtTelefone);
        add(lblSenha);
        add(txtSenha);
        add(new JLabel()); // Espaço vazio
        add(btnCadastrar);

        revalidate();
        repaint();
    }


    private void abrirTelaAdicionarLivro() {
        // Lógica para adicionar livro
        getContentPane().removeAll();
        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblTitulo = new JLabel("Título:");
        JTextField txtTitulo = new JTextField();
        JLabel lblAutor = new JLabel("Autor:");
        JTextField txtAutor = new JTextField();
        JLabel lblIsbn = new JLabel("ISBN:");
        JTextField txtIsbn = new JTextField();
        JLabel lblAnoPublicacao = new JLabel("Ano de Publicação:");
        JTextField txtAnoPublicacao = new JTextField();
        JLabel lblEditora = new JLabel("Editora:");
        JTextField txtEditora = new JTextField();
        JLabel lblNumExemplares = new JLabel("Número de Exemplares:");
        JTextField txtNumExemplares = new JTextField();

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = txtTitulo.getText();
                    String autor = txtAutor.getText();
                    String isbn = txtIsbn.getText();
                    int anoPublicacao = Integer.parseInt(txtAnoPublicacao.getText());
                    String editora = txtEditora.getText();
                    int numExemplares = Integer.parseInt(txtNumExemplares.getText());

                    livro novoLivro = new livro(titulo, autor, isbn, anoPublicacao, editora, numExemplares);
                    adicionarLivro(novoLivro);

                    JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                    // Limpar os campos após adicionar
                    txtTitulo.setText("");
                    txtAutor.setText("");
                    txtIsbn.setText("");
                    txtAnoPublicacao.setText("");
                    txtEditora.setText("");
                    txtNumExemplares.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ano de publicação e número de exemplares devem ser números inteiros.");
                }
            }
        });

        add(lblTitulo);
        add(txtTitulo);
        add(lblAutor);
        add(txtAutor);
        add(lblIsbn);
        add(txtIsbn);
        add(lblAnoPublicacao);
        add(txtAnoPublicacao);
        add(lblEditora);
        add(txtEditora);
        add(lblNumExemplares);
        add(txtNumExemplares);
        add(new JLabel()); // Espaço vazio
        add(btnAdicionar);

        revalidate();
        repaint();
    }

    private void abrirTelaPrincipal() {
        getContentPane().removeAll();
        setLayout(new GridLayout(6, 1, 10, 10)); // Layout para os botões

        JLabel lblBemVindo = new JLabel("Bem-vindo(a) à Biblioteca!", SwingConstants.CENTER);
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton botaoEmprestarLivro = new JButton("Emprestar Livro");
        JButton botaoDevolverLivro = new JButton("Devolver Livro");
        JButton botaoListarLivros = new JButton("Listar Livros");
        JButton botaoListarUsuarios = new JButton("Listar Usuários");
        JButton botaoSair = new JButton("Sair");

        add(lblBemVindo);
        add(botaoEmprestarLivro);
        add(botaoDevolverLivro);
        add(botaoListarLivros);
        add(botaoListarUsuarios);
        add(botaoSair);

        botaoEmprestarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para emprestar livro
                JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada.");
            }
        });

        botaoDevolverLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para devolver livro
                JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada.");
            }
        });

        botaoListarLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLivros();
            }
        });

        botaoListarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Biblioteca();
    }
}