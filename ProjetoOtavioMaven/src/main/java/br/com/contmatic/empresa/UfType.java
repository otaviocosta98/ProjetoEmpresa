package br.com.contmatic.empresa;

/**
 * The Enum UfType.
 */
public enum UfType {

                    /** The ac. */
                    AC("AC", "Acre"),

                    /** The al. */
                    AL("AL", "Alagoas"),

                    /** The am. */
                    AM("AM", "Amazonas"),

                    /** The ap. */
                    AP("AP", "Amapá"),

                    /** The ba. */
                    BA("BA", "Bahia"),

                    /** The ce. */
                    CE("CE", "Ceará"),

                    /** The df. */
                    DF("DF", "Distrito Federal"),

                    /** The es. */
                    ES("ES", "Espirito Santo"),

                    /** The go. */
                    GO("GO", "Goiás"),

                    /** The ma. */
                    MA("MA", "Maranhão"),

                    /** The mg. */
                    MG("MG", "Minas Gerais"),

                    /** The ms. */
                    MS("MS", "Mato Grosso do Sul"),

                    /** The mt. */
                    MT("MT", "Mato Grosso"),

                    /** The pa. */
                    PA("PA", "Pará"),

                    /** The pb. */
                    PB("PB", "Paraíba"),

                    /** The pe. */
                    PE("PE", "Pernambuco"),

                    /** The pi. */
                    PI("PI", "Piauí"),

                    /** The pr. */
                    PR("PR", "Paraná"),

                    /** The rj. */
                    RJ("RJ", "Rio de Janeiro"),

                    /** The rn. */
                    RN("RN", "Rio Grande do Norte"),

                    /** The ro. */
                    RO("RO", "Rondônia"),

                    /** The rr. */
                    RR("RR", "Roraima"),

                    /** The rs. */
                    RS("RS", "Rio Grande do Sul"),

                    /** The sc. */
                    SC("SC", "Santa Catarina"),

                    /** The se. */
                    SE("SE", "Sergipe"),

                    /** The sp. */
                    SP("SP", "São Paulo"),

                    /** The to. */
                    TO("TO", "Tocantins");

    /** The uf. */
    private String uf;

    /** The nome. */
    private String nome;

    /**
     * Instantiates a new uf type.
     *
     * @param uf the uf
     * @param nome the nome
     */
    private UfType(String uf, String nome) {
        this.uf = uf;
        this.nome = nome;
    }

    /**
     * Gets the uf.
     *
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * Sets the uf.
     *
     * @param uf the new uf
     */
    public void setUf(String uf) {
        this.uf = uf;
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
        this.nome = nome;
    }

}
