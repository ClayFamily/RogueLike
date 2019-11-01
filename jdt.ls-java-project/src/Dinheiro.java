import java.util.Random;

public class Dinheiro extends Objeto{
	
	public Dinheiro(Ponto2D posicao, char simbolo) {
		super(posicao,simbolo);
	}

	public void atualizar(Mundo mundo) {
		
	} 
	
	Random rand = new Random();
	public int valorTesouro = rand.nextInt(200) + 10;
}