package it.polito.tdp.bar.model;

public class Gruppo {
	
	public enum StatoGruppo {APPENA_ARRIVATO , IN_CONSUMAZIONE , USCITO } ;
	
	private int numeroPersone ;
	private int durataPermanenza ;
	private float tolleranza ;
	private StatoGruppo stato ;
	
	
	public Gruppo(int numeroPersone, int durataPermanenza, float tolleranza,StatoGruppo s) {
		this.numeroPersone = numeroPersone;
		this.durataPermanenza = durataPermanenza;
		this.tolleranza = tolleranza;
		this.stato = s ;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public int getDurataPermanenza() {
		return durataPermanenza;
	}

	public float getTolleranza() {
		return tolleranza;
	}
	
	public void setStato(StatoGruppo s){
		this.stato = s ;
	}

	/**
	 * Permette di sapere se il gruppo si accomoda al bancone o preferisce andare via
	 * @param random
	 * @return true se accetta di sedersi al bancone , false in caso contrario
	 */
	public boolean inOrOut (float random) {
		if(random<this.tolleranza)
			return true ;
		return false ;
	}
	
	
	

}
