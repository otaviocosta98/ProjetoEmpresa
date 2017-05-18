package br.com.contmatic.empresa;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The nome. */
    private String nome;

    /** The razao social. */
    private String razaoSocial;

    /** The ie. */
    private String IE;

    /** The cnpj. */
    private String CNPJ;

    /** The endereco. */
    private Set<Endereco> endereco;

    /** The telefone. */
    private Set<Telefone> telefone;

    /** The email. */
    private String email;

    /** The data inicio. */
    private DateTime dataInicio;

    /**
     * Instantiates a new empresa.
     */
    public Empresa() {

    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        Preconditions.checkNotNull(nome, "Nome não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(nome), "Nome não deve ser vazio", nome);
        this.nome = nome;
    }

    /**
     * Gets the razao social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Sets the razao social.
     *
     * @param razaoSocial the new razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        Preconditions.checkNotNull(razaoSocial, "Razão Social não deve ser nula");
        Preconditions.checkArgument(StringUtils.isNotEmpty(razaoSocial), "Razão Social não deve ser vazia", razaoSocial);
        Preconditions.checkArgument(razaoSocial.matches("[a-zA-Z0-9]+"), "Razão Social deve conter somente caracteres alfa-numericos", razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    /**
     * Gets the ie.
     *
     * @return the ie
     */
    public String getIE() {
        return IE;
    }

    /**
     * Sets the ie.
     *
     * @param iE the new ie
     */
    public void setIE(String iE) {
        Preconditions.checkNotNull(iE, "Inscrição Social não deve ser nula");
        Preconditions.checkArgument(StringUtils.isNotEmpty(iE), "Inscrição Social não deve ser vazia", iE);
        Preconditions.checkArgument(iE.matches("[0-9]+"), "Inscrição Social deve conter somente numeros", iE);
        Preconditions.checkArgument(iE.length() == 12, "Inscrição Social deve contem 12 digitos", iE);
        IE = iE;
    }

    /**
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * Sets the cnpj.
     *
     * @param cNPJ the new cnpj
     */
    public void setCNPJ(String cNPJ) {
        Preconditions.checkNotNull(cNPJ, "CNPJ não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(cNPJ), "CNPJ não deve ser vazia", cNPJ);
        Preconditions.checkArgument(cNPJ.matches("[0-9]+"), "CNPJ deve conter somente numeros", cNPJ);
        Preconditions.checkArgument(cNPJ.length() == 14, "CNPJ deve contem 14 digitos", cNPJ);
        CNPJ = cNPJ;
    }

    /**
     * Gets the endereco.
     *
     * @return the endereco
     */
    public Set<Endereco> getEndereco() {
        return endereco;
    }

    /**
     * Sets the endereco.
     *
     * @param endereco the new endereco
     */
    public void setEndereco(Set<Endereco> endereco) {
        Preconditions.checkNotNull(endereco, "Endereço não deve ser nulo");
        this.endereco = endereco;
    }

    /**
     * Gets the telefone.
     *
     * @return the telefone
     */
    public Set<Telefone> getTelefone() {
        return telefone;
    }

    /**
     * Sets the telefone.
     *
     * @param telefone the new telefone
     */
    public void setTelefone(Set<Telefone> telefone) {
        Preconditions.checkNotNull(telefone, "Telefone não deve ser nulo");
        this.telefone = telefone;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        Preconditions.checkNotNull(email, "Eamil não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(email), "Eamil não deve ser vazia", email);
        Preconditions.checkArgument(email.split("@").length == 2, "Email deve conter algo antes depois do arroba(@)", email);
        String[] aux = email.split("@");
        Preconditions.checkArgument(!aux[0].equals("") && aux[1].contains("."), "Email deve conter '.' depois do arroba(@)", email);
        this.email = email;
    }

    /**
     * Gets the data inicio.
     *
     * @return the data inicio
     */
    public DateTime getDataInicio() {
        return dataInicio;
    }

    /**
     * Sets the data inicio.
     *
     * @param dataInicio the new data inicio
     */
    public void setDataInicio(DateTime dataInicio) {
        Preconditions.checkArgument(dataInicio.isAfter(DateTime.now()), "Data de Início deve ser maior que hoje", dataInicio);
        this.dataInicio = dataInicio;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}
