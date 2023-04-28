package br.com.mclg.loja.dao;

import javax.persistence.EntityManager;

import br.com.mclg.loja.modelo.Produto;

public class ProdutoDAO {
	
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		
		this.em.persist(produto);
	}
}
