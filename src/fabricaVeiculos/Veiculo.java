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

	// construtor
	public Veiculo(String cor, String marca, String placa, double velocidadeMaxima) {
		super();
		this.cor = cor;
		this.marca = marca;
		this.placa = placa;
		this.velocidadeMaxima = velocidadeMaxima;
		this.velocidade = 0;
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
			if (this.velocidadeMaxima  >= (this.velocidade+valor)) {
				this.velocidade += valor;
				System.out.println("Veículo a "+velocidade+"km/h");
			}else {
				System.out.println("O veículo atingiu a velocidade máxima de "+velocidadeMaxima+"km/h");
				this.velocidade = velocidadeMaxima;
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

}
