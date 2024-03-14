package fabricaVeiculos;

public class Executavel {

	public static void main(String[] args) {
		Gasolina gasolina = new Gasolina();
		Alcool alcool = new Alcool();
		
		Carro x6 = new Carro("azul", "BMW", "4TF6K0", 200, 50, 500000, gasolina);
		Carro ix35 = new Carro("preto", "Hyundai", "BGF578R", 180, 50, 200000, alcool);
		
		Moto pcx = new Moto("branca", "Honda", "CAR09L", 150, 35, 20000, gasolina);
		
		x6.ligar();
		x6.acelerar(100);
		x6.freiar(50);
		x6.acelerar(200);
		x6.desligar();
		
		ix35.ligar();
		ix35.acelerar(100);
		ix35.freiar(50);
		ix35.acelerar(100);
		ix35.desligar();
		
		pcx.ligar();
		pcx.acelerar(100);
		pcx.freiar(50);
		pcx.acelerar(60);
		pcx.desligar();
		
		x6.abastecimento(45);
		ix35.abastecimento(15);


	}

}
