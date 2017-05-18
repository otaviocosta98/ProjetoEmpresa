package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class Endereco.
 */
public class Endereco {

    /** The logradouro. */
    private String logradouro;

    /** The numero. */
    private String numero;

    /** The complemento. */
    private String complemento;

    /** The estado. */
    private Estado estado;

    /** The cep. */
    private String cep;

    /** The regiao. */
    private RegiaoType regiao;

    /**
     * Gets the logradouro.
     *
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Sets the logradouro.
     *
     * @param logradouro the new logradouro
     */
    public void setLogradouro(String logradouro) {
        Preconditions.checkNotNull(logradouro, "Logradouro não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(logradouro), "Logradouro não deve ser vazio", logradouro);
        Preconditions.checkArgument(logradouro.matches("[a-zA-Z\b]+"), "Logradouro deve conter somente palavras", logradouro);
        this.logradouro = logradouro;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(String numero) {
        Preconditions.checkNotNull(numero, "Numero não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(numero), "Numero não deve ser vazio", numero);
        Preconditions.checkArgument(numero.matches("[0-9a-zA-Z]+"), "Numero deve ser somente alfa-numerico", numero);
        this.numero = numero;
    }

    /**
     * Gets the complemento.
     *
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Sets the complemento.
     *
     * @param complemento the new complemento
     */
    public void setComplemento(String complemento) {
        Preconditions.checkNotNull(complemento, "Complemento não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(complemento), "Complemento não deve ser vazio", complemento);
        Preconditions.checkArgument(complemento.matches("[0-9a-zA-Z]+"), "Complemento deve ser somente alfa-numerico", complemento);
        this.complemento = complemento;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param estado the new estado
     */
    public void setEstado(Estado estado) {
        Preconditions.checkNotNull(estado, "Estado não deve ser nulo");
        this.estado = estado;
    }

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Sets the cep.
     *
     * @param cep the new cep
     */
    public void setCep(String cep) {
        Preconditions.checkNotNull(cep, "CEP não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(cep), "CEP não deve ser vazio", cep);
        Preconditions.checkArgument(cep.matches("[0-9]+"), "CEP deve conter somente numeros", cep);
        Preconditions.checkArgument(cep.length() == 8, "CEP deve conter somente 8 digitos", cep);
        this.cep = cep;
    }

    /**
     * Gets the regiao.
     *
     * @return the regiao
     */
    public RegiaoType getRegiao() {
        return regiao;
    }

    /**
     * Sets the regiao.
     *
     * @param regiao the new regiao
     */
    public void setRegiao(RegiaoType regiao) {
        Preconditions.checkNotNull(regiao, "Região não deve ser nulo");
        this.regiao = regiao;
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
