package it.polito.tdp.bar.model;

import it.polito.tdp.bar.model.Event.EventType;
import it.polito.tdp.bar.model.Gruppo.StatoGruppo;

public class Model {
	
	
	public Model(){
	}
	
	public String process(){
		Simulator s = new Simulator();
		int time = 0 ;
		for(int i=0 ; i<2000 ; i++){
			int random = (int)(1+(Math.random()*10));
			int numPersone =  (int)(1+(Math.random()*10)) ;
			int durataPermanenza = (int)(60+(Math.random()/100)*60) ;
			float tolleranza = (float) Math.random() ;
			Gruppo g = new Gruppo(numPersone,durataPermanenza,tolleranza,StatoGruppo.APPENA_ARRIVATO);
			Event e = new Event(time+random, EventType.GRUPPO_APPENA_ARRIVATO, g) ;
			s.addEvent(e);
			time+=random ;
		}
		
		s.addTavolo(new Tavolo(10));
		s.addTavolo(new Tavolo(10));
		s.addTavolo(new Tavolo(8));
		s.addTavolo(new Tavolo(8));
		s.addTavolo(new Tavolo(8));
		s.addTavolo(new Tavolo(8));
		s.addTavolo(new Tavolo(6));
		s.addTavolo(new Tavolo(6));
		s.addTavolo(new Tavolo(6));
		s.addTavolo(new Tavolo(6));
		s.addTavolo(new Tavolo(4));
		s.addTavolo(new Tavolo(4));
		s.addTavolo(new Tavolo(4));
		s.addTavolo(new Tavolo(4));
		s.addTavolo(new Tavolo(4));
		
		s.run();
		return "Il risultato della simulazione è:" 
				+"\nGruppi insoddisfatti: "+ s.getGruppiInsoddisfatti() 
				+"\nGruppi seduti al bancone: " + s.getGruppiBancone() 
				+"\nGruppi seduti al tavolo: " +s.getGruppiTavolo() ;
	}
	
	
	
}
