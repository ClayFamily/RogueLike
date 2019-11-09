package com.company;

public class Portal extends PortalCosmico{
	public static final String SIMBOLO = "@";
	
	public boolean acesso = false; 
	
	public Portal(Ponto2D posicao) {
		super(posicao,SIMBOLO);
	}
	
	
}
