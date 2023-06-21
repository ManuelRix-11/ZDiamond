package model;

public class MetodoPagamento {
    private String cartaconto, tipo, cvv;
    private User user;

    public String getTipo() {
        return tipo;
    }
    public String getCartaconto() {
        return cartaconto;
    }
    public String getCvv() {
        return cvv;
    }
    public User getUser() {
        return user;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCartaconto(String cartaconto) {
        this.cartaconto = cartaconto;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
