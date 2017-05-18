package br.com.contmatic.empresa;

public enum TelefoneType {

                          CELULAR("Celular", 9),
                          FIXO("Fixo", 8);

    private String tipo;
    private int tamanho;

    private TelefoneType(String tipo, int tamanho) {
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}
