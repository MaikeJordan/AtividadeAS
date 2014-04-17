/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.tads.DomainModel.IProdutoRepositorio;
import br.edu.ifnmg.tads.DomainModel.Produto;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ALUNO-2014-01
 */
public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoRepositorio{
    
    private static IProdutoRepositorio instancia;

    public static IProdutoRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new ProdutoDAO();
        }
        return instancia;
    }

    public ProdutoDAO() {
        super(Produto.class);
    }

    public List<Produto> Buscar(Produto obj) {
        String sql = "select o from Produto o";
        String where = "";
        HashMap<String, Object> parametros = new HashMap<>();
        if (obj != null) {
            if (obj.getId() != null) {
                where += "o.id = :id";
                parametros.put("id", obj.getId());
            }
        }
        if (obj.getNome() != null) {
            if (where.length() > 0) {
                where += " and ";

                where += "o.Produto = :Produto";
                parametros.put("Produto", obj.getId());
            }
        }
        if (obj.getValor() != null) {
            if (obj.getValor() > 0) {
                where += " and ";
                where += "o.Produto = :Produto";
                parametros.put("Produto", obj.getId());
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
