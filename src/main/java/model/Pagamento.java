package model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Pagamento {
    private int idPagamento;
    private User cliente;
    private MetodoPagamento metodoPagamento;
    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public User getCliente() {
        return cliente;
    }
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
    public int getIdPagamento() {
        return idPagamento;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }
    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
