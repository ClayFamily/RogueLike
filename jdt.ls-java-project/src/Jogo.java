import br.unisal.aula.*;

public class Jogo {
	private Mundo mundo;
	private Jogador jogador;
	private Chave chave;
	private int largura, altura;

	public Jogo(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
	}

	void criarMundo1() {

		int x = largura / 2;
		int y = altura / 2;
		int passo = 2000;

		jogador = new Jogador(5, new Ponto2D(x, y), 'J', 0, 1, 0, 0);
		mundo = new MundoBuilder(largura, altura)
				.preencher('#', true)
				.criarCaminho(x, y, passo)
				//.criarCarneiro(10)
				.criarPortal(1)
				.criarChave(1)
				.criarTesouro(1)
				.build();

		mundo.setJogador(jogador);
	}

	void criarMundo2() {
		int x = largura / 2;
		int y = altura / 2;
		int passo = 5000;

		jogador = new Jogador(5, new Ponto2D(x, y), 'J', 0, 1, 0, 0);
		mundo = new MundoBuilder(largura, altura)
				.preencher('#', true)
				.criarCaminho(x, y, passo)
				//.criarZumbi(5)
				//.criarCarneiro(10)
        //.criarLobo(2)
				.criarPortal2(1)
				.criarChave(1)
				.criarTesouro(1)
				.build();

		mundo.setJogador(jogador);
	}

	void criarMundo3() {
		int x = largura / 2;
		int y = altura / 2;
		int passo = 7000;

		jogador = new Jogador(5, new Ponto2D(x, y), 'J', 0, 1, 0, 0);
		mundo = new MundoBuilder(largura, altura)
				.preencher('#', true)
				.criarCaminho(x, y, passo)
				//.criarZumbi(10)
				//.criarCarneiro(10)
				//.criarLobo(5)
				.criarPortal3(1)
				.criarChave(1)
				.criarTesouro(1)
				.build();

		mundo.setJogador(jogador);
	}

  	void criarMundo4() {
		int x = largura / 2;
		int y = altura / 2;
		int passo = 10000;

		jogador = new Jogador(5, new Ponto2D(x, y), 'J', 0, 1, 0, 0);
		mundo = new MundoBuilder(largura, altura)
				.preencher('#', true)
				.criarCaminho(x, y, passo)
				//.criarZumbi(20)
				//.criarCarneiro(10)
				//.criarLobo(7)
				.criarSaida(1)
				.criarChave(1)
				.criarTesouro(1)
				.build();

		mundo.setJogador(jogador);
	}

	public void executar() {
		criarMundo1();
		while (jogador.vivo()) {
			mundo.desenhar();
			jogador.passosCurar();
      jogador.passarFome();
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Fase 1 ");
			System.out.println();
			System.out.println("Quantidade de passos dados: " + jogador.qtdPassos());
      System.out.println();
      System.out.println("Fome: " + jogador.getFome());
			System.out.println();
			System.out.println("Suas vidas:  " + jogador.mostrarVida());
			System.out.println("Seu ouro:    " + jogador.mostrarOuro());
			System.out.println("Seu level:   " + jogador.mostrarLevel());
			System.out.println("Suas carnes: " + jogador.getCarne());
			System.out.println("----------------------------------");
			mundo.atualizar();
		}
		do {
			System.out.println();
			System.out.println("*********************");
			System.out.println("Você está morto!");
			System.out.println("*********************");
			System.out.println();
			break;
		} while (jogador.morte());
	}
  	public void executar2() {
		criarMundo2();
		while (jogador.vivo()) {
			mundo.desenhar();
			jogador.passosCurar();
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Fase 2 ");
			System.out.println();
			System.out.println("Quantidade de passos dados: " + jogador.qtdPassos());
			System.out.println();
			System.out.println("Suas vidas:  " + jogador.mostrarVida());
			System.out.println("Seu ouro:    " + jogador.mostrarOuro());
			System.out.println("Seu level:   " + jogador.mostrarLevel());
			System.out.println("Suas carnes: " + jogador.getCarne());
			System.out.println("----------------------------------");
			mundo.atualizar();		
		}
		do {
			System.out.println();
			System.out.println("*********************");
			System.out.println("Você está morto!");
			System.out.println("*********************");
			System.out.println();
			break;
		} while (jogador.morte());
	}
	
	public void executar3() {
		criarMundo3();
		while (jogador.vivo()) {
			mundo.desenhar();
			jogador.passosCurar();
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Fase 3 ");
			System.out.println();
			System.out.println("Quantidade de passos dados: " + jogador.qtdPassos());
			System.out.println();
			System.out.println("Suas vidas:  " + jogador.mostrarVida());
			System.out.println("Seu ouro:    " + jogador.mostrarOuro());
			System.out.println("Seu level:   " + jogador.mostrarLevel());
			System.out.println("Suas carnes: " + jogador.getCarne());
			System.out.println("----------------------------------");
			mundo.atualizar();		
		}
		do {
			System.out.println();
			System.out.println("*********************");
			System.out.println("Você está morto!");
			System.out.println("*********************");
			System.out.println();
			break;
		} while (jogador.morte());
	}
	
	public void executar4() {
		criarMundo4();
		while (jogador.vivo()) {
			mundo.desenhar();
			jogador.passosCurar();
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Fase 4 ");
			System.out.println();
			System.out.println("Quantidade de passos dados: " + jogador.qtdPassos());
			System.out.println();
			System.out.println("Suas vidas:  " + jogador.mostrarVida());
			System.out.println("Seu ouro:    " + jogador.mostrarOuro());
			System.out.println("Seu level:   " + jogador.mostrarLevel());
			System.out.println("Suas carnes: " + jogador.getCarne());
			System.out.println("----------------------------------");
			mundo.atualizar();		
		}
		do {
			System.out.println();
			System.out.println("*********************");
			System.out.println("Você está morto!");
			System.out.println("*********************");
			System.out.println();
			break;
		} while (jogador.morte());
	}
}