package it.polito.tdp.bar.model;

public class Tavolo {
		
	private int capienza ;
	private boolean occupato ;
	
	public Tavolo(int capienza) {
		super();
		this.capienza = capienza ;
		this.occupato = false ;
	}

	public boolean occupato(){
		return this.occupato ;
	}
	
	public int getCapienza(){
		return this.capienza;
	}

	
	

}
