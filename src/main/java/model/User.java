package model;

public class User {
    private String mail, pasw, nome, cognome, citta, via;
    private int ncivico;

    public String getCognome() {
        return cognome;
    }
    public String getMail() {
        return mail;
    }
    public String getNome() {
        return nome;
    }
    public String getCitta() {
        return citta;
    }
    public String getVia() {
        return via;
    }
    public int getNcivico() {
        return ncivico;
    }
    public String getPasw() {
        return pasw;
    }

    public void setVia(String via) {
        this.via = via;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public void setNcivico(int ncivico) {
        this.ncivico = ncivico;
    }
    public void setPasw(String pasw) {
        this.pasw = pasw;
    }
}
