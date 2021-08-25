package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<Pessoa>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i ++) {			
			System.out.println("\nTax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String nome = sc.next();
			System.out.print("Anual income: ");
			Double rendaAnual = sc.nextDouble();
			
			if (type == 'i') {
				System.out.print("Gastos com saude: ");
				Double gastosComSaude = sc.nextDouble();				
				list.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
			}			
			else if (type == 'c') {	
				System.out.print("Number of employee: ");
				int numeroDeFuncionarios = sc.nextInt();				
				list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
			}	
		}
		
		System.out.println("\nTAXES PAID: ");
		
		for (Pessoa pessoa : list) {
			System.out.printf("%s: $ %.2f\n", pessoa.getNome(), pessoa.imposto());
		}
		
		Double sum = 0.0;
		
		for (Pessoa pessoa : list) {			
			sum += pessoa.imposto();			
		}
		
		System.out.print("\nTOTAL TAXES: " + String.format("%.2f", sum));		
		sc.close();
	}
}
