package br.com.contmatic.empresa;

public class Bairro {

    private String codigo;
    private String nome;
    private String tipo;
    private String tamanho;
    private Cidade cidade;
    private Estado estado;
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Bairro [codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", tamanho=" + tamanho + ", cidade=" + cidade + ", estado=" + estado + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (tamanho == null) {
            if (other.tamanho != null)
                return false;
        } else if (!tamanho.equals(other.tamanho))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }
    
    
}
