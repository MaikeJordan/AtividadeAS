
import br.edu.ifnmg.DataAccess.ClienteDAO;
import br.edu.ifnmg.DataAccess.ItemVendaDAO;
import br.edu.ifnmg.DataAccess.ProdutoDAO;
import br.edu.ifnmg.DataAccess.VendaDAO;
import br.edu.ifnmg.tads.DomainModel.Cliente;
import br.edu.ifnmg.tads.DomainModel.ItemVenda;
import br.edu.ifnmg.tads.DomainModel.Produto;
import br.edu.ifnmg.tads.DomainModel.Venda;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ALUNO-2014-01
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
        EntityManager manager = factory.createEntityManager();
      
        Venda v = new Venda();
        
        System.out.println(v);
        
        /*Cliente c = new Cliente();
        c.setNome("Maike Jordan");
        ClienteDAO dao = new ClienteDAO();
        dao.Salvar(c);
		
		
		Produto p = new Produto();
        p.setNome("Pão de Sal");
        p.setValor(5.50);
        ProdutoDAO pdao = new ProdutoDAO();
		]pdao.Salvar(p);
		
		
		/*
        ProdutoDAO pdao = new ProdutoDAO();
        int i = 1;
        Long n = (long) i;  
        Produto p = new Produto();
        p = pdao.Abrir(n);
        System.out.println(p);
        
        
        //ItemVenda iv = new ItemVenda();
        //iv.getProduto()
        
		
		
		ClienteDAO dao = new ClienteDAO();
        int i = 201;
        Long n = (long) i;  
        Cliente c = new Cliente();
        c = dao.Abrir(n);
        
        Produto p = new Produto();
        p.setNome("Bolo");
        p.setValor(6.25);
        ProdutoDAO pdao = new ProdutoDAO();
        int is = 251;
        Long ns = (long) is;  
        Produto produto = new Produto();
        produto = pdao.Abrir(ns);
        
		
		ClienteDAO dao = new ClienteDAO();
        int i = 201;
        Long n = (long) i;  
        Cliente c = new Cliente();
        c = dao.Abrir(n);
        
        Produto p = new Produto();
        p.setNome("Bolo");
        p.setValor(6.25);
        ProdutoDAO pdao = new ProdutoDAO();
        int is = 251;
        Long ns = (long) is;  
        Produto produto = new Produto();
        produto = pdao.Abrir(ns);
        
        Venda v = new Venda();        
        VendaDAO vdao = new VendaDAO();
        ItemVenda iv = new ItemVenda();
        iv.setProduto(produto);
        iv.setQuantidade(2);
        iv.setVenda(v);
        ItemVendaDAO ivdao = new ItemVendaDAO();
        ivdao.Salvar(iv);
        
        
        v.setCliente(c);
        LinkedList l = new LinkedList() {};
        l.add(iv);
        v.setItens(l);
        v.setDataVenda(null);
        System.out.println(v);
        try {           
            
            vdao.Salvar(v);
            System.out.println("A Venda "+v+" foi Realizada");
            System.out.println("O cliente "+c.getNome()+" foi Carregado");
        } catch (Exception ex) {
            System.out.println("Erro");
            ex.printStackTrace();
        }
        */
       
    }
    
}
