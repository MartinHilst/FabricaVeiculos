package fabricaVeiculos;

public class Alcool implements Combustivel {

	protected double kmPorLitro = 7.5;
	@Override
	public double abastecer(double qtdLitros, int capacidadeTanque) {
		double rendimento = 0;
		if (qtdLitros <= capacidadeTanque) {
			rendimento = qtdLitros * kmPorLitro;
		} else {
			System.out.println("Quantidade de litros excede o valor máximo. Digite um valor até "+ capacidadeTanque+ " litros");
		}

		return rendimento;
	}

	@Override
	public double getKmPorLitro() {
		return kmPorLitro;
	}
	
	@Override
	public void setKmPorLitro(double kmPorLitro) {
		this.kmPorLitro = kmPorLitro;
	}
}
