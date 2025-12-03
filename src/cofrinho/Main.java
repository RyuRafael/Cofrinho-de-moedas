package cofrinho;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Cofrinho cofre = new Cofrinho();
		Moeda dolar = new Dolar(5.0);
		Moeda euro = new Euro(6.0);
		Moeda real = new Real(1);
		Scanner sc = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			System.out.println("============MENU============\n");
			System.out.println("1 - Adicionar moeda");
			System.out.println("2 - Remover moeda");
			System.out.println("3 - Total moeda");
			System.out.println("4 - Converter moeda\n");
			System.out.println("5 - Sair\n");

			System.out.print("Digite a apção: ");
			char opcaoMenu = sc.next().charAt(0);

			switch (opcaoMenu) {
			case '1':
				boolean loopAdd = true;

				while (loopAdd) {
					System.out.println("1 - adicionar Dólar");
					System.out.println("2 - adicionar Euro");
					System.out.println("3 - adicionar Real");
					System.out.println("4 - Sair");

					System.out.print("\nOpção: ");
					char opcaoAdd = sc.next().charAt(0);

					switch (opcaoAdd) {
					case '1':
						cofre.adicionar(dolar);
						System.out.println("Dólar adicionado!");
						break;
					case '2':
						cofre.adicionar(euro);
						System.out.println("Euro adicionado!");
						break;
					case '3':
						cofre.adicionar(real);
						System.out.println("Real adicionado!");
						break;
					case '4':
						loopAdd = false;
						break;
						
					default:
						System.out.println("Opção inválida!");
					}
					break;
				}
				break;
			case '2':
				boolean loopRemove = true;
				
				while (loopRemove) {
					System.out.println("1 - remover Dólar");
					System.out.println("2 - remover Euro");
					System.out.println("3 - remover Real");
					System.out.println("4 - Sair");

					System.out.print("\nOpção: ");
					char opcaoRemover = sc.next().charAt(0);

					switch (opcaoRemover) {
					case '1':
						cofre.remover(dolar, sc);
						break;
					case '2':
						cofre.remover(euro, sc);
						break;
					case '3':
						cofre.remover(real, sc);
						break;
					case '4':
						loopRemove = false;
						break;
					default:
						System.out.println("Opção inválida!");

					}
					break;
				}
			case '3':
				cofre.listagemMoeda();
				break;

			case '4':
				System.out.println("\n--- Converter ---");
				System.out.println("1 - Converter total (todas as moedas)");
				System.out.println("2 - Mostrar total por tipo");
				System.out.println("3 - Voltar");
				System.out.print("Opção: ");
				char opcoaConverter = sc.next().charAt(0);

				switch (opcoaConverter) {
				case '1':
					cofre.totalConvertido(dolar, euro, real);
					break;
				case '2':
					System.out.println("Dólar: R$ " + String.format("%.2f", dolar.converter()));
                    System.out.println("Euro : R$ " + String.format("%.2f", euro.converter()));
                    System.out.println("Real : R$ " + String.format("%.2f", real.converter()));
                    break;
				case '3':
					break;
				default:
					System.out.println("Opção inválida!");
				}
			case '5':
				loop = false;
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
			}

		}

	}

}
