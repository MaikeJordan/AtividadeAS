/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.tads.DomainModel.IRepositorio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ALUNO-2014-01
 */
public abstract class DAOGenerico<T> implements IRepositorio<T> {

    //Gerenciador de entidades
    protected EntityManager manager;
    private EntityManagerFactory factory;
    private Class tipo;

    public DAOGenerico(Class t) {
        factory = Persistence.createEntityManagerFactory("Persistencia");
        manager = factory.createEntityManager();
        tipo = t;
    }

    @Override
    public boolean Salvar(T obj) {
        // Obtém a transação
        EntityTransaction transacao = manager.getTransaction();
        try {
            // Iniciar transação
            transacao.begin();

            // Persiste o objeto
            manager.persist(obj);

            //Se tudo correr bem, confirma a transação
            transacao.commit();

            return true;
        } catch (Exception ex) {
            // Aconteceu algum problema, desfaz transação
            transacao.rollback();
            return false;
        }

    }

    @Override
    public T Abrir(Long id) {
        try {
            //Persiste o objeto
            T obj = (T) manager.find(tipo, id);
            return obj;
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean Excluir(T obj) {
        //Obtém a transação
        EntityTransaction transacao = manager.getTransaction();
        try {
            // Iniciar transação
            transacao.begin();

            // Persiste o objeto
            manager.remove(obj);

            //Se tudo correr bem, confirma a transação
            transacao.commit();
            return true;
        } catch (Exception ex) {
            // Aconteceu algum problema, desfaz transação
            transacao.rollback();
            return false;
        }

    }

}
