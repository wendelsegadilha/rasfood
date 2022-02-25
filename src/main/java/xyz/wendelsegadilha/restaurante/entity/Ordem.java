package xyz.wendelsegadilha.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_de_cricao")
    private LocalDateTime dataDeCricao = LocalDateTime.now();
    @ManyToOne
    private Cliente cliente;

    /*
     * ALL = Realiza todas as operações em cascata
     * DETACH = Operacao detach executada no pai e no filho
     * MERGE = Salva pai e filho, podende já haver a entidade gerenciada
     * PERSIST = Cria pai e filho
     * REFRESH = Atualiza entidade com operacoes do banco
     * REMOVE = Propaga remocao entre pai e filho
     * */
    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private List<OrdensCardapio> ordensCardapioList = new ArrayList<>();

    public Ordem() {
    }

    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
    }

    public Ordem(Cliente cliente) {
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

    public List<OrdensCardapio> getOrdensCardapioList() {
        return ordensCardapioList;
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
