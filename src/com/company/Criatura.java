package com.company;



public class Criatura extends Entidade{
	
	public Criatura(Ponto2D posicao, String simbolo) {
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
