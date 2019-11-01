import br.unisal.aula.*;
public class AnimalIndefeso extends Entidade{
	
	public AnimalIndefeso(Ponto2D posicao, char simbolo) {
		super(posicao,simbolo);
	} 
	
    public void mover(Mundo mundo, int deltaX, int deltaY) {
        if (!mundo.bloqueado(posicao.getX() + deltaX, posicao.getY() + deltaY)) {
            posicao.setX(posicao.getX() + deltaX);
            posicao.setY(posicao.getY() + deltaY);
        }
    }
    public void atualizar(Mundo mundo) {

    }
}