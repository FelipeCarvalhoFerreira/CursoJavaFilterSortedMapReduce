package modelo.entidades;

public class Funcionario {

	private String nomeFuncionario;
	private String emailFuncionario;
	private Double salarioFuncionario;
	
	public Funcionario(String nomeFuncionario, String emailFuncionario, Double salarioFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
		this.emailFuncionario = emailFuncionario;
		this.salarioFuncionario = salarioFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getEmailFuncionario() {
		return emailFuncionario;
	}

	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}

	public Double getSalarioFuncionario() {
		return salarioFuncionario;
	}

	public void setSalarioFuncionario(Double salarioFuncionario) {
		this.salarioFuncionario = salarioFuncionario;
	}
	
	

}
