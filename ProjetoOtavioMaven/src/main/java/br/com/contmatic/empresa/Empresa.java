package br.com.contmatic.empresa;

import java.util.Arrays;
import java.util.Date;

public class Empresa {

    private String nome;
    private String razaoSocial;
    private String IE;
    private String CNPJ;
    private Endereco[] endereco;
    private Telefone[] telefone;
    private String email;
    private Date dataInicio;

    public Empresa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !"".equals(nome)) {
            this.nome = nome;
        }
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        if (razaoSocial != null && !"".equals(razaoSocial) && razaoSocial.matches("[a-zA-Z0-9]+")) {
            this.razaoSocial = razaoSocial;
        }
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String iE) {
        if (iE != null && !"".equals(iE)) {
            if (iE.length() == 12 && iE.matches("[0-9]+")) {
                IE = iE;
            }
        }
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        if (cNPJ != null && !"".equals(cNPJ)) {
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
        if (email != null && !"".equals(email)) {
            if (email.split("@").length == 2) {
                String[] aux = email.split("@");
                if (!aux[0].equals("") && aux[1].contains(".")) {
                    this.email = email;
                }
            }
        }
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        Date data = new Date(1494439457167L);/* 10/05/2017 */
        if (dataInicio.after(data)) {
            this.dataInicio = dataInicio;
        }
    }

    @Override
    public String toString() {
        return "Empresa [nome=" + nome + ", razaoSocial=" + razaoSocial + ", IE=" + IE + ", CNPJ=" + CNPJ + ", endereco=" + Arrays.toString(endereco) + ", telefone=" + Arrays.toString(telefone) +
            ", email=" + email + ", dataInicio=" + dataInicio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        } else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        return true;
    }

}
