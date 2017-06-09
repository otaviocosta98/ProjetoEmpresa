package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.DateTime;

//import com.google.common.base.Preconditions;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The codigo. */
    @NotNull(message = "Codigo não deve ser nulo")
    @Min(value = 1, message = "Codigo deve ser maior que 0")
    private Integer codigo;

    /** The nome. */
    @NotNull(message = "Nome não deve ser nulo")
    @NotBlank(message = "Nome não deve ser vazio")
    private String nome;

    /** The razao social. */
    @NotNull(message = "Razão Social não deve ser nula")
    @NotBlank(message = "Razão Social não deve ser vazia")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Razão Social deve conter somente caracteres alfa-numericos")
    private String razaoSocial;

    /** The ie. */
    @NotNull(message = "Inscrição Social não deve ser nula")
    @Min(value = 100000000000L, message = "Inscrição Social deve ser maior que zero")
    @Range(min = 12, max = 12, message = "Inscrição Social deve ter 12 digitos")
    private Long IE;

    /** The cnpj. */
    @NotNull(message = "CNPJ não deve ser nulo")
    @NotBlank(message = "CNPJ não deve ser vazio")
    @Size(min = 12, max = 12, message = "CNPJ deve contem 14 digitos")
    @CNPJ(message = "CNPJ deve conter somente numeros")
    private String CNPJ;

    /** The endereco. */
    @NotNull(message = "Endereço não deve ser nulo")
    private Set<Endereco> endereco;

    /** The telefone. */
    @NotNull(message = "Telefone não deve ser nulo")
    private Set<Telefone> telefone;

    /** The email. */
    @NotNull(message = "Email não deve ser nulo")
    @NotBlank(message = "Email não deve ser vazio")
    @Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)* @[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;", message = "Email deve ser válido")
    private String email;

    /** The data inicio. */
    @NotNull(message = "Data de Início não deve ser nula")
    @Future(message = "Data de Início deve ser maior que hoje")
    private DateTime dataInicio;

    /**
     * Instantiates a new empresa.
     */
    public Empresa() {

    }

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
        // Preconditions.checkNotNull(codigo, "Codigo não deve ser nulo");
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
        // Preconditions.checkNotNull(razaoSocial, "Razão Social não deve ser nula");
        // Preconditions.checkArgument(StringUtils.isNotEmpty(razaoSocial), "Razão Social não deve ser vazia", razaoSocial);
        // Preconditions.checkArgument(razaoSocial.matches("[a-zA-Z0-9 ]+"), "Razão Social deve conter somente caracteres alfa-numericos", razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    /**
     * Gets the ie.
     *
     * @return the ie
     */
    public Long getIE() {
        return IE;
    }

    /**
     * Sets the ie.
     *
     * @param iE the new ie
     */
    public void setIE(Long iE) {
        // Preconditions.checkNotNull(iE, "Inscrição Social não deve ser nula");
        // Preconditions.checkArgument(iE > 0, "Inscrição Social deve ser maior que zero", iE);
        // Preconditions.checkArgument(iE.toString().length() == 12, "Inscrição Social deve ter 12 digitos", iE);
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
        // Preconditions.checkNotNull(cNPJ, "CNPJ não deve ser nulo");
        // Preconditions.checkArgument(StringUtils.isNotEmpty(cNPJ), "CNPJ não deve ser vazia", cNPJ);
        // Preconditions.checkArgument(cNPJ.matches("[0-9]+"), "CNPJ deve conter somente numeros", cNPJ);
        // Preconditions.checkArgument(cNPJ.length() == 14, "CNPJ deve contem 14 digitos", cNPJ);
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
        // Preconditions.checkNotNull(endereco, "Endereço não deve ser nulo");
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
        // Preconditions.checkNotNull(telefone, "Telefone não deve ser nulo");
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
        // Preconditions.checkNotNull(email, "Email não deve ser nulo");
        // Preconditions.checkArgument(StringUtils.isNotEmpty(email), "Email não deve ser vazio", email);
        // Preconditions.checkArgument(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)* @[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;"), "Email deve ser válido", email);
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
        // Preconditions.checkArgument(dataInicio.isAfter(DateTime.now()), "Data de Início deve ser maior que hoje", dataInicio);
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
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) obj;
        return EqualsBuilder.reflectionEquals(this.getCodigo(), other.getCodigo());
    }

}
