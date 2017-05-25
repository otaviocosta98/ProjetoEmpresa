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
    private Integer ddd;

    /** The numero. */
    private Integer numero;

    /** The ramal. */
    private Integer ramal;

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
    public Integer getDdd() {
        return ddd;
    }

    /**
     * Sets the ddd.
     *
     * @param ddd the new ddd
     */
    public void setDdd(Integer ddd) {
        Preconditions.checkNotNull(ddd, "DDD não deve ser nulo");
        Preconditions.checkArgument(ddd > 0, "DDD não deve ser vazio", ddd);
        Preconditions.checkArgument(ddd.toString().length() == 2, "DDD deve conter somente 2 digitos", ddd);
        this.ddd = ddd;
    }

    /**
     * Gets the ramal.
     *
     * @return the ramal
     */
    public Integer getRamal() {
        return ramal;
    }

    /**
     * Sets the ramal.
     *
     * @param ramal the new ramal
     */
    public void setRamal(Integer ramal) {
        this.ramal = ramal;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(Integer numero) {
        Preconditions.checkNotNull(numero, "Numero não deve ser nulo");
        Preconditions.checkArgument(numero > 0, "Numero não deve ser vazio", numero);
        Preconditions.checkArgument(numero.toString().length() == getTipo().getTamanho(), "Quantidade de digitos incorretos para o tipo de telefone informado", numero);
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
