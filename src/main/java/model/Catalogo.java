package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Gioiello> catalogo;
    private ArrayList<String> categorie;
    private ArrayList<String> listaMetalli;
    private ArrayList<String> listaPietre;
    private ArrayList<Gioiello> newEntry;
    private ArrayList<Gioiello> bestseller;
    private ArrayList<Gioiello> ultimi;

    public void setBestseller(ArrayList<Gioiello> bestseller) {
        this.bestseller = bestseller;
    }
    public void setCatalogo(ArrayList<Gioiello> catalogo) {
        this.catalogo = catalogo;
    }
    public void setCategorie(ArrayList<String> categorie) {
        this.categorie = categorie;
    }
    public void setListaMetalli(ArrayList<String> listaMetalli) {
        this.listaMetalli = listaMetalli;
    }
    public void setListaPietre(ArrayList<String> listaPietre) {
        this.listaPietre = listaPietre;
    }
    public void setNewEntry(ArrayList<Gioiello> newEntry) {
        this.newEntry = newEntry;
    }
    public void setUltimi(ArrayList<Gioiello> ultimi) {
        this.ultimi = ultimi;
    }

    public ArrayList<Gioiello> getBestseller() {
        return bestseller;
    }
    public ArrayList<Gioiello> getNewEntry() {
        return newEntry;
    }
    public ArrayList<Gioiello> getCatalogo() {
        return catalogo;
    }
    public ArrayList<String> getCategorie() {
        return categorie;
    }
    public ArrayList<String> getListaMetalli() {
        return listaMetalli;
    }
    public ArrayList<String> getListaPietre() {
        return listaPietre;
    }
    public ArrayList<Gioiello> getUltimi() {
        return ultimi;
    }
}

