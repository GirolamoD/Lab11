package it.polito.tdp.bar.model;

public class Event implements Comparable<Event>{
	
	public enum EventType {GRUPPO_APPENA_ARRIVATO , USCITA_GRUPPO}
	
	private int time ;
	private EventType tipo ;
	private Gruppo gruppo ;
	
	public Event(int time, EventType tipo, Gruppo gruppo) {
		this.time = time;
		this.tipo = tipo;
		this.gruppo = gruppo ;
	}

	@Override
	public int compareTo(Event other) {
		return this.time - other.time;
	}

	public int getTime() {
		return time;
	}

	public EventType getTipo() {
		return tipo;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}
	
	
	
}
