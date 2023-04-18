package agenda;

import java.util.Objects;

public class Contato {

    private String nome;

    private String sobrenome;

    private String numeroTelefone;

    private boolean favorito;

    public Contato(String nome, String sobrenome, String numeroTelefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroTelefone = numeroTelefone;
        this.favorito = false;
    }

    public favoritar() {
        this.favorito = true;
    }

    public desfavoritar(){
        this.favorito = false;
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public boolean getFavorito(){
        return favorito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && sobrenome.equals(contato.sobrenome);
    }

    @Override
    public String toString() {
        if favorito{
            return "❤️ " + this.nome + " " + this.sobrenome + "\n" + this.telefone;
        }
        return this.nome + " " + this.sobrenome + "\n" + this.telefone;
    }
}