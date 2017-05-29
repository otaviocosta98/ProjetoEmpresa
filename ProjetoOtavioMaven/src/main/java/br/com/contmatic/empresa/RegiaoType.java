package br.com.contmatic.empresa;

/**
 * The Enum RegiaoType.
 */
public enum RegiaoType {

                        /** The sul. */
                        SUL("Sul"),

                        /** The norte. */
                        NORTE("Norte"),

                        /** The centro oeste. */
                        CENTRO_OESTE("Centro Oeste"),

                        /** The nordeste. */
                        NORDESTE("Nordeste"),

                        /** The sudeste. */
                        SUDESTE("Sudeste");

    /** The regiao. */
    private String regiao;

    /**
     * Instantiates a new regiao type.
     *
     * @param regiao the regiao
     */
    private RegiaoType(String regiao) {
        this.regiao = regiao;
    }

    /**
     * Gets the regiao.
     *
     * @return the regiao
     */
    public String getRegiao() {
        return regiao;
    }

    /**
     * Sets the regiao.
     *
     * @param regiao the new regiao
     */
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
