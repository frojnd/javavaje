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
	public Oseba() {
		//this("Janez", "Novak", "jn@jn.com", new GregorianCalendar(1980,3,2));

		ime = "";
		priimek = "";
		eposta = "";
		rojstniDatum = new GregorianCalendar();
	}
	
	// konstruktor razreda Oseba naj prejme parametra ime in priimek:
	// this zato, ker sta atribut in parameter enako poimenovana
	public Oseba(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
	}
	
	// z konstruktorjem ustvarim objekt ter z njim priredim vrednosti podatkom v razredu. 
	// brez konstruktorja bi moral veliko vec pisati:
	// Oseba o = new Oseba();
	// o.setIme("nekaj");
	// o.setPriimek("bla");
	// ...
	// z konstruktorjem pa samo Oseba o = new Oseba ("nekaj", "bla", ...);
	
	
	// metode set in get, da lahko dostopamo direktno do spremenljivk (ker so nastavlene private)
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
		
	public String getPriimek() {
		return priimek;
	}
	
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	
			
	public String getEposta() {
		return eposta;
	}
	
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	
	public GregorianCalendar getRojstniDatum() {
		return rojstniDatum;
	}
	
	public void setRojstniDatum(GregorianCalendar rojstniDatum) {
		this.rojstniDatum = rojstniDatum;
	}
	
	// metdoa za izpis osebe
	public void izpisOsebe() {
		System.out.println("Ime: " + ime );
		System.out.println("Priimek: " + priimek );
		System.out.println("E-posta: " + eposta );
		
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        System.out.println("RojstniDatum: " + df.format(rojstniDatum.getTime()) );		
        //System.out.println("RojstniDatum: " + rojstniDatum.getTime());
        // uporabim SimpleDateFormat drugače mi izpise takole: 
        // Thu May 07 00:00:00 CEST 1987
	}
	
	
}

