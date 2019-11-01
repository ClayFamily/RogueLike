import br.unisal.aula.*;

public class Personagem extends Entidade {

    public Personagem(Ponto2D posicao, char simbolo) {
        super(posicao, simbolo);
    }

    public void mover(Mundo mundo, int deltaX, int deltaY) {
        if (!mundo.bloqueado(posicao.getX() + deltaX, posicao.getY() + deltaY)) {
            //System.out.println("Posicao: " + posicao.getX());
            //System.out.println("Delta: " + deltaX);
            posicao.setX(posicao.getX() + deltaX);
            posicao.setY(posicao.getY() + deltaY);
        }
    }

    public void look_around(){
        
        
    }
   public void atualizar(Mundo mundo) {    
}
}

