package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class Cidade.
 */
public class Cidade {

    /** The codigo. */
    private String codigo;

    /** The nome. */
    private String nome;

    /** The tamanho. */
    private String tamanho;

    /** The populacao. */
    private String populacao;

    /** The bairro. */
    private Bairro[] bairro;

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo the new codigo
     */
    public void setCodigo(String codigo) {
        Preconditions.checkNotNull(codigo, "Codigo não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(codigo), "Codigo não deve ser vazio", codigo);
        Preconditions.checkArgument(codigo.matches("[0-9]+"), "Codigo deve conter somente numeros", codigo);
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
        Preconditions.checkArgument(nome.matches("[a-zA-Z\b]+"), "Nome deve conter somente palavras", nome);
        this.nome = nome;
    }

    /**
     * Gets the tamanho.
     *
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Sets the tamanho.
     *
     * @param tamanho the new tamanho
     */
    public void setTamanho(String tamanho) {
        Preconditions.checkNotNull(tamanho, "Tamanho não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(tamanho), "Tamanho não deve ser vazio", tamanho);
        Preconditions.checkArgument(tamanho.matches("[0-9\\.]+"), "Tamanho deve conter somente numeros", tamanho);
        this.tamanho = tamanho;
    }

    /**
     * Gets the populacao.
     *
     * @return the populacao
     */
    public String getPopulacao() {
        return populacao;
    }

    /**
     * Sets the populacao.
     *
     * @param populacao the new populacao
     */
    public void setPopulacao(String populacao) {
        Preconditions.checkNotNull(populacao, "População não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(populacao), "População não deve ser vazio", populacao);
        Preconditions.checkArgument(populacao.matches("[0-9]+"), "População deve conter somente numeros", populacao);
        this.populacao = populacao;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    public Bairro[] getBairro() {
        return bairro;
    }

    /**
     * Sets the bairro.
     *
     * @param bairro the new bairro
     */
    public void setBairro(Bairro[] bairro) {
        Preconditions.checkNotNull(bairro, "Bairro não deve ser nulo");
        this.bairro = bairro;
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
