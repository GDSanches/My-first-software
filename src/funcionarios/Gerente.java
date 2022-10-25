package funcionarios;

public class Gerente extends Funcionario {
	
	private int codGerente;

	public Gerente(String cpf, int senha, String endereço, String telefone, char cargo, int salario, int codGerente) {
		super(cpf, senha, endereço, telefone, cargo, salario);
		this.codGerente = codGerente;
	}

	public int getCodGerente() {
		return codGerente;
	}

	public void setCodGerente(int codGerente) {
		this.codGerente = codGerente;
	}

	@Override
	public String toString() {
		return "Gerente [codGerente=" + codGerente + "]";
	}

	
}
