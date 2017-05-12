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
            if (!"".equals(ddd) && ddd.matches("[0-9]+") && ddd.length() == 2) {
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
            if (!"".equals(numero) & numero.matches("[0-9]+")) {
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
        if (tipo != null && !"".equals(tipo) && tipo.matches("[a-zA-Z]+")) {
            this.tipo = tipo;
        }
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        if (responsavel != null && !"".equals(responsavel) && responsavel.matches("[a-zA-Z]+")) {
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
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

}
