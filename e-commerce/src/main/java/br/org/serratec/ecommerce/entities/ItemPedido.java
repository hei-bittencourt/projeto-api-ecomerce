package br.org.serratec.ecommerce.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "item_pedido")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idItemPedido", scope = ItemPedido.class)
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer idItemPedido;

	@NotNull
	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco_venda")
	private BigDecimal precoVenda;

	@Column(name = "percentual_desconto")
	private BigDecimal percentualDesconto;

	@Column(name = "valor_bruto")
	private BigDecimal valorBruto;

	@Column(name = "valor_liquido")
	private BigDecimal valorLiquido;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", quantidade=" + quantidade + ", precoVenda=" + precoVenda
				+ ", percentualDesconto=" + percentualDesconto + ", valorBruto=" + valorBruto + ", valorLiquido="
				+ valorLiquido + ", produto=" + produto + ", pedido=" + pedido + "]";
	}

}
