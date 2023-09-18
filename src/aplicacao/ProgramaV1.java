package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import modelo.entidades.Funcionario;

public class ProgramaV1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o caminho completo do arquivo: ");
		String caminhoArquivo = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader (caminhoArquivo))) {

			List<Funcionario> listaFuncionario = new ArrayList<>();
			
			String linhaArquivo = br.readLine();
			while (linhaArquivo != null) {
				String[] camposArquivos = linhaArquivo.split(",");
				listaFuncionario.add(new Funcionario (camposArquivos[0], camposArquivos[1], Double.parseDouble(camposArquivos[2])));
				linhaArquivo = br.readLine();
			}
			
			System.out.print("Informar o valor do Salario: ");
			Double salarioSuperior = sc.nextDouble();
			
			
			List<String> emailFuncionarioSalarioSuperior = listaFuncionario.stream()
					.filter(p -> p.getSalarioFuncionario() > salarioSuperior)
					.map(p -> p.getEmailFuncionario()).sorted().collect(Collectors.toList());
			
			System.out.println("Email de pessoas cujo salário é superior a 2.000,00: ");
			emailFuncionarioSalarioSuperior.forEach(System.out :: println);
			
			
			Double somaSalario = listaFuncionario.stream().filter(p -> p.getNomeFuncionario().charAt(0) == 'M')
					.map(p -> p.getSalarioFuncionario()).reduce(0.0, (s1, s2) -> s1 + s2);
			
			System.out.print("Soma dos salários das pessoas cujo nome começa com 'M': " + String.format("%.2f", somaSalario));
		}
		
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}

}
