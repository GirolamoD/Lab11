package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;
import it.polito.tdp.bar.model.Gruppo.StatoGruppo;

public class Simulator {
	
	//Parameters
	private List<Tavolo> tavoli  ;
	private int NT ;
	
	// World State 
	// apparentemente vuoto; in realtà all'interno dei tavoli ho l'informazione
	//sull'occupazione e quello farebbe teoricamente parte del World State 
	private int tavoliOccupati = 0 ;
	
	
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
	
	public void addTavolo(Tavolo t){
		this.tavoli.add(t);
		Collections.sort(this.tavoli);;
	}
	
	public void run(){
		this.NT=tavoli.size();
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
		Gruppo g = e.getGruppo();
		g.getTavolo().libera();
		g.setStato(StatoGruppo.USCITO);
		this.tavoliOccupati--;
		
	}

	private void gestisciGruppo(Event e) {
		Gruppo g = e.getGruppo() ;
		Tavolo t = cercaTavolo(g.getNumeroPersone());

		if(this.tavoliOccupati==this.NT || t==null){
			//prova a indirizzare verso il bancone perchè non ci sono tavoli liberi
			float r = (float) Math.random() ;
			if(r<g.getTolleranza()){
				this.gruppiBancone++;
				g.setStato(StatoGruppo.USCITO);
			} else {
				g.setStato(StatoGruppo.USCITO);
				this.gruppiInsoddisfatti++;
			}
			return ;
		}
		
		if(g.getNumeroPersone()<0.5*t.getCapienza()){
			/*
			 * Provo a indirizzarli verso il bancone e ho due scenari:
			 * accettano il bancone oppure scelgono comunque il tavolo
			 */
			float r = (float) Math.random() ;
			if(r<g.getTolleranza()){
				this.gruppiBancone++;
				g.setStato(StatoGruppo.USCITO);
				return ;
			} else {
				g.setStato(StatoGruppo.IN_CONSUMAZIONE);
				g.setTavolo(t);
				t.occupa();
				this.tavoliOccupati++;
				this.gruppiTavolo++ ;
				this.queue.add(new Event(e.getTime()+g.getDurataPermanenza(), EventType.USCITA_GRUPPO, g));
				return ;
			}
		} else {
			//Il numero di persone è adeguato e sistemo subito il gruppo nel tavolo
			g.setStato(StatoGruppo.IN_CONSUMAZIONE);
			g.setTavolo(t);
			t.occupa();
			this.tavoliOccupati++;
			this.gruppiTavolo++;
			this.queue.add(new Event(e.getTime()+g.getDurataPermanenza(), EventType.USCITA_GRUPPO, g));
			return ;
		}
		
	}

	/**
	 * Metodo rapido per la ricerca del miglior tavolo disponibile
	 * in base al numero di persone che compongono il gruppo
	 * @param numeroPersone
	 * @return Il tavolo con la minor capienza che sia in grado di contenere il gruppo
	 */
	private Tavolo cercaTavolo(int numeroPersone) {
		for(int i=0 ; i<tavoli.size() ; i++)
			if(this.tavoli.get(i).getCapienza()>=numeroPersone && !this.tavoli.get(i).occupato())
				return tavoli.get(i);
		return null;
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
