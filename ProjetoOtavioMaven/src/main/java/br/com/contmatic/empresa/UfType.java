package br.com.contmatic.empresa;

public enum UfType {

                    AC("AC", "Acre"),
                    AL("AL", "Alagoas"),
                    AM("AM", "Amazonas"),
                    AP("AP", "Amapá"),
                    BA("BA", "Bahia"),
                    CE("CE", "Ceará"),
                    DF("DF", "Distrito Federal"),
                    ES("ES", "Espirito Santo"),
                    GO("GO", "Goiás"),
                    MA("MA", "Maranhão"),
                    MG("MG", "Minas Gerais"),
                    MS("MS", "Mato Grosso do Sul"),
                    MT("MT", "Mato Grosso"),
                    PA("PA", "Pará"),
                    PB("PB", "Paraíba"),
                    PE("PE", "Pernambuco"),
                    PI("PI", "Piauí"),
                    PR("PR", "Paraná"),
                    RJ("RJ", "Rio de Janeiro"),
                    RN("RN", "Rio Grande do Norte"),
                    RO("RO", "Rondônia"),
                    RR("RR", "Roraima"),
                    RS("RS", "Rio Grande do Sul"),
                    SC("SC", "Santa Catarina"),
                    SE("SE", "Sergipe"),
                    SP("SP", "São Paulo"),
                    TO("TO", "Tocantins");

    private String uf;
    private String nome;

    private UfType(String uf, String nome) {
        this.uf = uf;
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
