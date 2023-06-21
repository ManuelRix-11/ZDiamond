package model;

public class Ordine {
    private User cliente;
    private int nOrdine, quantita;
    private Gioiello gioiello;

    public Gioiello getGioiello() {
        return gioiello;
    }
    public int getnOrdine() {
        return nOrdine;
    }
    public User getCliente() {
        return cliente;
    }
    public int getQuantita() {
        return quantita;
    }

    public void setGioiello(Gioiello gioiello) {
        this.gioiello = gioiello;
    }
    public void setCliente(User cliente) {
        this.cliente = cliente;
    }
    public void setnOrdine(int nOrdine) {
        this.nOrdine = nOrdine;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
