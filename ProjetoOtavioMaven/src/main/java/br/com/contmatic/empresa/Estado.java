package br.com.contmatic.empresa;

import java.util.Arrays;

public class Estado {
    private String codigo;
    private String nome;
    private String uf;
    private String tamanho;
    private String populacao;
    private Cidade[] cidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !"".equals(codigo) && codigo.matches("[0-9]+")) {
            this.codigo = codigo;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !"".equals(nome) && nome.matches("[^0-9]+")) {
            this.nome = nome;
        }
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        if (uf != null && !"".equals(uf)) {
            if (uf.matches("[A-Z]+") && uf.length() == 2) {
                this.uf = uf;
            }
        }
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        if (tamanho != null && !"".equals(tamanho) && tamanho.matches("[0-9]+")) {
            this.tamanho = tamanho;
        }
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        if (populacao != null && !"".equals(populacao) && populacao.matches("[0-9]+")) {
            this.populacao = populacao;
        }
    }

    public Cidade[] getCidade() {
        return cidade;
    }

    public void setCidade(Cidade[] cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Estado [codigo=" + codigo + ", nome=" + nome + ", uf=" + uf + ", tamanho=" + tamanho + ", populacao=" + populacao + ", cidade=" + Arrays.toString(cidade) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Estado other = (Estado) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
