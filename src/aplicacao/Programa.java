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

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o caminho completo do arquivo: ");
		String caminhoArquivo = sc.nextLine();

		

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

			List<Funcionario> listaFuncionario = new ArrayList<>();

			String linhaArquivo = br.readLine();
			while (linhaArquivo != null) {
			String[] camposArquivos = linhaArquivo.split(",");
			listaFuncionario.add(new Funcionario(camposArquivos [0], camposArquivos[1], Double.parseDouble(camposArquivos [2])));
			linhaArquivo = br.readLine();
			}

			System.out.print("Insira o salário: ");
			Double salario = sc.nextDouble();
			
			List <String> emailSalarioSuperior = listaFuncionario.stream()
					.filter(ess -> ess.getSalarioFuncionario() > salario)
					.map(ess -> ess.getEmailFuncionario()).sorted().collect(Collectors.toList());
			
			emailSalarioSuperior.forEach(System.out::println);
			
			Double somaSalario = listaFuncionario.stream()
					.filter(ss -> ss.getNomeFuncionario().charAt(0) == 'M')
					.map(ss -> ss.getSalarioFuncionario())
					.reduce(0.0, (s1, s2) -> s1 + s2);
			
			System.out.printf("Soma dos salários das pessoas cujo nome começa com 'M': " + String.format("%.2f", somaSalario));

		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}

// C:\Users\fcferreira\ProjetosPessoais\CursoProgramacao\CursoJavaFilterSortedMapReduce\Lista - Copia.csv
