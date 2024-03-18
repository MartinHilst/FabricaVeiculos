package fabricaVeiculos;

public class Executavel {

	public static void main(String[] args) {
		Gasolina gasolina = new Gasolina();
		Alcool alcool = new Alcool();
		
		Carro x6 = new Carro("azul", "BMW", "4TF6K0", 200, 50, 500000, gasolina,false);
		
		Caminhao Cargo = new Caminhao("cinza", "Ford", "AS290L", 130, 70, 700000, gasolina, 500, true, false);
		
		Moto pcx = new Moto("branca", "Honda", "CAR09L", 150, 35, 20000, gasolina,true);
		
		x6.ligar();
		x6.abastecimento(50);
		x6.acelerar(140);
		x6.trocarMarcha(5);
		x6.acelerar(100);
		x6.exibirDados();
		
		pcx.ligar();
		pcx.abastecimento(30);
		pcx.acelerar(180);
		
		
		Cargo.ligar();
		Cargo.abastecimento(70);
		Cargo.acelerar(100);
		Cargo.exibirDados();
		Cargo.trocarMarcha(6);
		Cargo.acelerar(200);
	}

}
