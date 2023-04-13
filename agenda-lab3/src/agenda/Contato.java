package agenda;

import java.util.Objects;

public class Contato {
    private String nome;
    private String sobrenome;
    private String numeroTelefone;

    public Contato(String nome, String sobrenome, String numeroTelefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && sobrenome.equals(contato.sobrenome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                '}';
    }
}