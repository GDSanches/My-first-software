package model.entidades;

import java.sql.Date;

public class ModelVenda {
	private  long cliente;
	private int codVenda;
	private String produto;
	private String formaPagamento;
	private Date data;
	public ModelVenda(long cliente, int codVenda, String produto, String formaPagamento, Date data) {
		super();
		
		this.setCliente(cliente);
		this.setCodVenda(codVenda);
		this.setProduto(produto);
		this.setFormaPagamento(formaPagamento);
		this.setData(data);
	}
	public long getCliente() {
		return cliente;
	}
	public void setCliente(long cliente) {
		this.cliente = cliente;
	}
	public int getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Venda [cliente=" + cliente + ", codVenda=" + codVenda + ", produto=" + produto + ", formaPagamento="
				+ formaPagamento + ", data=" + data + "]";
	}
	
	

}
