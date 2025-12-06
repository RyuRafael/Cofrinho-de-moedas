package cofrinho;

public abstract class Moeda {

	double valor = 0;
	int quantidade;

	Moeda(double valor) {
		this.valor = valor;
	}

	// Metodo para converter moeda para real;
	public double converter() {

		return quantidade * valor;

	}

}
