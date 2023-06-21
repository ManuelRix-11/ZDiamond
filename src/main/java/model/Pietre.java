package model;

public class Pietre {
    private String codice, tipo;
    private float caratura, dimensione, prezzo;
    private int quantita;

    public float getCaratura() {
        return caratura;
    }
    public float getDimensione() {
        return dimensione;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public int getQuantita() {
        return quantita;
    }
    public String getCodice() {
        return codice;
    }
    public String getTipo() {
        return tipo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    public void setCaratura(float caratura) {
        this.caratura = caratura;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public void setDimensione(float dimensione) {
        this.dimensione = dimensione;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
