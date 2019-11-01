import br.unisal.aula.*;

public class Lobo extends AtaqueLobo{
	public static final char SIMBOLO = 'L';
	MundoBuilder mb;
	Carneiro cn;
	
	public Lobo(Ponto2D posicao) {
		super(posicao,SIMBOLO);
	}
	
    @Override
    public void atualizar(Mundo mundo) {
        int direcao = (int)(Math.random() * 1000) % 5;
        if (direcao == 1)
            mover(mundo, -1, 0);
        if (direcao == 2)
            mover(mundo, 0, -1);
        if (direcao == 3)
            mover(mundo, 0, 1);
        if (direcao == 4)
            mover(mundo, 1, 0);
    }
}

