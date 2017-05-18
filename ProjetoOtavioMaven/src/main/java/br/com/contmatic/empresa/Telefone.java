package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class Telefone.
 */
public class Telefone {

    /** The ddd. */
    private String ddd;

    /** The numero. */
    private String numero;

    /** The ramal. */
    private String ramal;

    /** The tipo. */
    private TelefoneType tipo;

    /** The responsavel. */
    private String responsavel;

    /** The operadora. */
    private Operadora operadora;

    /**
     * Gets the ddd.
     *
     * @return the ddd
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * Sets the ddd.
     *
     * @param ddd the new ddd
     */
    public void setDdd(String ddd) {
        Preconditions.checkNotNull(ddd, "DDD não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNoneEmpty(ddd), "DDD não deve ser vazio", ddd);
        Preconditions.checkArgument(ddd.matches("[0-9]+"), "DDD deve conter somente numeros", ddd);
        Preconditions.checkArgument(ddd.length() == 2, "DDD deve conter somente 2 digitos", ddd);
        this.ddd = ddd;
    }

    /**
     * Gets the ramal.
     *
     * @return the ramal
     */
    public String getRamal() {
        return ramal;
    }

    /**
     * Sets the ramal.
     *
     * @param ramal the new ramal
     */
    public void setRamal(String ramal) {
        Preconditions.checkNotNull(ramal, "Ramal não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isEmpty(ramal) || ramal.matches("[0-9]+"), "Ramal deve ser vazio ou conter somento numeros", ramal);
        this.ramal = ramal;
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
        Preconditions.checkArgument(StringUtils.isNoneEmpty(numero), "Numero não deve ser vazio", numero);
        Preconditions.checkArgument(numero.matches("[0-9]+"), "Numero deve conter somente numeros", numero);
        Preconditions.checkArgument(numero.length() == getTipo().getTamanho(), "Quantidade de digitos incorretos para o tipo de telefone informado", numero);
        this.numero = numero;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public TelefoneType getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(TelefoneType tipo) {
        Preconditions.checkNotNull(tipo, "Tipo não deve ser nulo");
        this.tipo = tipo;
    }

    /**
     * Gets the responsavel.
     *
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * Sets the responsavel.
     *
     * @param responsavel the new responsavel
     */
    public void setResponsavel(String responsavel) {
        Preconditions.checkNotNull(responsavel, "Responsável não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNoneEmpty(responsavel), "Responsável não deve ser vazio", responsavel);
        Preconditions.checkArgument(responsavel.matches("[a-zA-Z\b]+"), "Responsável deve conter somente palavras", responsavel);
        this.responsavel = responsavel;
    }

    /**
     * Gets the operadora.
     *
     * @return the operadora
     */
    public Operadora getOperadora() {
        return operadora;
    }

    /**
     * Sets the operadora.
     *
     * @param operadora the new operadora
     */
    public void setOperadora(Operadora operadora) {
        Preconditions.checkNotNull(responsavel, "Operadora não deve ser nula");
        this.operadora = operadora;
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
