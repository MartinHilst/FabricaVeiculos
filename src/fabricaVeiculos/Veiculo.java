package fabricaVeiculos;

import java.util.Date;

public class Veiculo {

	// atributos
	protected String cor;
	protected String marca;
	protected String placa;
	protected Date anoFabricacao;
	protected double velocidadeMaxima;
	protected boolean isOn;
	protected double velocidade;
	protected int capacidadeTanque; //novo
	protected double preco; //novo
	protected double qtdCombustivel; //novo
	protected double capacidadeRodagem; //novo
	protected Combustivel tipoCombustivel; //novo
	protected double aceleracao; //em km/h por segundo
	protected int marcha=1;
	protected boolean automatico;

	// construtor
	public Veiculo(String cor, String marca, String placa, double velocidadeMaxima, int capacidadeTanque, double preco, Combustivel tipoCombustivel, boolean automatico) {
		super();
		this.cor = cor;
		this.marca = marca;
		this.placa = placa;
		this.velocidadeMaxima = velocidadeMaxima;
		this.capacidadeTanque = capacidadeTanque;
		this.preco = preco;
		this.qtdCombustivel = 0;
		this.velocidade = 0;
		this.tipoCombustivel = tipoCombustivel;
		this.anoFabricacao = new Date();
		this.isOn = false;
		this.automatico=automatico;
	}
	
	public void trocarMarcha(int valor) {
		if(valor>0 && valor<7) {
			this.marcha=valor;
		}
		else {
			System.out.println("Valor inválido para a marcha");
		}
	}

	// métodos
	public void ligar() {
		if (isOn) {
			System.out.println("O veículo já está ligado");
		} else {
			isOn = true;
		}
	}

	public void desligar() {
		if (!isOn) {
			System.out.println("O veículo já está desligado");
		} else {
			isOn = false;
			velocidade = 0;
		}
	}

	public void acelerar(double valor) {
		double tempoAcelerar;
		double velocidadeMarcha = 0;
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
					this.qtdCombustivel -= valor/tipoCombustivel.getKmPorLitro();
					
				}else if (this.velocidadeMaxima  >= (this.velocidade+valor)) {
					
					tempoAcelerar = valor/this.aceleracao;
					this.velocidade += valor;	
					System.out.println("Veículo a "+this.velocidade+"km/h ("+tempoAcelerar+" segundos)");
					perdeValor(valor);
					this.qtdCombustivel -= valor/tipoCombustivel.getKmPorLitro();
					
				}
				else {
					
					tempoAcelerar=(this.velocidadeMaxima - this.velocidade)/this.aceleracao;
					System.out.println("O veículo atingiu a velocidade máxima de "+velocidadeMaxima+"km/h ("+tempoAcelerar+" segundos)");
					this.velocidade = velocidadeMaxima;
					this.qtdCombustivel -= valor/tipoCombustivel.getKmPorLitro();
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
	public void freiar(double valor) {
		if (isOn) {
			if (velocidade != 0) {
				this.velocidade -= valor;
				System.out.println("Veículo a "+velocidade+"km/h");
			}else {
				System.out.println("O veículo está parado");
			}
		} 
	}
	
	public void perdeValor(double kmRodados) {
		this.preco -= kmRodados*0.1;
	}
	
	public void abastecimento(double qtdLitros) {
		if(this.tipoCombustivel.abastecer(qtdLitros, this.capacidadeTanque) !=0 ) {
			this.qtdCombustivel += qtdLitros;
			this.capacidadeRodagem = this.tipoCombustivel.abastecer(qtdLitros, this.capacidadeTanque);
		}
		
		System.out.println("O rendimento total do veículo após o abastecimento é de: "+ this.capacidadeRodagem +"km");
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
		System.out.println("-----------DADOS----------------");
	}

}
