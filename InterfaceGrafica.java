package ProjetoBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {

    private Cadastro cadastro;
    private Biblioteca biblioteca; // Instância da classe Biblioteca

    public InterfaceGrafica(Biblioteca biblioteca) {
        super("Sistema de Biblioteca");
        this.biblioteca = biblioteca; // Associa a instância da Biblioteca
        cadastro = new Cadastro();

        // Configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        add(painelPrincipal);

        // Título
        JLabel titulo = new JLabel("Biblioteca Unifor", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 1, 10, 10)); // 2 botões em vez de 3
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        // Botões
        JButton botaoCadastro = new JButton("Cadastro");
        JButton botaoSair = new JButton("Sair");

        // Adicionar botões ao painel
        painelBotoes.add(botaoCadastro);
        painelBotoes.add(botaoSair);

        // Ações dos botões
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Método para abrir a tela de cadastro
    private void abrirTelaCadastro() {
        getContentPane().removeAll();
        setLayout(new GridBagLayout()); // Mudança para GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre componentes

        // Labels e campos de texto
        JLabel lblTipoUsuario = new JLabel("Tipo de Usuário:");
        JComboBox<String> comboTipoUsuario = new JComboBox<>(new String[]{"Aluno", "Professor", "Funcionário"});
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alinhamento à esquerda
        add(lblTipoUsuario, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preencher horizontalmente
        add(comboTipoUsuario, gbc);

        JLabel lblMatricula = new JLabel("Matrícula:");
        JTextField txtMatricula = new JTextField();
        txtMatricula.setPreferredSize(new Dimension(150, 25)); // Tamanho do campo
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblMatricula, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtMatricula, gbc);

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        txtNome.setPreferredSize(new Dimension(150, 25)); // Tamanho do campo
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblNome, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNome, gbc);

        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField();
        txtEndereco.setPreferredSize(new Dimension(150, 25)); // Tamanho do campo
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblEndereco, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtEndereco, gbc);

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();
        txtTelefone.setPreferredSize(new Dimension(150, 25)); // Tamanho do campo
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblTelefone, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTelefone, gbc);

        // Botão de cadastro
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margens no botão
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14)); // Fonte do botão
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST; // Alinhamento à direita
        add(btnCadastrar, gbc);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int matricula = Integer.parseInt(txtMatricula.getText());
                    String nome = txtNome.getText();
                    String endereco = txtEndereco.getText();
                    String telefone = txtTelefone.getText();

                    Usuario novoUsuario = new Usuario(matricula, nome, endereco, telefone);
                    biblioteca.cadastrarUsuario(novoUsuario); // Cadastra o usuário na Biblioteca

                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    // Limpar os campos após o cadastro
                    txtMatricula.setText("");
                    txtNome.setText("");
                    txtEndereco.setText("");
                    txtTelefone.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Matrícula inválida. Digite um número inteiro.");
                }
            }
        });

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(); // Cria uma instância da Biblioteca
        new InterfaceGrafica(biblioteca); // Passa a instância para a InterfaceGrafica
    }
}