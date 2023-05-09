package br.com.mclg.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.mclg.loja.dao.CategoriaDAO;
import br.com.mclg.loja.dao.ClienteDAO;
import br.com.mclg.loja.dao.PedidoDAO;
import br.com.mclg.loja.dao.ProdutoDAO;
import br.com.mclg.loja.modelo.Categoria;
import br.com.mclg.loja.modelo.Cliente;
import br.com.mclg.loja.modelo.ItemPedido;
import br.com.mclg.loja.modelo.Pedido;
import br.com.mclg.loja.modelo.Produto;
import br.com.mclg.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("VALOR TOTAL: "+ totalVendido);

	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");	
		Produto celular = new Produto("Xiaome Redmi", "Muito bom", new BigDecimal("800"), celulares);
		
		Cliente cliente = new Cliente("Rodrigo", "123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
