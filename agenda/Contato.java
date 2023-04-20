package agenda;

import java.util.Objects;

public class Contato {

    private String nome;

    private String sobrenome;

    private String telefone;

    public Contato(String nome, String sobrenome, String numeroTelefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public String getTelefone(){
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && sobrenome.equals(contato.sobrenome);
    }

    public String toString() {
        return this.nome + " " + this.sobrenome + "\n" + this.telefone;
    }
}