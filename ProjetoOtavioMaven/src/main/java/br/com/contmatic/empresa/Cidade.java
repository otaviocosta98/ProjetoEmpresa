package br.com.contmatic.empresa;

import java.util.Arrays;

public class Cidade {
    private String codigo;
    private String nome;
    private String tamanho;
    private String populacao;
    private Bairro[] bairro;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && codigo != "" && codigo.matches("[0-9]+")) {
            this.codigo = codigo;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome != "" && nome.matches("[^0-9]+")) {
            this.nome = nome;
        }
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        if (tamanho != null && tamanho != "" && tamanho.matches("[0-9]+")) {
            this.tamanho = tamanho;
        }
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        if (populacao != null && populacao != "" && populacao.matches("[0-9]+")) {
            this.populacao = populacao;
        }
    }

    public Bairro[] getBairro() {
        return bairro;
    }

    public void setBairro(Bairro[] bairro) {
        if (bairro != null) {
            this.bairro = bairro;
        }
    }

    @Override
    public String toString() {
        return "Cidade [codigo=" + codigo + ", nome=" + nome + ", tamanho=" + tamanho + ", populacao=" + populacao + ", bairro=" + Arrays.toString(bairro) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(bairro);
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((populacao == null) ? 0 : populacao.hashCode());
        result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cidade other = (Cidade) obj;
        if (!Arrays.equals(bairro, other.bairro))
            return false;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (populacao == null) {
            if (other.populacao != null)
                return false;
        } else if (!populacao.equals(other.populacao))
            return false;
        if (tamanho == null) {
            if (other.tamanho != null)
                return false;
        } else if (!tamanho.equals(other.tamanho))
            return false;
        return true;
    }

}
