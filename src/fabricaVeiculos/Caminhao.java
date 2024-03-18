package fabricaVeiculos;

public class Caminhao extends Veiculo {

	private double pesoCarga; //a cada 1kg aumenta 0.001 no gasto de gasolina
	private boolean carroceria; //se tiver carroceria, o veiculo perde 20km da velocidade maxima

	
	public Caminhao(String cor, String marca, String placa, double velocidadeMaxima, int capacidadeTanque, double preco,
			Combustivel tipoCombustivel, double pesoCarga, boolean carroceria, boolean automatico) {
		super(cor, marca, placa, velocidadeMaxima, capacidadeTanque, preco, tipoCombustivel, automatico);
		
		this.pesoCarga = pesoCarga;
		this.carroceria = carroceria;
		this.aceleracao=8;
		
		if(this.carroceria) {
			velocidadeMaxima -= 20;
			aceleracao=4;
		}
	}
	
	@Override
	public void acelerar(double valor) {
		double tempoAcelerar;
		double velocidadeMarcha=0;
		if (isOn) {
			if(!automatico) {
				switch(marcha) {
					case 1:
						velocidadeMarcha=this.velocidadeMaxima*0.15;
						break;
					case 2:
						velocidadeMarcha=this.velocidadeMaxima*0.30;
						break;
					case 3:
						velocidadeMarcha=this.velocidadeMaxima*0.45;
						break;
					case 4:
						velocidadeMarcha=this.velocidadeMaxima*0.60;
						break;
					case 5:
						velocidadeMarcha=this.velocidadeMaxima*0.80;
						break;
					case 6:
						velocidadeMarcha=this.velocidadeMaxima;
						break;
				}
				
			}
			if(qtdCombustivel>0) {
				if((this.velocidade+valor)>velocidadeMarcha && !automatico) {
					tempoAcelerar=(velocidadeMarcha-this.velocidade)/this.aceleracao;
					this.velocidade=velocidadeMarcha;
					System.out.println("O veículo atingiu a velocidade máxima permitida nessa marcha de "+velocidadeMarcha+"km/h ("+tempoAcelerar+" segundos)");
					perdeValor(valor);
					this.qtdCombustivel -= (valor/tipoCombustivel.getKmPorLitro())+(this.pesoCarga*0.01);
				}else if (this.velocidadeMaxima  >= (this.velocidade+valor)) {
					tempoAcelerar = valor / this.aceleracao;
					this.velocidade += valor;
					System.out.println("Veículo a "+velocidade+"km/h ("+tempoAcelerar+" segundos)");
					perdeValor(valor);
					this.qtdCombustivel -= (valor/tipoCombustivel.getKmPorLitro())+(this.pesoCarga*0.01);
				}else {
					tempoAcelerar=(this.velocidadeMaxima - this.velocidade)/this.aceleracao;
					System.out.println("O veículo atingiu a velocidade máxima de "+velocidadeMaxima+"km/h ("+tempoAcelerar+" segundos)");
					this.velocidade = velocidadeMaxima;
					this.qtdCombustivel -= (valor/tipoCombustivel.getKmPorLitro())+(this.pesoCarga*0.01);
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
	
	public void exibirDados() {
		System.out.println("-----------DADOS----------------");
		System.out.println("Marca: "+this.marca);
		System.out.println("Placa: "+this.placa);
		System.out.println("Ano de Fabricação: "+this.anoFabricacao);
		System.out.println("Ligado?: "+this.isOn);
		System.out.println("Velocidade Atual: "+this.velocidade);
		System.out.println("Velocidade Máxima: "+this.velocidadeMaxima);
		System.out.println("Marcha "+this.marcha);
		System.out.println("Combustível: "+this.qtdCombustivel);
		System.out.println("Automático?: "+this.automatico);
		System.out.println("Valor: "+this.preco);
		System.out.println("Carroceria?: "+this.carroceria);
		System.out.println("Peso da Carga: "+this.pesoCarga);
		System.out.println("-----------DADOS----------------");
	}

}
