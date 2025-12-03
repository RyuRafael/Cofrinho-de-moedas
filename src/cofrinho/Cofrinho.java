package cofrinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cofrinho {

	List<Moeda> listaMoeda = new ArrayList<Moeda>();

	public void adicionar(Moeda moeda) {
		listaMoeda.add(moeda);
	}

	public void remover(Moeda moeda, Scanner sc) {
		List<Integer> indices = IntStream.range(0, listaMoeda.size()).filter(i -> listaMoeda.get(i).equals(moeda))
				.boxed().collect(Collectors.toList());

		if (indices.size() > 0) {
			System.out.println("Total de Moedas: " + indices.size());

			boolean loop	 = true;

			while (loop) {
				System.out.println("\n1 - Para remover Moeda");
				System.out.println("2 - Voltar\n");
				System.out.println("Digite a opçãp: ");
				char op = sc.next().charAt(0);

				switch (op) {
				case '1':
					listaMoeda.remove(indices.get(0));
					System.err.println("Moeda removida com sucesso!\n");
					break;
				case '2':
					loop = false;
					break;
				}
				break;
			}

		} else {
			System.out.println("Voçê não possue esse tipo de moeda!\n");
		}

	}

	public void listagemMoeda() {
		System.out.println("Total de moedas: " + listaMoeda.size() + "\n");
	}

	public void totalConvertido(Moeda dolar, Moeda euro, Moeda real) {
		int qtdDolar = (int) listaMoeda.stream().filter(m -> m.equals(dolar)).count();
		int qtdEuro = (int) listaMoeda.stream().filter(m -> m.equals(euro)).count();
		int qtdReal = (int) listaMoeda.stream().filter(m -> m.equals(real)).count();

		dolar.quantidade = qtdDolar;
		euro.quantidade = qtdEuro;
		real.quantidade = qtdReal;

		double valorTotal = dolar.converter() + euro.converter() + real.converter();

		System.out.println(valorTotal);

	}

}
