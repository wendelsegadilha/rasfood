package xyz.wendelsegadilha.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_de_cricao")
    private LocalDateTime dataDeCricao;
    @ManyToOne
    private Cliente cliente;

    public Ordem() {

    }

    public Ordem(BigDecimal valorTotal, LocalDateTime dataDeCricao, Cliente cliente) {
        this.valorTotal = valorTotal;
        this.dataDeCricao = dataDeCricao;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCricao() {
        return dataDeCricao;
    }

    public void setDataDeCricao(LocalDateTime dataDeCricao) {
        this.dataDeCricao = dataDeCricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataDeCricao=" + dataDeCricao +
                ", cliente=" + cliente +
                '}';
    }
}
