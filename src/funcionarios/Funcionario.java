package funcionarios;

public class Funcionario {
	private String cpf;
	private int senha;
	private String endereço;
	private String telefone;
	private char cargo;
	private int salario;
	
	public Funcionario(String cpf, int senha, String endereço, String telefone, char cargo, int salario) {
		super();
		
		this.setCpf(cpf);
		this.setSenha(senha);
		this.setEndereço(endereço);
		this.setTelefone(telefone);
		this.setCargo(cargo);
		this.setSalario(salario);
		
	}
	public Funcionario() {}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public char getCargo() {
		return cargo;
	}
	public void setCargo(char cargo) {
		this.cargo = cargo;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", senha=" + senha + ", endereço=" + endereço + ", telefone=" + telefone
				+ ", cargo=" + cargo + ", salario=" + salario + "]";
	}
	
	
}
