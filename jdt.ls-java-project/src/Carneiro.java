import br.unisal.aula.*;

public class Carneiro extends AnimalIndefeso{
	public static final char SIMBOLO = 'C';
    public static final int VISAO = 4;

	public Carneiro(Ponto2D posicao) {
		super(posicao, SIMBOLO);
	}
      @Override
    public void atualizar(Mundo mundo) {
        /*List<Integer> fuga = look_around(mundo);
        if(fuga.length > 0){
            mover(mundo, fuga[0], fuga[1]);
        }*/

        //else
        //if{
            int direcao = (int)(Math.random() * 1000) % 5;
            if (direcao == 1)
                mover(mundo, -1, 0);
            if (direcao == 2)
                mover(mundo, 0, -1);
            if (direcao == 3)
                mover(mundo, 0, 1);
            if (direcao == 4)
                mover(mundo, 1, 0);
            //}
    } 

    public void look_around(Mundo mundo){
       // mundo.entidades;

    }
}

