package entities;

public class PessoaJuridica extends Pessoa{
	
	private Integer numeroDeFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public Double imposto() {
		
		Double imposto = 0.0;

		if(numeroDeFuncionarios <= 10)
			imposto = super.getRendaAnual() * 0.16;
		else
			if(numeroDeFuncionarios > 10)
				imposto = super.getRendaAnual() * 0.14;
		return imposto;
	}
}
