package model;

public class Montatura {
    private String codice, metallo;
    private float peso, purezza, prezzo;

    public String getCodice() {
        return codice;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public float getPeso() {
        return peso;
    }
    public float getPurezza() {
        return purezza;
    }
    public String getMetallo() {
        return metallo;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    public void setMetallo(String metallo) {
        this.metallo = metallo;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public void setPurezza(float purezza) {
        this.purezza = purezza;
    }
}
