package br.com.contmatic.empresa;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class Estado.
 */
public class Estado {

    /** The codigo. */
    private Integer codigo;

    /** The nome. */
    private String nome;

    /** The uf. */
    private UfType uf;

    /** The tamanho. */
    private Double tamanho;

    /** The populacao. */
    private Long populacao;

    /** The cidade. */
    private Cidade[] cidade;

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
        Preconditions.checkArgument(StringUtils.isNoneEmpty(nome), "Nome não deve ser vazio", nome);
        Preconditions.checkArgument(nome.matches("[a-zA-Z\b]+"), "Nome deve conter somente palavras", nome);
        this.nome = nome;
    }

    /**
     * Gets the uf.
     *
     * @return the uf
     */
    public UfType getUf() {
        return uf;
    }

    /**
     * Sets the uf.
     *
     * @param uf the new uf
     */
    public void setUf(UfType uf) {
        Preconditions.checkNotNull(uf, "UF não deve ser nulo");
        this.uf = uf;
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
        Preconditions.checkArgument(tamanho > 0, "Tamanho não deve ser vazio", tamanho);
        this.tamanho = tamanho;
    }

    /**
     * Gets the populacao.
     *
     * @return the populacao
     */
    public Long getPopulacao() {
        return populacao;
    }

    /**
     * Sets the populacao.
     *
     * @param populacao the new populacao
     */
    public void setPopulacao(Long populacao) {
        Preconditions.checkNotNull(populacao, "População não deve ser nulo");
        Preconditions.checkArgument(populacao > 0, "População não deve ser vazia", populacao);
        this.populacao = populacao;
    }

    /**
     * Gets the cidade.
     *
     * @return the cidade
     */
    public Cidade[] getCidade() {
        return cidade;
    }

    /**
     * Sets the cidade.
     *
     * @param cidade the new cidade
     */
    public void setCidade(Cidade[] cidade) {
        Preconditions.checkNotNull(cidade, "Cidade não deve ser nula");
        this.cidade = cidade;
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
