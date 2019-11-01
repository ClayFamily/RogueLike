/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.unisal.aula.*;

import java.util.Scanner;

public class Jogador extends Personagem {

    private int vidas;
    public int ouro;
    private int passos;
    private int level;
    private Scanner entrada;
    private int carne;
    private int fome;
    Tesouro tesouro;
    MundoBuilder mundoBuilder;

    public Jogador(int vidas, Ponto2D posicao, char simbolo, int ouro, int level, int carne, int fome) {
        super(posicao, simbolo);
        this.vidas = vidas;
        this.passos = 0;
        this.entrada = new Scanner(System.in);
        this.ouro = ouro;
        this.level = level;
        this.carne = carne;
        this.fome = fome;
    }

    public boolean vivo() {
        return vidas > 0;
    }

    public void tomarDano(int dano) {
        vidas -= dano;
    }
    
	@Override
    public void atualizar(Mundo mundo) {
        System.out.print("[A/W/S/D]: ");
        String comando = entrada.nextLine();
        if (comando.toUpperCase().trim().equals("A")) {
            mover(mundo, -1, 0); 
        }
        if (comando.toUpperCase().trim().equals("W")) {
            mover(mundo, 0, -1);
        }
        if (comando.toUpperCase().trim().equals("S")) {
            mover(mundo, 0, 1);
        }
        if (comando.toUpperCase().trim().equals("D")) {
            mover(mundo, 1, 0); 
        }

        passos++;
        		if (comando.toUpperCase().trim().equals("CURAR")) {
			if(vidas < 5) {
			carne -= 1;
			vidas += 1;
			}else if(vidas == 5){
				System.out.println("Você já está com a vida máxima!");
			}
			passos -= 1;
		}
    }
	
	public int mostrarVida() {
		return vidas;
	}
	
	public boolean morte() {
		return vidas <= 0;
	}
	
	public int mostrarOuro() {
		return ouro;
	}

	public void qtdCarne() {
		if(carne != 0) {
			char resposta;
			resposta = entrada.next().charAt(0);
			if(resposta == 's' || resposta == 'S') {
				if(vidas < 5) {
				carne -= 1;
				vidas += 1;
				}else if(vidas == 5){
					System.out.println("Você já está com a vida máxima!");
				}
			}else if(resposta == 'n' || resposta == 'N') {
				System.out.println("Tudo bem, tome cuidado guerreiro!");
			}	
		}
	}
    public void passarLevel() {
    	if(passos == 20 || passos == 40 || passos == 80 || passos == 160 || passos == 320 || passos == 640 || passos == 1280) {
    		level++;
    	}
    }
    public void passosCurar() {
		if(passos == 100 || passos == 300 || passos == 500 || passos == 700 || passos == 900 || passos == 1100 || passos == 1300) {
			System.out.println("Ponto Seguro!");
			System.out.println("Deseja se curar? (s/n)");
			char resp2;
			resp2 = entrada.next().charAt(0);
			if(resp2 == 's' || resp2 == 'S') {
				if(vidas < 5) {
				vidas += 1;
				}else {
					System.out.println("Você já está com a vida cheia!");
				}
			}else if(resp2 == 'n' || resp2 == 'N') {
				System.out.println("Boa Sorte!");
			}
		}
	}

  	public void passarFome() {
		if(passos == 40 || passos == 80 || passos == 120 || passos == 160) {
			fome += 1;
			if(fome >= 1) {
				System.out.println("Seu personagem está com fome! Deseja comer uma de suas carnes para se recuperar? (s/n)");
				char resposta = entrada.next().charAt(0);
				if((resposta == 's' || resposta == 'S') && (carne > 0) && (vidas < 5)) {
					fome -= 1;
					carne -= 1;
					vidas += 1;
					if(fome >= 5) {
						vidas -= 1;
					}
				}else if(vidas == 5){
					System.out.println("Você já está com a vida cheia!");
				}else if(carne == 0) {
					System.out.println("Você não possui carnes!");
				}		
			}
		}
	}

    public int mostrarLevel() {
    	passarLevel();
    	return level;
    }
    
    public int getvidas() {
    	return vidas;
    }
  	public int getCarne() {
		return carne;
	}

	public void setCarne(int carne) {
		this.carne = carne;
	}

  	public int qtdPassos() {
		return passos;
	}

  public int getFome(){
    return fome;
  }

  public int setFome(int fome){
    return this.fome;
  }
}

