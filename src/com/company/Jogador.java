/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
import java.util.Scanner;

public class Jogador extends Personagem {

	private int vidas;
	private int ouro;
	private int deposito;
	private int passos;
	private int level;
	private Scanner entrada;
	private int carne;

	public Jogador(int vidas, Ponto2D posicao, String simbolo, int ouro, int level, int carne,int deposito) {
		super(posicao, simbolo);
		this.vidas = vidas;
		this.passos = 0;
		this.entrada = new Scanner(System.in);
		this.ouro = ouro;
		this.level = level;
		this.carne = carne;
		this.deposito = deposito;
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
			if(vidas < 5 && carne >= 1) {
			carne -= 1;
			vidas += 1;
			}else if(vidas == 5){
				System.out.println("Voc� j� est� com a vida m�xima!");
			}else if(carne == 0){
                                System.out.println("Voc� n�o possui carnes!");
                        }
			passos -= 1;
		}
		if(comando.toUpperCase().trim().equals("SACAR")) {
			if(deposito > 0) {
				System.out.println("Deseja sacar quanto? : ");
				int saque = entrada.nextInt();
				saqueBanco(saque);
				ouro += saque;
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
					System.out.println("Voc� j� est� com a vida m�xima!");
				}
			}else if(resposta == 'n' || resposta == 'N') {
				System.out.println("Tudo bem, tome cuidado guerreiro!");
			}	
		}
	}

	public void passarLevel() {
		if (passos == 20 || passos == 40 || passos == 80 || passos == 160 || passos == 320 || passos == 640
				|| passos == 1280) {
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
					System.out.println("Voc� j� est� com a vida m�xima!");
				}
			}else if(resp2 == 'n' || resp2 == 'N') {
				System.out.println("Boa Sorte!");
			}
		}
	}
	
	boolean jogadorEspada1 = false;
	boolean jogadorArmadura = false;
	boolean jogadorDeposito = false;
	
	public void usarOuro() {
		if(ouro >= 100) {
			System.out.println("-------------------------------------------------");
			System.out.println();
			System.out.printf("Voc� tem %d de Gold, deseja comprar: ",ouro);
			System.out.println();
			System.out.println();
			System.out.println("1 - Espada ($100)");
			System.out.println("2 - Armadura ($120)");
			System.out.println("3 - Guardar no Banco (M�n $100)");
			System.out.println();
			System.out.println("-------------------------------------------------");
			char _resposta = entrada.next().charAt(0);
			if(_resposta == '1') {
				System.out.println("Voc� adquiriu a ESPADA de GRYFFINDOR!");
				ouro -= 100;
				jogadorEspada1 = true;
			}else if(_resposta == '2') {
				if(ouro >= 120) {
				System.out.println("Voc� adquiriu a rel�quia da morte, a ARMADURA!");
				ouro -= 120;
				jogadorArmadura = true;
				}else {
					System.out.println("Voc� n�o tem dinheiro suficiente!");
				}
			}else if(_resposta == '3' && ouro >= 100) {
				System.out.println("Voc� escolheu GUARDAR NO BANCO!");
				System.out.println();
				System.out.print("Digite a quantia que deseja depositar: ");
				int deposito = entrada.nextInt();
				if(deposito >= 100) {
				depositoBanco(deposito);
				ouro -= deposito;
				}else {
					System.out.println("N�o pode depositar!");
				}
				jogadorDeposito = true;
			}
		}
	}
	
	public void depositoBanco(int quantia) {
		deposito += quantia;
	}
	
	public void saqueBanco(int quantia) {
		deposito -= quantia;
	}

	public int mostrarLevel() {
		passarLevel();
		return level;
	}
	public int getOuro() {
		return ouro;
	}

	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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
	
	public int getDeposito() {
		return deposito;
	}

}
