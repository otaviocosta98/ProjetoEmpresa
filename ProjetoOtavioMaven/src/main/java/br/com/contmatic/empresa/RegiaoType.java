package br.com.contmatic.empresa;

public enum RegiaoType {

                        SUL("Sul"),
                        NORTE("Norte"),
                        CENTRO_OESTE("Centro Oeste"),
                        NORDESTE("Nordeste"),
                        SUDESTE("Sudeste");

    private String regiao;

    private RegiaoType(String regiao) {
        this.regiao = regiao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
