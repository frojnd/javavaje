/*
 * V razred Oddih vključite atribute naziv, destinacija, vodič, datum začetka oddiha, 
 * datum konca oddiha, cena ter število mest
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Oddih {
	private String naziv;
	private Destinacija destinacija;
	private Oseba vodic;
	private GregorianCalendar zacetekOddiha;
	private GregorianCalendar konecOddiha;
	private double cena;
	private int stMest;
	
	// privzeti konstruktor
	public Oddih() {
		//this("Morje", "Palma", new GregorianCalendar(2012,5,5), new GregorianCalendar(2012,6,6), 300.4, 4);
		naziv = "";
		destinacija = new Destinacija();
		vodic = new Oseba();
		zacetekOddiha = new GregorianCalendar();
		konecOddiha = new GregorianCalendar();
		cena = 0.0;
		stMest = 0;
	}
	
	// konstruktorja razreda Destinacija in Oddih naj prjmeta parameter naziv
	public Oddih(String naziv) {
		this.naziv = naziv;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
		
	public Destinacija getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	public Oseba getVodic() {
		return vodic;
	}
	
	public void setVodic(Oseba vodic) {
		this.vodic = vodic;
	}
	
		
	public GregorianCalendar getZacetekOddiha() {
		return zacetekOddiha;
	}
	
	public void setZacetekOddiha(GregorianCalendar zacetekOddiha) {
		this.zacetekOddiha = zacetekOddiha;
	}
	
		
	public GregorianCalendar getKonecOddiha() {
		return konecOddiha;
	}
	
	public void setKonecOddiha(GregorianCalendar konecOddiha) {
		this.konecOddiha = konecOddiha;
	}
	
		
	public double getCena() {
		return cena;
	}
	
	public void setCena(double cena) {
		this.cena = cena;
	}
	
		
	public int getStMest() {
		return stMest;
	}
	
	public void setStMest(int stMest) {
		this.stMest = stMest;
	}
	
	public void izpisi() {
		
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        
		System.out.println("Naziv: " + naziv);
		vodic.izpisOsebe();
		destinacija.izpisDestinacije();
		System.out.println("Zacetek: " + df.format(zacetekOddiha.getTime()));
		System.out.println("Konec: " + df.format(konecOddiha.getTime()));
		System.out.println("Cena: " + cena);
		System.out.println("St. mest:" + stMest);
	}	
}
