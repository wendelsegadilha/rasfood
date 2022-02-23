package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato){
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: " + prato.toString());
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
