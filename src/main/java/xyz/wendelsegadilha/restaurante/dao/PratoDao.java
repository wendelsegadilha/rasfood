package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private final EntityManager entityManager;

    public PratoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato){
        this.entityManager.persist(prato);
    }

    public Prato consultar(Integer id){
        return this.entityManager.find(Prato.class, id);
    }

    public void atualizar(Prato prato){
        this.entityManager.merge(prato);
    }

    public void excluir(Prato prato){
        this.entityManager.remove(prato);
    }

}
