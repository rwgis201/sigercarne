package ProjetoBiblioteca;

public class periodico extends Imprimivel {
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;

    public periodico(String titulo, String autor, String editora, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public void PeriodicoLeitura(String titulo, String autor, int anopublicacap){


    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Ano de Publicação: " + anoPublicacao);
    }
}

