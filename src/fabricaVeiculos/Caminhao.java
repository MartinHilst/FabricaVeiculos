package fabricaVeiculos;

public class Caminhao extends Veiculo {

	private double pesoCarga; //a cada 1kg aumenta 0.1 no gasto de gasolina
	private boolean carroceria; //se tiver carroceria, o veiculo perde 20km da velocidade maxima
	
	public Caminhao(String cor, String marca, String placa, double velocidadeMaxima, int capacidadeTanque, double preco,
			Combustivel tipoCombustivel, double pesoCarga, boolean carroceria) {
		super(cor, marca, placa, velocidadeMaxima, capacidadeTanque, preco, tipoCombustivel);
		
		this.pesoCarga = pesoCarga;
		this.carroceria = carroceria;
		
		if(this.carroceria) {
			velocidadeMaxima -= 20;
		}
	}
	
	@Override
	public void acelerar(double valor) {
		if (isOn) {
			if(qtdCombustivel>0) {
				if (this.velocidadeMaxima  >= (this.velocidade+valor)) {
					this.velocidade += valor;
					System.out.println("Veículo a "+velocidade+"km/h");
					perdeValor(valor);
					this.qtdCombustivel -= (valor*tipoCombustivel.getKmPorLitro())+(this.pesoCarga*0.1);
				}else {
					System.out.println("O veículo atingiu a velocidade máxima de "+velocidadeMaxima+"km/h");
					this.velocidade = velocidadeMaxima;
				}
			}else {
				System.out.println("É preciso abastecer primeiro");
			}
		} else {
			System.out.println("O carro deve ser ligado primeiro. Ligando...");
			this.ligar();
			this.acelerar(valor); // recursividade
		}
	}

}
