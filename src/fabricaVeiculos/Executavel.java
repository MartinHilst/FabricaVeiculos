package fabricaVeiculos;

public class Executavel {

	public static void main(String[] args) {
		Carro x6 = new Carro("azul", "BMW", "4TF6K0", 200);
		Carro ix35 = new Carro("preto", "Hyundai", "BGF578R", 180);
		
		Moto pcx = new Moto("branca", "Honda", "CAR09L", 150);
		
		Gasolina gasolina = new Gasolina();
		Alcool alcool = new Alcool();
		
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
		
		x6.abastecimento(gasolina, 45);
		ix35.abastecimento(alcool, 15);


	}

}
