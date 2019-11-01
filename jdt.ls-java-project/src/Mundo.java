import br.unisal.aula.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pdjkl
 */
public class Mundo {

    private Celula[][] mapa;
    //private List<Entidade> entidades;
    private List<Criatura> criaturas;
    private List<Objeto> objetos;
    private List<AnimalIndefeso> carneirosPutassos;
    private List<Dinheiro> muitaGrana;
	private List<Acesso> acessoFacin;
	private List<PortalCosmico> portalLoko;
  	private List<PortalCosmico2> portalLoko2;
	private List<PortalCosmico3> portalLoko3;
	private List<FinalGame> finalMassa;
  	private List<AtaqueLobo> lobinhu;
    private Jogador jogador;
    private Jogo jg;

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Mundo(Celula[][] mapa, List<Criatura> criaturas, List<Objeto> objetos, List<AnimalIndefeso> carneirosPutassos,List<Dinheiro> muitaGrana,       List<Acesso> acessoFacin, List<PortalCosmico> portalLoko
    , List<AtaqueLobo> lobinhu,List<PortalCosmico2> portalLoko2,List<PortalCosmico3> portalLoko3,
			List<FinalGame> finalMassa) {
        this.mapa = mapa;
        this.criaturas = criaturas;
        this.objetos = objetos;
        this.carneirosPutassos = carneirosPutassos;
        this.muitaGrana = muitaGrana;
		this.acessoFacin = acessoFacin;
		this.portalLoko = portalLoko;
        //this.entidades = map_entidades(entidades);
        		this.portalLoko2 = portalLoko2;
		this.portalLoko3 = portalLoko3;
    this.finalMassa = finalMassa;
    this.lobinhu = lobinhu;
    }

    public boolean bloqueado(int x, int y) {
        return mapa[x][y].isBloqueado();
    }

    public void atualizar() {
        jogador.atualizar(this);
        for (Criatura criatura : criaturas) {
            criatura.atualizar(this);
            if (criatura.posicao.getX() == jogador.posicao.getX()
                    && criatura.posicao.getY() == jogador.posicao.getY()) {
                jogador.tomarDano(1);
            }
        }
        for (Objeto objeto : objetos) {
            objeto.atualizar(this);
            if (objeto.posicao.getX() == jogador.posicao.getX()
                    && objeto.posicao.getY() == jogador.posicao.getY()) {
                objeto.simbolo = '.';
            }
        }
        for (AnimalIndefeso carneiro : carneirosPutassos) {
			      carneiro.atualizar(this);
            			if (jogador.posicao.getX() == carneiro.posicao.getX()
					&& jogador.posicao.getY() == carneiro.posicao.getY()) {
				jogador.setCarne(jogador.getCarne() + 1);
				System.out.printf("Você tem %d carnes, deseja comer para recuperar 1 vida? (s/n)", jogador.getCarne());
				jogador.qtdCarne();
				carneiro.simbolo = '.';
				carneiro.posicao.setX(carneiro.posicao.getX() + 3);
				carneiro.posicao.setY(carneiro.posicao.getY() + 3);
				
			}
		}
    		for (Dinheiro dinheiro : muitaGrana) {
			dinheiro.atualizar(this);
				if (jogador.posicao.getX() == dinheiro.posicao.getX()
						&& jogador.posicao.getY() == dinheiro.posicao.getY()) {
					jogador.ouro += dinheiro.valorTesouro;
					dinheiro.simbolo = '.';
					dinheiro.posicao.setX(dinheiro.posicao.getX() + 3);
					dinheiro.posicao.setY(dinheiro.posicao.getY() + 3);
				}
		}
		for (Acesso acesso : acessoFacin) {
			acesso.atualizar(this);
				if (jogador.posicao.getX() == acesso.posicao.getX()
						&& jogador.posicao.getY() == acesso.posicao.getY()) {
					acesso.acessoChave = true;
					if(acesso.acessoChave == true) {
						acesso.acessoPortal = true;
					}
					acesso.simbolo = '.';
					acesso.posicao.setX(acesso.posicao.getX() + 3);
					acesso.posicao.setY(acesso.posicao.getY() + 3);
				}
		}
		
		for (PortalCosmico portalcosmico : portalLoko) {
			portalcosmico.atualizar(this);
			for(Acesso acesso : acessoFacin) {
				if((jogador.posicao.getX() == portalcosmico.posicao.getX() && jogador.posicao.getY() == portalcosmico.posicao.getY()) && acesso.acessoPortal == true) {
					jg = new Jogo(40, 30);
					jg.executar2();
				}
			}

		} 
    		for (PortalCosmico2 portalcosmico2 : portalLoko2) {
			portalcosmico2.atualizar(this);
			for(Acesso acesso : acessoFacin) {
				if((jogador.posicao.getX() == portalcosmico2.posicao.getX() && jogador.posicao.getY() == portalcosmico2.posicao.getY()) && acesso.acessoPortal == true) {
					jg = new Jogo(40, 30);
					jg.executar3();
				}
			}

		}
		
		for (PortalCosmico3 portalcosmico3 : portalLoko3) {
			portalcosmico3.atualizar(this);
			for(Acesso acesso : acessoFacin) {
				if((jogador.posicao.getX() == portalcosmico3.posicao.getX() && jogador.posicao.getY() == portalcosmico3.posicao.getY()) && acesso.acessoPortal == true) {
					jg = new Jogo(40, 30);
					jg.executar4();
				}
			}

		}
    		
		for (AtaqueLobo lobo : lobinhu) {
			lobo.atualizar(this);
			if (lobo.posicao.getX() == jogador.posicao.getX()
					&& lobo.posicao.getY() == jogador.posicao.getY()) {
				jogador.tomarDano(1);
			}
		}
    		for (FinalGame finalGame : finalMassa) {
			finalGame.atualizar(this);
			for(Acesso acesso : acessoFacin) {
				if((jogador.posicao.getX() == finalGame.posicao.getX() && jogador.posicao.getY() == finalGame.posicao.getY()) && acesso.acessoPortal == true) {
					System.out.println();
					System.out.println();
					System.out.println("-----------------------------------------------");
					System.out.println("Parabéns, Você concluiu o jogo!");
					System.out.println("-----------------------------------------------");
					System.out.println();
					System.out.println();
					System.exit(0);
					
				}
			}

		}
    }


    public void desenhar() {

        // Criar um mapa de criaturas baseado em suas posicoes
        Map<String, Entidade> map = new HashMap<>();
        for (Criatura criatura : criaturas) {
            map.put(criatura.posicao.toString(), criatura);
        }
        for (Objeto objeto : objetos) {
            map.put(objeto.posicao.toString(), objeto);
        }
        for (AnimalIndefeso carneiro : carneirosPutassos) {
            map.put(carneiro.posicao.toString(), carneiro);
        }
        for (Dinheiro dinheiro : muitaGrana) {
			map.put(dinheiro.posicao.toString(), dinheiro);
		}
		for (Acesso acesso : acessoFacin) {
			map.put(acesso.posicao.toString(), acesso);
		}
		for (PortalCosmico portalcosmico : portalLoko) {
			map.put(portalcosmico.posicao.toString(), portalcosmico);
		}
    		for (FinalGame saida : finalMassa) {
			map.put(saida.posicao.toString(), saida);
		}
    		for (PortalCosmico2 portalcosmico2 : portalLoko2) {
			map.put(portalcosmico2.posicao.toString(), portalcosmico2);
		}
		for (PortalCosmico3 portalcosmico3 : portalLoko3) {
			map.put(portalcosmico3.posicao.toString(), portalcosmico3);
		}
    		for (AtaqueLobo lobo : lobinhu) {
			map.put(lobo.posicao.toString(), lobo);
		}
        
        // Adicionamos também o jogador no mapa
         map.put(jogador.posicao.toString(), jogador);


        for (int y = 0; y < mapa[0].length; y++) {
            for (int x = 0; x < mapa.length; x++) {
                Ponto2D posicao = new Ponto2D(x, y);
                if (map.containsKey(posicao.toString())) {
                    Entidade entidades = (Entidade) map.get(posicao.toString());
                    System.out.print(entidades);
                }else {
                    System.out.print(mapa[x][y].simbolo);
                }
        }
        System.out.println();
    }
    
}
    /*private Map map_entidades(List<Entidade> entidades){
        Map<String, Entidade> ent_map = new HashMap<>();
        for (Entidade ent : entidades) {
            ent_map.put(ent.posicao.toString(), ent);
        }
        return ent_map;
    }*/
}