package br.com.mclg.loja.dao;

import javax.persistence.EntityManager;

import br.com.mclg.loja.modelo.Pedido;

public class PedidoDAO {

	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {

		this.em.persist(pedido);
	}
}
