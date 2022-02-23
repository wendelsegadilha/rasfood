package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultar(Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

}
