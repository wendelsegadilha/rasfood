package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorId(Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos(){
        try{
            String sql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        }catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return entityManager.createQuery(jpql, Cardapio.class)
                    .setParameter("valor", filtro).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public Cardapio consultarPorNome(final String filtro){
        try{
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return entityManager.createQuery(jpql, Cardapio.class)
                    .setParameter("nome", filtro).getSingleResult();
        }catch (Exception e) {
            return null;
        }
    }

    public void atualizar(Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

}
