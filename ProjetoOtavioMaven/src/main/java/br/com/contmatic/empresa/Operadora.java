package br.com.contmatic.empresa;

public class Operadora {
    private String codigo;
    private String nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null) {
            if (!"".equals(codigo) && codigo.matches("[0-9]+")) {
                this.codigo = codigo;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !"".equals(nome)) {
            this.nome = nome;
        }
    }

    @Override
    public String toString() {
        return "Operadora [cod=" + codigo + ", nome=" + nome + "]";
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
        Operadora other = (Operadora) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
