package cofrinho;

public abstract class Moeda{

	double valor = 0;
	int quantidade;
	
	Moeda(double valor){
		this.valor = valor;
	}
	
	public double converter() {

		return quantidade * valor;
		
	}
	
}
