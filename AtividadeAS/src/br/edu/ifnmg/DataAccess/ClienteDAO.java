/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.tads.DomainModel.Cliente;
import br.edu.ifnmg.tads.DomainModel.IClienteRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ALUNO-2014-01
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements IClienteRepositorio {

    private static IClienteRepositorio instancia;

    public static IClienteRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    public ClienteDAO() {
        super(Cliente.class);
    }

    public List<Cliente> Buscar(Cliente obj){
        String sql = "select o from Cliente o";
        String where = "";
        HashMap<String, Object> parametros = new HashMap<>();
        if(obj != null){
            if(obj.getId() != null){
                where += "o.id = :id";
                parametros.put("id", obj.getId());
            }
        }
        
        //Se houver filtros,coloca o "where" na consulta
        if(where.length() > 0)
            sql = sql + " where " + where;
        
        //Cria a consulta no JPA
        Query query = manager.createQuery(sql);
        
        //Aplica os parametros
        for(String par : parametros.keySet()){
            query.setParameter(par, parametros.get(par));
        }
        
        //Executa a consulta
        return query.getResultList();
    }

}
