package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Ordem;

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

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(Ordem ordem){
        this.entityManager.remove(ordem);
    }

}
