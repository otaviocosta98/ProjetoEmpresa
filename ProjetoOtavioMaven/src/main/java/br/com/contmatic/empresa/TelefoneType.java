package br.com.contmatic.empresa;

/**
 * The Enum TelefoneType.
 */
public enum TelefoneType {

                          /** The celular. */
                          CELULAR("Celular", 9),

                          /** The fixo. */
                          FIXO("Fixo", 8);

    /** The tipo. */
    private String tipo;

    /** The tamanho. */
    private int tamanho;

    /**
     * Instantiates a new telefone type.
     *
     * @param tipo the tipo
     * @param tamanho the tamanho
     */
    private TelefoneType(String tipo, int tamanho) {
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets the tamanho.
     *
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Sets the tamanho.
     *
     * @param tamanho the new tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}
