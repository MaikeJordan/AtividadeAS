/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author ALUNO-2014-01
 */
@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VendaID")
    private Long id;

    @ManyToOne(optional = false)
    private Cliente cliente;

    private double ValorTotal;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<ItemVenda> itens;

    public Venda(Long id, Cliente cliente, double ValorTotal, Date dataVenda, List<ItemVenda> itens) {
        this.id = id;
        this.cliente = cliente;
        this.ValorTotal = ValorTotal;
        this.dataVenda = dataVenda;
        this.itens = itens;
    }

    public Venda() {
        cliente = new Cliente();
        ValorTotal = 0;
        dataVenda = null;
        itens = null;
    }

    public Long getId() {
        return id;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void add(ItemVenda i) {
        if (!itens.contains(i)) {
            i.setVenda(this);
            itens.add(i);
            ValorTotal += (i.getProduto().getValor() * i.getQuantidade());
        }
    }

    public void remove(ItemVenda i) {
        if (itens.contains(i)) {
            i.setVenda(this);
            itens.remove(i);
            ValorTotal -= (i.getProduto().getValor() * i.getQuantidade());
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.DomainModel.Venda[ id=" + id + " ]";
    }

}
