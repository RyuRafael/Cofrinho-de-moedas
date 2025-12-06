package cofrinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cofrinho {

	List<Moeda> listaMoeda = new ArrayList<Moeda>(); // Iniciar uma lista de moedas.

	// metodo para adicionar moedas;
	public void adicionar(Moeda moeda) {
		listaMoeda.add(moeda);
	}

	// metodo para remover moedas
	public void remover(Moeda moeda, Scanner sc) {
		// filtra todas as moedas do tipo que foi passado e armazena os índices em uma
		// lista.
		List<Integer> indices = IntStream.range(0, listaMoeda.size()).filter(i -> listaMoeda.get(i).equals(moeda))
				.boxed().collect(Collectors.toList());

		// Se o índice for maior que zero, a lista possui esse tipo de moeda.
		if (indices.size() > 0) {
			System.out.println("Total de Moedas: " + indices.size());

			System.out.println("\n1 - Remover Moeda");
			System.out.println("2 - Voltar\n");
			System.out.println("Digite a opção: ");
			char op = sc.next().charAt(0);

			switch (op) {
			// remove apenas uma moeda da lista.
			case '1':
				listaMoeda.remove(indices.get(0));
				System.err.println("Moeda removida com sucesso!\n");
				break;
			case '2':
				System.out.println("Voltando...\n");
				break;
			default:
				System.out.println("Opção inválida.\n");
			}
		}

	}

	// lista todas as moedas.
	public void listagemMoeda() {
		System.out.println("Total de moedas: " + listaMoeda.size() + "\n");
	}

	public void totalConvertido(Moeda dolar, Moeda euro, Moeda real) {
		int qtdDolar = (int) listaMoeda.stream().filter(m -> m.equals(dolar)).count(); // filtra a quantidade de moeda.
		int qtdEuro = (int) listaMoeda.stream().filter(m -> m.equals(euro)).count();
		int qtdReal = (int) listaMoeda.stream().filter(m -> m.equals(real)).count();

		// Atualiza a quantidade de moedas de cada tipo.
		dolar.quantidade = qtdDolar;
		euro.quantidade = qtdEuro;
		real.quantidade = qtdReal;

		// Calcula o total de moedas já convertido para real.
		double valorTotal = dolar.converter() + euro.converter() + real.converter();

		System.out.println(valorTotal);

	}

}
