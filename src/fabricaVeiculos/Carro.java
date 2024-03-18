package fabricaVeiculos;

public class Carro extends Veiculo {
	
	public Carro(String cor, String marca, String placa, double velocidadeMaxima, int capacidadeTanque, double preco,
			Combustivel tipoCombustivel, boolean automatico) {
		super(cor, marca, placa, velocidadeMaxima, capacidadeTanque, preco, tipoCombustivel, automatico);
		this.aceleracao = 10;
	}
	
}
