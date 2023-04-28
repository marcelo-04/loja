package br.com.mclg.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mclg.loja.dao.ProdutoDAO;
import br.com.mclg.loja.modelo.Categoria;
import br.com.mclg.loja.modelo.Produto;
import br.com.mclg.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto("Xiome Redmi", "Muito bom", new BigDecimal("800"), Categoria.CELULARES);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
