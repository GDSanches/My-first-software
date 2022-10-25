package estoque;

public class Produto {
	private int preco;
	private int quantEstoque;
	private String descricao;
	private int estoqueMinimo;
	public Produto(int preco, int quantEstoque, String descricao, int estoqueMinimo) {
		super();
		
		this.setPreco(preco);
		this.setQuantEstoque(quantEstoque);
		this.setDescricao(descricao);
		this.setEstoqueMinimo(estoqueMinimo);
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public int getQuantEstoque() {
		return quantEstoque;
	}
	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	@Override
	public String toString() {
		return "Produto [preco=" + preco + ", quantEstoque=" + quantEstoque + ", descricao=" + descricao
				+ ", estoqueMinimo=" + estoqueMinimo + "]";
	}

}
