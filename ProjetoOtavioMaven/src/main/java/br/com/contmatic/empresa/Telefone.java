package br.com.contmatic.empresa;

public class Telefone {
    private String ddd;
    private String numero;
    private String ramal;
    private String tipo;
    private String responsavel;
    private Operadora operadora;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        if (ddd != null) {
            if (ddd != "" && ddd.matches("[0-9]+") && ddd.length() == 2) {
                this.ddd = ddd;
            }
        }
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        if (ramal == "") {
            this.ramal = ramal;
        } else if (ramal != null && ramal.matches("[0-9]+")) {
            this.ramal = ramal;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero != null) {
            if (numero != "" & numero.matches("[0-9]+")) {
                if (numero.length() >= 8 && numero.length() <= 9) {
                    this.numero = numero;
                }
            }
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo != null && tipo != "" && tipo.matches("[a-zA-Z]+")) {
            this.tipo = tipo;
        }
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        if (responsavel != null && responsavel != "" && responsavel.matches("[a-zA-Z]+")) {
            this.responsavel = responsavel;
        }
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        if (operadora != null) {
            this.operadora = operadora;
        }
    }

    @Override
    public String toString() {
        return "Telefone [ddd=" + ddd + ", numero=" + numero + ", ramal=" + ramal + ", tipo=" + tipo + ", responsavel=" + responsavel + ", operadora=" + operadora + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((operadora == null) ? 0 : operadora.hashCode());
        result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
        result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
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
        Telefone other = (Telefone) obj;
        if (ddd == null) {
            if (other.ddd != null)
                return false;
        } else if (!ddd.equals(other.ddd))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (operadora == null) {
            if (other.operadora != null)
                return false;
        } else if (!operadora.equals(other.operadora))
            return false;
        if (ramal == null) {
            if (other.ramal != null)
                return false;
        } else if (!ramal.equals(other.ramal))
            return false;
        if (responsavel == null) {
            if (other.responsavel != null)
                return false;
        } else if (!responsavel.equals(other.responsavel))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }

}
