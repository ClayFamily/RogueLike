package com.company;

import java.util.ArrayList;
import java.util.List;

public class MundoBuilder{

    private final int largura, altura;
    private Celula[][] mapa;
    private List<Criatura> criaturas = new ArrayList<>();
    private List<Objeto> objetos = new ArrayList<>();
    private List<AnimalIndefeso> carneirosPutassos = new ArrayList<>();
    private List<Dinheiro> muitaGrana = new ArrayList<>();
    private List<Acesso> acessoFacin = new ArrayList<>();
    private List<PortalCosmico> portalLoko = new ArrayList<>();
    private List<PortalCosmico2> portalLoko2 = new ArrayList<>();
    private List<PortalCosmico3> portalLoko3 = new ArrayList<>();
    private List<FinalGame> finalMassa = new ArrayList<>();
    private List<AtaqueLobo> lobinhu = new ArrayList<>();
    private int xLobo, yLobo;
    private int xZumbi, yZumbi;
    private int xChave, yChave;
    private int xCarneiro;
    private int yCarneiro;
    private int xSaida;
    private int ySaida;
    private int xTesouro, yTesouro;
    private int xPortal, yPortal;

    public MundoBuilder(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;

    }
    public double calcDistancia(int x1, int y1, int x2, int y2) {  	
    	return Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
    }

    MundoBuilder preencher(String simbolo, boolean bloqueado) {
        mapa = new Celula[largura][altura];
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                Ponto2D posicao = new Ponto2D(x, y);
                mapa[x][y] = new Celula(bloqueado, posicao, simbolo);
            }
        }
        return this;
    }

    MundoBuilder criarCaminho(int x, int y, int passos) {
        mapa[x][y].setSimbolo(".");
        mapa[x][y].setBloqueado(false);

        for (int i = 0; i < passos; i++) {
            int direcao = (int) (Math.random() * 1000) % 4;
            if (direcao == 0 && (x + 1) < largura - 1) {
                x++;
            } else if (direcao == 1 && (x - 1) > 0) {
                x--;
            } else if (direcao == 2 && (y + 1) < altura - 1) {
                y++;
            } else if (direcao == 3 && (y - 1) > 0) {
                y--;
            }

            mapa[x][y].setSimbolo(".");
            mapa[x][y].setBloqueado(false);
        }

        return this;
    }
    
    MundoBuilder criarZumbi(int qntZumbi) {
        for (int i = 0; i < qntZumbi; i++) {
            do {
            	xZumbi = (int) (Math.random() * 1000 % largura);
            	yZumbi = (int) (Math.random() * 1000 % altura);
            } while (mapa[xZumbi][yZumbi].isBloqueado());
            Criatura zumbi = new Zumbi(new Ponto2D(xZumbi,yZumbi)); 
            criaturas.add(zumbi);
        }
        return this;
    }
    MundoBuilder criarLobo(int qntLobo) {
        for (int i = 0; i < qntLobo; i++) {

            do {
            	xLobo = (int) (Math.random() * 1000 % largura);
                yLobo = (int) (Math.random() * 1000 % altura);
            } while (mapa[xLobo][yLobo].isBloqueado());

            AtaqueLobo lobo = new Lobo(new Ponto2D(xLobo, yLobo)); 
            lobinhu.add(lobo);
        }
        return this;
    }
    MundoBuilder criarCarneiro(int qntCarneiro) {
        for (int i = 0; i < qntCarneiro; i++) {

            do {
            	xCarneiro = (int) (Math.random() * 1000 % largura);
            	yCarneiro = (int) (Math.random() * 1000 % altura);
            } while (mapa[xCarneiro][yCarneiro].isBloqueado());
            AnimalIndefeso carneiro = new Carneiro(new Ponto2D(xCarneiro,yCarneiro)); 
            carneirosPutassos.add(carneiro);
        }
        

        
        return this;
}

    
    MundoBuilder criarChave(int qtdChave) {
        
        for (int i = 0; i < qtdChave; i++) {
            do {
                xChave = (int) (Math.random() * 1000 % largura);
                yChave = (int) (Math.random() * 1000 % altura);
            } while (mapa[xChave][yChave].isBloqueado() || calcDistancia(xChave, yChave, largura/2, altura/2)<20);
            Acesso chave = new Chave(new Ponto2D(xChave,yChave)); 
            acessoFacin.add(chave);
        }
        return this;
    }
    
    MundoBuilder criarPortal(int qtdPortal) {
        for (int i = 0; i < qtdPortal; i++) {
            do {
            	xPortal = (int) (Math.random() * 1000 % largura);
                yPortal = (int) (Math.random() * 1000 % altura);
            } while (mapa[xPortal][yPortal].isBloqueado() || calcDistancia(xChave, yChave, xPortal, yPortal)<20);

            PortalCosmico portal = new Portal(new Ponto2D(xPortal, yPortal)); 
            portalLoko.add(portal);
        }
        return this;
    }
    
    MundoBuilder criarPortal2(int qtdPortal) {
        
        for (int i = 0; i < qtdPortal; i++) {
            do {
            	xPortal = (int) (Math.random() * 1000 % largura);
                yPortal = (int) (Math.random() * 1000 % altura);
            } while (mapa[xPortal][yPortal].isBloqueado());

            PortalCosmico2 portal2 = new Portal2(new Ponto2D(xPortal, yPortal)); 
            portalLoko2.add(portal2);
        }
        return this;
    }
    
    MundoBuilder criarSaida(int qtdSaida) {
        
        for (int i = 0; i < qtdSaida; i++) {
            do {
            	xSaida = (int) (Math.random() * 1000 % largura);
            	ySaida = (int) (Math.random() * 1000 % altura);
            } while (mapa[xSaida][ySaida].isBloqueado());

            FinalGame finalGame = new Saida(new Ponto2D(xSaida, ySaida)); 
            finalMassa.add(finalGame);
        }
        return this;
    }
    
    MundoBuilder criarPortal3(int qtdPortal) {
        
        for (int i = 0; i < qtdPortal; i++) {
            do {
            	xPortal = (int) (Math.random() * 1000 % largura);
                yPortal = (int) (Math.random() * 1000 % altura);
            } while (mapa[xPortal][yPortal].isBloqueado());

            PortalCosmico3 portal3 = new Portal3(new Ponto2D(xPortal, yPortal)); 
            portalLoko3.add(portal3);
        }
        return this;
    }
    
    MundoBuilder criarTesouro(int qtdTesouro) {
        
        for (int i = 0; i < qtdTesouro; i++) {
            do {
            	xTesouro = (int) (Math.random() * 1000 % largura);
            	yTesouro = (int) (Math.random() * 1000 % altura);
            } while (mapa[xTesouro][yTesouro].isBloqueado());

            Dinheiro tesouro = new Tesouro(new Ponto2D(xTesouro, yTesouro)); 
            muitaGrana.add(tesouro);
        }
        return this;
    }
    
    
    
    public Mundo build() {
        return new Mundo(mapa, criaturas, objetos, carneirosPutassos, muitaGrana, acessoFacin, portalLoko, lobinhu,portalLoko2,portalLoko3,finalMassa);
    }
    
}
