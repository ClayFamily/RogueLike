package com.company;

public class Portal2 extends PortalCosmico2{
	public static final String SIMBOLO = "@";
	
	public boolean acesso = false; 
	
	public Portal2(Ponto2D posicao) {
		super(posicao,SIMBOLO);
	}
	
	
}