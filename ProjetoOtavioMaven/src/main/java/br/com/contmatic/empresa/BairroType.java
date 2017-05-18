package br.com.contmatic.empresa;

public enum BairroType {

                        RESIDENCIAL("Residencial"),
                        COMERCIAL("Comercial"),
                        INDUSTRIAL("Industrial");

    private String tipo;

    private BairroType(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
