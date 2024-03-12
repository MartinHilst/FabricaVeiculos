package fabricaVeiculos;

public class Carro extends Veiculo {
	double qtdCombustivel;
	double capacidadeDeRodagem;
	
	
	public Carro(String cor, String marca, String placa, double velocidadeMaxima) {
		super(cor, marca, placa, velocidadeMaxima);
		
	}
	
	public void abastecimento(Combustivel combustivel, double qtdLitros) {
		if(combustivel.abastecer(qtdLitros) !=0 ) {
			this.qtdCombustivel += qtdLitros;
			this.capacidadeDeRodagem = combustivel.abastecer(qtdLitros);
		}
		
		System.out.println("O rendimento total do veículo após o abastecimento é de: "+ this.capacidadeDeRodagem +"km");
	}

}
