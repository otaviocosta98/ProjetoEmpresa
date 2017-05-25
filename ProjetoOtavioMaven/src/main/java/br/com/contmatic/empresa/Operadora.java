package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class Operadora.
 */
public class Operadora {

    /** The codigo. */
    private Integer codigo;

    /** The nome. */
    private String nome;

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo the new codigo
     */
    public void setCodigo(Integer codigo) {
        Preconditions.checkNotNull(codigo, "Codigo não deve ser nulo");
        Preconditions.checkArgument(codigo > 0, "Codigo não deve ser vazio", codigo);
        this.codigo = codigo;
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
