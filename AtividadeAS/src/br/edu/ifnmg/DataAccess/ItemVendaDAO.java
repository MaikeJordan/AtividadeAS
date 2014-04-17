/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.tads.DomainModel.IItemVendaRepositorio;
import br.edu.ifnmg.tads.DomainModel.ItemVenda;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ALUNO-2014-01
 */
public class ItemVendaDAO extends DAOGenerico<ItemVenda> implements IItemVendaRepositorio{

    private static IItemVendaRepositorio instancia;

    public static IItemVendaRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new ItemVendaDAO();
        }
        return instancia;
    }

    public ItemVendaDAO() {
        super(ItemVenda.class);
    }

    public List<ItemVenda> Buscar(ItemVenda obj) {
        String sql = "select o from ItemVenda o";
        String where = "";
        HashMap<String, Object> parametros = new HashMap<>();
        if (obj != null) {
            if (obj.getId() != null) {
                where += "o.id = :id";
                parametros.put("id", obj.getId());
            }
        }
        if (obj.getProduto().getNome() != null) {
            if (where.length() > 0) {
                where += " and ";
                where += "o.ItemVenda = :ItemVenda";
                parametros.put("ItemVenda", obj.getId());
            }
        }
        if (obj.getProduto().getValor() != null) {
            if (obj.getProduto().getValor() > 0) {
                where += " and ";
                where += "o.ItemVenda = :ItemVenda";
                parametros.put("ItemVenda", obj.getId());
            }
        }
        // Se houver filtros, coloca o "where" na consulta
        if (where.length() > 0) {
            sql = sql + "where" + where;
        }

        // Cria consulta no JPA
        Query query = manager.createQuery(sql);

        //Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }
        
        //Executa a consulta
        return query.getResultList();
    }
}
