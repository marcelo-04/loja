package br.com.mclg.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.mclg.loja.dao.CategoriaDAO;
import br.com.mclg.loja.dao.ProdutoDAO;
import br.com.mclg.loja.modelo.Categoria;
import br.com.mclg.loja.modelo.Produto;
import br.com.mclg.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiome Redmi", "Muito bom", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
