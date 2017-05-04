package br.com.contmatic.empresa;

import java.util.Arrays;

public class Empresa {

    private String nome;
    private String razaoSocial;
    private String IE;
    private String CNPJ;
    private Endereco[] endereco;
    private Telefone[] telefone;
    private String email;

    public Empresa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome != "") {
            this.nome = nome;
        }
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        if (razaoSocial != null && razaoSocial != "" && razaoSocial.matches("[a-zA-Z0-9]+")) {
            this.razaoSocial = razaoSocial;
        }
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String iE) {
        if (iE != null && iE != "") {
            if (iE.length() == 12 && iE.matches("[0-9]+")) {
                IE = iE;
            }
        }
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        if (cNPJ != null && cNPJ != "") {
            if (cNPJ.length() == 14 && cNPJ.matches("[0-9]+")) {
                CNPJ = cNPJ;
            }
        }
    }

    public Endereco[] getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco[] endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        }
    }

    public Telefone[] getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone[] telefone) {
        if (telefone != null) {
            this.telefone = telefone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email != "") {
            if (email.split("@").length == 2) {
                String[] aux = email.split("@");
                if (!aux[0].equals("") && aux[1].contains(".")) {
                    this.email = email;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Empresa [nome=" + nome + ", razaoSocial=" + razaoSocial + ", IE=" + IE + ", CNPJ=" + CNPJ + ", endereco=" + Arrays.toString(endereco) + ", telefone=" + Arrays.toString(telefone) +
            ", email=" + email + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
        result = prime * result + ((IE == null) ? 0 : IE.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + Arrays.hashCode(endereco);
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
        result = prime * result + Arrays.hashCode(telefone);
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
        Empresa other = (Empresa) obj;
        if (CNPJ == null) {
            if (other.CNPJ != null)
                return false;
        } else if (!CNPJ.equals(other.CNPJ))
            return false;
        if (IE == null) {
            if (other.IE != null)
                return false;
        } else if (!IE.equals(other.IE))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (!Arrays.equals(endereco, other.endereco))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        } else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        if (!Arrays.equals(telefone, other.telefone))
            return false;
        return true;
    }

}
