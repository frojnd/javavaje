package si.unimb.ruk.prijatelj.logika.osebe;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * @author Joze
 *
 */
public class Potnik extends Oseba implements Serializable{
	private String kontaktnaStevilka;
	private String naslov;
	private String posta;
	private String postnaStevilka;
	private Placilo stanjePlacila;
	
	public enum Placilo {rezerviral, placal}
	
	/**
	 * 
	 */
	public Potnik() {
		super();
		kontaktnaStevilka = new String();
		naslov = new String();
		posta = new String();
		postnaStevilka = new String();				
	}
	
	public Potnik(String ime, String priimek, String eposta, GregorianCalendar rojDatum, String kontaktnaStevilka, String naslov, String posta, String postnaStevilka)
	{
		super(ime, priimek, eposta, rojDatum);
		this.kontaktnaStevilka = kontaktnaStevilka;
		this.naslov = naslov;
		this.posta = posta;
		this.postnaStevilka = postnaStevilka;		
	}
	
	public String getKontaktnaStevilka() {
		return kontaktnaStevilka;
	}
	public void setKontaktnaStevilka(String kontaktnaStevilka) {
		this.kontaktnaStevilka = kontaktnaStevilka;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getPosta() {
		return posta;
	}
	public void setPosta(String posta) {
		this.posta = posta;
	}
	public String getPostnaStevilka() {
		return postnaStevilka;
	}
	public void setPostnaStevilka(String postnaStevilka) {
		this.postnaStevilka = postnaStevilka;
	}
	
	public Placilo getStanjePlacila() {
		return stanjePlacila;
	}
	
	public void setStanjePlacila(Placilo stanjePlacila) {
		this.stanjePlacila = stanjePlacila;
	}
	
	public String toString() {
		//System.out.print("\n----Podatki o potnikih----\n");
		String str = super.toString();
		str = str + "\nKontakt: "+ kontaktnaStevilka + "\n";
		str = str + "Naslov: "+ naslov + "\n";		
		str = str + "Postna st.: "+ postnaStevilka + "\n";
		str = str + "Posta: "+ posta + "\n";
		str = str + "Stanje placila: " + getStanjePlacila() + "\n";
		
		return str;
	}
	
}
