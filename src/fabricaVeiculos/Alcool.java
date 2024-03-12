package fabricaVeiculos;

public class Alcool implements Combustivel {

	@Override
	public double abastecer(double qtdLitros) {
		double rendimento = 0;
		if (qtdLitros <= 50) {
			rendimento = qtdLitros * 7.5;
		} else {
			System.out.println("Quantidade de litros excede o valor máximo. Digite um valor até 50 litros");
		}

		return rendimento;
	}

}
