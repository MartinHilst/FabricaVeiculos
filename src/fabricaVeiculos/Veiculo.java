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

	// construtor
	public Veiculo(String cor, String marca, String placa, double velocidadeMaxima, int capacidadeTanque, double preco, Combustivel tipoCombustivel) {
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
		if (isOn) {
			if(qtdCombustivel>0) {
				if (this.velocidadeMaxima  >= (this.velocidade+valor)) {
					this.velocidade += valor;
					System.out.println("Veículo a "+velocidade+"km/h");
					perdeValor(valor);
					this.qtdCombustivel -= valor*tipoCombustivel.getKmPorLitro();
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

}
