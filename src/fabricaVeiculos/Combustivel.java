package fabricaVeiculos;

public interface Combustivel {	
	public double abastecer(double qtdLitros, int capacidadeTanque);
	public double getKmPorLitro();
	public void setKmPorLitro(double kmPorLitro);
}
