package com.company;

public class Celula extends Entidade {
    
    private boolean bloqueado;

    public Celula(boolean bloqueado, Ponto2D posicao, String simbolo) {
        super(posicao, simbolo);
        this.bloqueado = bloqueado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
