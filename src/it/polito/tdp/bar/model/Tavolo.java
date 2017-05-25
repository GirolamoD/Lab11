package it.polito.tdp.bar.model;


public class Tavolo implements Comparable<Tavolo> {
		
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
	
	public void occupa(){
		this.occupato = true;
	}
	
	public void libera(){
		this.occupato = false ;
	}
	
	public int getCapienza(){
		return this.capienza;
	}

	public int compareTo(Tavolo other) {
		return other.capienza-this.capienza;
	}

	
	

}
