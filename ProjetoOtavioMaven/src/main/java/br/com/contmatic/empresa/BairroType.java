package br.com.contmatic.empresa;

/**
 * The Enum BairroType.
 */
public enum BairroType {

                        /** The residencial. */
                        RESIDENCIAL("Residencial"),

                        /** The comercial. */
                        COMERCIAL("Comercial"),

                        /** The industrial. */
                        INDUSTRIAL("Industrial");

    /** The tipo. */
    private String tipo;

    /**
     * Instantiates a new bairro type.
     *
     * @param tipo the tipo
     */
    private BairroType(String tipo) {
        this.tipo = tipo;
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

}
