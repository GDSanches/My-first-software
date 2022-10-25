package cliente;

public class Cliente {
	private long codcliente;
	private String cpf;
	private String nomeCliente;
	private String email;
	private String nomeFazenda;
	private int inscricaoEstadual;
	private String endereco;
	private String cidade;
	private String estado;
	public Cliente(long codcliente, String cpf, String nomeCliente, String email, String nomeFazenda,
			int inscricaoEstadual, String endereco, String cidade, String estado) {
		super();		
		this.setCodcliente(codcliente);
		this.setCpf(cpf);
		this.setNomeCliente(nomeCliente);
		this.setEmail(email);
		this.setNomeFazenda(nomeFazenda);
		this.setInscricaoEstadual(inscricaoEstadual);
		this.setEndereco(endereco);
		this.setCidade(cidade);
		this.setEstado(estado);
	}
	public long getCodcliente() {
		return codcliente;
	}
	public void setCodcliente(long codcliente) {
		this.codcliente = codcliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeFazenda() {
		return nomeFazenda;
	}
	public void setNomeFazenda(String nomeFazenda) {
		this.nomeFazenda = nomeFazenda;
	}
	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cliente [codcliente=" + codcliente + ", cpf=" + cpf + ", nomeCliente=" + nomeCliente + ", email="
				+ email + ", nomeFazenda=" + nomeFazenda + ", inscricaoEstadual=" + inscricaoEstadual + ", endereco="
				+ endereco + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	

}
