/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.tads.DomainModel.IVendaRepositorio;
import br.edu.ifnmg.tads.DomainModel.Venda;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ALUNO-2014-01
 */
public class VendaDAO extends DAOGenerico<Venda> implements IVendaRepositorio {

    private static IVendaRepositorio instancia;

    public static IVendaRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new VendaDAO();
        }
        return instancia;
    }

    public VendaDAO() {
        super(Venda.class);
    }

    public List<Venda> Buscar(Venda obj) {
        String sql = "select o from venda o";
        String where = "";
        HashMap<String, Object> parametros = new HashMap<>();
        if (obj != null) {
            if (obj.getId() != null) {
                where += "o.id = :id";
                parametros.put("id", obj.getId());
            }
        }
        if (obj.getCliente() != null) {
            if (where.length() > 0) {
                where += " and ";

                where += "o.cliente = :cliente";
                parametros.put("cliente", obj.getId());
            }
        }
        if (obj.getDataVenda() != null) {
            if (where.length() > 0) {
                where += " and ";

                where += "o.datavenda = :datavenda";
                parametros.put("datavenda", obj.getId());
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
