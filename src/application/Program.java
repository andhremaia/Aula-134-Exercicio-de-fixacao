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
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);			
			
			System.out.print("Name: ");
			String nome = sc.next();
			
			if (type == 'i') {				
				System.out.print("Anual income: ");
				Double rendaAnual = sc.nextDouble();				
				System.out.print("Gastos com saude: ");
				Double gastosComSaude = sc.nextDouble();				
				Pessoa pf = new PessoaFisica(nome, rendaAnual, gastosComSaude);
				list.add(pf);
			}
			
			else if (type == 'c') {				
				System.out.print("Anual income: ");
				Double rendaAnual = sc.nextDouble();				
				System.out.print("Number of employee: ");
				int numeroDeFuncionarios = sc.nextInt();				
				Pessoa pj = new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios);
				list.add(pj);
			}	
		}
		
		System.out.println("\nTAXES PAID: ");
		Double sum = 0.0;
		
		for (Pessoa pessoa : list) {			
			sum += sum + pessoa.imposto();
			System.out.printf("%s: $ %.2f\n", pessoa.getNome(), pessoa.imposto());
		}
		
		System.out.print("\nTOTAL TAXES: " + String.format("%.2f", sum));		
		sc.close();
	}
}
