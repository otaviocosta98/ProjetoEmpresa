package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class Bairro.
 */
public class Bairro {

    /** The codigo. */
    private Integer codigo;

    /** The nome. */
    private String nome;

    /** The tipo. */
    private BairroType tipo;

    /** The tamanho. */
    private Double tamanho;

    /** The populacao. */
    private Integer populacao;

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
        Preconditions.checkArgument(codigo > 0, "Codigo deve ser maior que 0", codigo);
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
        Preconditions.checkArgument(nome.matches("[a-zA-Z ]+"), "Nome deve conter somente palavras", nome);
        this.nome = nome;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public BairroType getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(BairroType tipo) {
        Preconditions.checkNotNull(tipo, "Tipo não deve ser nulo");
        this.tipo = tipo;
    }

    /**
     * Gets the tamanho.
     *
     * @return the tamanho
     */
    public Double getTamanho() {
        return tamanho;
    }

    /**
     * Sets the tamanho.
     *
     * @param tamanho the new tamanho
     */
    public void setTamanho(Double tamanho) {
        Preconditions.checkNotNull(tamanho, "Tamanho não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(tamanho.toString()), "Tamanho não deve ser vazio", tamanho);
        Preconditions.checkArgument(tamanho.toString().matches("[0-9\\.]+"), "Tamanho deve conter somente numeros", tamanho);
        this.tamanho = tamanho;
    }

    /**
     * Gets the populacao.
     *
     * @return the populacao
     */
    public Integer getPopulacao() {
        return populacao;
    }

    /**
     * Sets the populacao.
     *
     * @param populacao the new populacao
     */
    public void setPopulacao(Integer populacao) {
        Preconditions.checkNotNull(populacao, "População não deve ser nulo");
        Preconditions.checkArgument(StringUtils.isNotEmpty(populacao.toString()), "População não deve ser vazio", populacao);
        Preconditions.checkArgument(populacao.toString().matches("[0-9]+"), "População deve conter somente numeros", populacao);
        this.populacao = populacao;
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
