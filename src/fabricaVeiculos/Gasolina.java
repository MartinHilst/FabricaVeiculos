package fabricaVeiculos;

public class Gasolina implements Combustivel {

	@Override
	public double abastecer(double qtdLitros) {
		double rendimento = 0;
		if (qtdLitros <= 50) {
			rendimento = qtdLitros * 10;
		} else {
			System.out.println("Quantidade de litros excede o valor máximo. Digite um valor até 50 litros");
		}

		return rendimento;
	}
}
