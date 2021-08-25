package entities;

public class PessoaFisica extends Pessoa {
	
	private Double gastosComSaude;
	
	public PessoaFisica() {
		super();
	}	

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public Double imposto() {
		
		double imposto = 0.0;
		
		if(super.getRendaAnual() <= 20000 && gastosComSaude == 0.0) 
			imposto = super.getRendaAnual() * 0.15;
		else 
			if (super.getRendaAnual() <= 20000 && gastosComSaude > 0.0)
				imposto = super.getRendaAnual() * 0.15 - gastosComSaude * 0.5;
		
		if(super.getRendaAnual() > 20000 && gastosComSaude == 0.0) 
			imposto = super.getRendaAnual() * 0.25;
		else 
			if (super.getRendaAnual() > 20000 && gastosComSaude > 0.0)
				imposto = ((super.getRendaAnual() * 0.25) - (gastosComSaude * 0.5));
			
		return imposto;
	}
}
