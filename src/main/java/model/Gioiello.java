package model;

public class Gioiello {
    private String matricola, modello, immagine, categoria;
    private double prezzo;
    private int pezzidisponibili, venduti;
    private Montatura montatura;
    private Pietre pietre;


    public double getPrezzo() {
        return prezzo;
    }
    public int getPezzidisponibili() {
        return pezzidisponibili;
    }
    public String getMatricola() {
        return matricola;
    }
    public String getModello() {
        return modello;
    }
    public String getImmagine() {
        return immagine;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getVenduti() {
        return venduti;
    }
    public Montatura getMontatura() {
        return montatura;
    }
    public Pietre getPietre() {
        return pietre;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public void setPezzidisponibili(int pezzidisponibili) {
        this.pezzidisponibili = pezzidisponibili;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setVenduti(int venduti) {
        this.venduti = venduti;
    }
    public void setPietre(Pietre pietre) {
        this.pietre = pietre;
    }
    public void setMontatura(Montatura montatura) {
        this.montatura = montatura;
    }
}
