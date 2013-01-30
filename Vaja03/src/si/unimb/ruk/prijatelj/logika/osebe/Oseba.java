/*
 * Vključitveni polimorfizem je posledica tega da lahko eno samo ime predstavlja objekte različnih razredov,
 * ki so povezani z nekim skupnim nadrazredom (ali vmesnikom)
 * 
 * Abstraktni razred ima vsaj eno abstraktno metodo  (ni določena implementacija) vrniPonudbo
 * Abs razred neposredno ne more imeti primerkov
 * 
 * istantiacija ni možna - ne moremo ustvart primerkov abstraktnega razreda
 * abstraktna metoda nima telesa, signaturo zaklučuje podpičje
 * 
 * podrazred abs razreda lahko instaciramo le če ta implementira vse abs metode sicer je tudi podrazred abstrakten
 * 
 * new ne moremo uporabit pri abstrakt razredih
 */

package si.unimb.ruk.prijatelj.logika.osebe;
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

/**
 * @author Joze
 *
 */
public abstract class Oseba {
	private String ime;
	private String priimek;
	private String eposta;
	private GregorianCalendar rojstniDatum;
	
	// Privzeti konstruktor
	/**
	 * 
	 */
	public Oseba() {
		//this("Janez", "Novak", "jn@jn.com", new GregorianCalendar(1980,3,2));

		ime = "";
		priimek = "";
		eposta = "";
		rojstniDatum = new GregorianCalendar();
	}
	
	// konstruktor razreda Oseba naj prejme parametra ime in priimek:
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
		this(ime,priimek);
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
	
	public String toString() {
		String str = new String();
		str = "Ime: " + ime + "\n";
		str = str + "Priimek: " + priimek + "\n";
		str = str + "E-posta: " + eposta + "\n";
		
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        str= str + "RojstniDatum: " + df.format(rojstniDatum.getTime());		
        
		return str;
	}
	
	// metoda za izracun starost
	/**
	 * @return
	 */
	public int izracunStarosti() {
		GregorianCalendar danes = new GregorianCalendar();
		//leto = String.valueOf(danes.get(GregorianCalendar.YEAR));
		return danes.get(GregorianCalendar.YEAR) - rojstniDatum.get(GregorianCalendar.YEAR);
	}
}

