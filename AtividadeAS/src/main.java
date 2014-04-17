
import br.edu.ifnmg.DataAccess.ProdutoDAO;
import br.edu.ifnmg.tads.DomainModel.ItemVenda;
import br.edu.ifnmg.tads.DomainModel.Produto;
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
        
        ProdutoDAO pdao = new ProdutoDAO();
        int i = 1;
        Long n = (long) i;  
        Produto p = new Produto();
        p = pdao.Abrir(n);
        System.out.println(p);
        
        
        //ItemVenda iv = new ItemVenda();
        //iv.getProduto()
        
        
        try {
                       
            System.out.println("Salvo");
        } catch (Exception ex) {
            System.out.println("Erro");
            ex.printStackTrace();
        }
       
    }
    
}
