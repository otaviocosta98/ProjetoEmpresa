package br.com.contmatic.empresa;

//import com.google.common.base.Preconditions;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class Bairro.
 */
public class Bairro {

    /** The codigo. */
    @NotNull(message = "Codigo não pode ser nulo")
    @Min(value = 1, message = "Codigo deve ser maior que 0")
    private Integer codigo;

    /** The nome. */
    @NotNull(message = "Nome não deve ser nulo")
    @NotEmpty(message = "Nome não deve ser vazio")
    @Pattern(regexp = "[a-zA-Z ]+$", message = "Nome deve conter somente palavras")
    private String nome;

    /** The tipo. */
    @NotNull(message = "Tipo não deve ser nulo")
    private BairroType tipo;

    /** The tamanho. */
    @NotNull(message = "Tamanho não deve ser nulo")
    @Min(value = 1, message = "Tamanho deve ser maior que 0")
    private Double tamanho;

    /** The populacao. */
    @NotNull(message = "População não deve ser nulo")
    @Min(value = 1, message = "População deve ser maior que 0")
    private Long populacao;

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
        // Preconditions.checkNotNull(codigo, "Codigo não pode ser nulo");
        // Preconditions.checkArgument(codigo > 0, "Codigo deve ser maior que 0", codigo);
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
        // Preconditions.checkNotNull(nome, "Nome não deve ser nulo");
        // Preconditions.checkArgument(StringUtils.isNotEmpty(nome), "Nome não deve ser vazio", nome);
        // Preconditions.checkArgument(nome.matches("[a-zA-Z ]+"), "Nome deve conter somente palavras", nome);
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
        // Preconditions.checkNotNull(tipo, "Tipo não deve ser nulo");
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
        // Preconditions.checkNotNull(tamanho, "Tamanho não deve ser nulo");
        // Preconditions.checkArgument(tamanho > 0.0, "Tamanho deve ser maior que 0", tamanho);
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
        // Preconditions.checkNotNull(populacao, "População não deve ser nulo");
        // Preconditions.checkArgument(populacao > 0, "População deve ser maior que 0", populacao);
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
    public final int hashCode() {
        return new HashCodeBuilder().append(codigo).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) obj;
        return new EqualsBuilder().append(this.getCodigo(), other.getCodigo()).build();
    }
}
