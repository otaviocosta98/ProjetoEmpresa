package br.com.contmatic.empresa;

public class Bairro {

    private String codigo;
    private String nome;
    private String tipo;
    private String tamanho;
    private String populacao;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo != null && !"".equals(tipo) && tipo.matches("[^0-9]+")) {
            this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Bairro [codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", tamanho=" + tamanho + ", populacao=" + populacao + "]";
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
        Bairro other = (Bairro) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
