package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Simulator {
	
	//Parameters
	private List<Tavolo> tavoli  ;
	
	// World State 
	// apparentemente vuoto; in realtà all'interno dei tavoli ho l'informazione
	//sull'occupazione e quello farebbe teoricamente parte del World State 
	
	
	// Measure of interest 
	int gruppiBancone = 0 ;
	int gruppiTavolo = 0 ;
	int gruppiInsoddisfatti = 0 ;
	
	//Evente queue
	PriorityQueue<Event> queue;
	
	public Simulator(){
		this.queue = new PriorityQueue<>();
		this.tavoli = new ArrayList<>();
	}
	
	public void addEvent(Event e){
		this.queue.add(e);
	}
	
	public void run(){
		while(!this.queue.isEmpty()){
			
			Event e = queue.poll() ;
			
			switch(e.getTipo()){
			case GRUPPO_APPENA_ARRIVATO:
				gestisciGruppo(e);
				break;
			case USCITA_GRUPPO:
				liberaTavolo(e);
				break ;
			
			}
			
		}
	}

	


	private void liberaTavolo(Event e) {
		
	}

	private void gestisciGruppo(Event e) {
		
	}

	public int getGruppiBancone() {
		return gruppiBancone;
	}

	public int getGruppiTavolo() {
		return gruppiTavolo;
	}

	public int getGruppiInsoddisfatti() {
		return gruppiInsoddisfatti;
	}
	
	
	
}
