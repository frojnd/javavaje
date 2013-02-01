/* 1 naloga */

/* a) V sklopu naloge razvite 3 razrede: Oseba, Oddih in Destinacija. Razred Oseba naj ima 
 * atribute: ime, priimek, eposta, rojstni datum. Razred Destinacija naj ima atribute: naziv, 
 * lokacija, država. V razred Oddih vključite atribute naziv, destinacija, vodič, datum začetka 
 * oddiha, datum konca oddiha, cena ter število mest. Poskrbite, da bodo vsi atributi 
 * ustreznega podatkovnega tipa glede na tip podatka, ki ga hranijo.


b) Za vsakega izmed atributov implementiranih razredov Oseba, Oddih in Destinacija dodajte 
getter in setter metode.

c) Vsak izmed navedenih razredov naj ima poleg privzetega konstruktorja tudi konstruktorje, 
ki prejmejo naslednje parametre: konstruktor razreda Oseba naj prejme parametra ime in priimek, 
konstruktorja razreda Destinacija in Oddih pa parameter naziv. Parametri, ki jih prejmejo 
konstruktorji, naj dobo poimenovani enako kot njim pripadajoči atributi. 

d) Za zaključek implementirajte še testni razred Zagonski. V zagonski metodi omenjenega 
razreda omogočite, da bo uporabnik lahko vnesel podatke o oddihih ter vnesene oddihe 
izpisal na zaslon. Za vnos podatkov uporabite razred java.util.Scanner. Podrobnosti o razredu 
najdete v dokumentaciji Jave.
 * 
 * Cilji. Po opravljeni nalogi 1 morate obvladati koncepte, kot so »razred«, »objekt«, 
 * »referenca«, “konstruktor” ter “metode get/set”. Znati morate uporabljati tudi 
 * dokumentacijo javanskih razredov.
 */



/*
 * Razred Oseba naj ima atribute: ime, priimek, eposta, rojstni datum.
 */
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Oseba {
	private String ime;
	private String priimek;
	private String eposta;
	private GregorianCalendar rojstniDatum;
	
	// Privzeti konstruktor
	/**
	 * 
	 */
	public Oseba() {
		ime = "";
		priimek = "";
		eposta = "";
		rojstniDatum = new GregorianCalendar();
	}
	
	/**
	 * @param ime
	 * @param priimek
	 */
	public Oseba(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
	}
	
	
	/**
	 * @param ime
	 * @param priimek
	 * @param eposta
	 * @param rojstniDatum
	 */
	public Oseba(String ime, String priimek, String eposta, GregorianCalendar rojstniDatum) {
		this(ime, priimek); // klicemo konstruktor, da se koda ne podvaja
		this.eposta = eposta;
		this.rojstniDatum = rojstniDatum;
	}
	
	/**
	 * @return
	 */
	public String getIme() {
		return ime;
	}
	
	/**
	 * @param ime
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
		
	/**
	 * @return
	 */
	public String getPriimek() {
		return priimek;
	}
	
	/**
	 * @param priimek
	 */
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	
			
	/**
	 * @return
	 */
	public String getEposta() {
		return eposta;
	}
	
	/**
	 * @param eposta
	 */
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	
	/**
	 * @return
	 */
	public GregorianCalendar getRojstniDatum() {
		return rojstniDatum;
	}
	
	/**
	 * @param rojstniDatum
	 */
	public void setRojstniDatum(GregorianCalendar rojstniDatum) {
		this.rojstniDatum = rojstniDatum;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = new String();
		
		str = "\nIme: " + ime;
		str += "\nPriimek" + priimek;
		str += "\nE-posta: " + eposta;
		
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        
        str += "\nRojstni datum: " + df.format(rojstniDatum.getTime());
		
		return str;
	}
	
	
}

