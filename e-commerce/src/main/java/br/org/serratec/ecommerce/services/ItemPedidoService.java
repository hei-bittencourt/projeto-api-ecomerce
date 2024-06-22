package br.org.serratec.ecommerce.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.entities.ItemPedido;
import br.org.serratec.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	ItemPedido itemPedido;
	
	@Autowired
	PedidoService pedidoService;
	
	public List<ItemPedido> findAll() {
		return itemPedidoRepository.findAll();
	}

	public ItemPedido findById(Integer id) {
		return itemPedidoRepository.findById(id).get();
	}
	

	public ItemPedido save(ItemPedido itemPedido) {
		calcularValores(itemPedido);
		return itemPedidoRepository.save(itemPedido);

	}

	public ItemPedido update(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}

	public Boolean delete(Integer id) {
		if (itemPedidoRepository.existsById(id)) {
			itemPedidoRepository.deleteById(id);
			ItemPedido itemPedidoDeletado = itemPedidoRepository.findById(id).orElse(null);

			if (itemPedidoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private void calcularValores(ItemPedido itemPedido) {
		BigDecimal valorBruto = itemPedido.getPrecoVenda().multiply(new BigDecimal(itemPedido.getQuantidade()));
		BigDecimal desconto = valorBruto.multiply(itemPedido.getPercentualDesconto().divide(new BigDecimal(100)));
		BigDecimal valorLiquido = valorBruto.subtract(desconto);

		itemPedido.setValorBruto(valorBruto);
		itemPedido.setValorLiquido(valorLiquido);
	}
}