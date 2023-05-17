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

public class PerformanceConsultas {
	
	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		Pedido pedido = em.find(Pedido.class, 1l);
		System.out.println(pedido.getItens().size());
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaome Redmi", "Muito bom", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames );
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);
		
		Cliente cliente = new Cliente("Rodrigo", "123456");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(40, pedido, videogame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido2, macbook));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
