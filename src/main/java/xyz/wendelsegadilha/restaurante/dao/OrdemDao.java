package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Ordem;
import xyz.wendelsegadilha.restaurante.vo.ItensPrincipaisVO;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class OrdemDao {

    private final EntityManager entityManager;

    public OrdemDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Ordem ordem){
        this.entityManager.persist(ordem);
    }

    public Ordem consultarPorId(Integer id){
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos(){
        try{
            String sql = "SELECT o FROM Ordem o";
            return this.entityManager.createQuery(sql, Ordem.class).getResultList();
        }catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Ordem joinFetchCliente(Integer id){
        try{
            String sql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id";
            return this.entityManager.createQuery(sql, Ordem.class).setParameter("id", id).getSingleResult();
        }catch (Exception e) {
            return null;
        }
    }

    public List<ItensPrincipaisVO> consultarItensMaisVendidos(){
        try{
            String jpql = "SELECT new xyz.wendelsegadilha.restaurante.vo.ItensPrincipaisVO(c.nome, SUM(oc.quantidade)) FROM Ordem o " +
                    "JOIN OrdensCardapio oc on o.id = oc.cardapio.id " +
                    "JOIN oc.cardapio c " +
                    "GROUP BY c.nome " +
                    "ORDER BY SUM(oc.quantidade) DESC";
            return this.entityManager.createQuery(jpql, ItensPrincipaisVO.class).getResultList();
        }catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(Ordem ordem){
        this.entityManager.remove(ordem);
    }

}
