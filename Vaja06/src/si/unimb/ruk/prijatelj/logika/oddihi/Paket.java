package si.unimb.ruk.prijatelj.logika.oddihi;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import si.unimb.ruk.prijatelj.logika.osebe.Potnik;
import si.unimb.ruk.prijatelj.logika.osebe.Potnik.Placilo;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic;



/**
 * @author Joze
 * Razred Paket izpeljan iz razreda Oddih
 */
public class Paket extends Oddih implements Serializable{

	private double cena;
	private GregorianCalendar datum_zacetka;
	private GregorianCalendar datum_konca;
	private int stevilo_mest;

	private List<Potnik> prijavljeniPotniki;
	private List<Vodic> seznamVodicev;
	private List<Izlet> seznamIzletov;

	private List<Krizarjenje> seznamKrizarjenj;
	private List<Pocitnice> seznamPocitnic;
	
	private final int minPopustPotnikov = 10;
	private final int popustVelikaSkupina = 12;
	private final int popustSkupinaProcent = 5;
	private final double popustOtrociProcent = 0.5;
	
	public Paket() {
		
	}
	
	/**
	 * Konstruktor paket 
	 * 
	 * @param cena
	 * @param datum_zacetka
	 * @param datum_konca
	 * @param stevilo_mest
	 */
	public Paket(double cena, GregorianCalendar datum_zacetka, GregorianCalendar datum_konca, int stevilo_mest) {
		this.cena = cena;
		this.datum_zacetka = datum_zacetka;
		this.datum_konca = datum_konca;
		this.stevilo_mest = stevilo_mest;
	}
	

	public List<Potnik> getPrijavljeniPotniki() {
		return prijavljeniPotniki;
	}

	public void setPrijavljeniPotniki(List<Potnik> prijavljeniPotniki) {
		this.prijavljeniPotniki = prijavljeniPotniki;
	}

	public List<Vodic> getSeznamVodicev() {
		return seznamVodicev;
	}

	public void setSeznamVodicev(List<Vodic> seznamVodicev) {
		this.seznamVodicev = seznamVodicev;
	}


	public List<Izlet> getSeznamIzletov() {
		return seznamIzletov;
	}

	public void setSeznamIzletov(List<Izlet> seznamIzletov) {
		this.seznamIzletov = seznamIzletov;
	}

	public List<Krizarjenje> getSeznamKrizarjenj() {
		return seznamKrizarjenj;
	}

	public void setSeznamKrizarjenj(List<Krizarjenje> seznamKrizarjenj) {
		this.seznamKrizarjenj = seznamKrizarjenj;
	}

	public List<Pocitnice> getSeznamPocitnic() {
		return seznamPocitnic;
	}

	public void setSeznamPocitnic(List<Pocitnice> seznamPocitnic) {
		this.seznamPocitnic = seznamPocitnic;
	}
	//getter in setter metode

	/**
	 * @return
	 */
	public double getCena() {
		return cena;
	}
	/**
	 * @param cena
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}
	/**
	 * @return
	 */
	public GregorianCalendar getDatum_zacetka() {
		return datum_zacetka;
	}
	/**
	 * @param datum_zacetka
	 */
	public void setDatum_zacetka(GregorianCalendar datum_zacetka) {
		this.datum_zacetka = datum_zacetka;
	}
	/**
	 * @return
	 */
	public GregorianCalendar getDatum_konca() {
		return datum_konca;
	}
	/**
	 * @param datum_konca
	 */
	public void setDatum_konca(GregorianCalendar datum_konca) {
		this.datum_konca = datum_konca;
	}
	/**
	 * @return
	 */
	public int getStevilo_mest() {
		return stevilo_mest;
	}
	/**
	 * @param stevilo_mest
	 */
	public void setStevilo_mest(int stevilo_mest) {
		this.stevilo_mest = stevilo_mest;
	}
	
	
	public String toStringVodici() {
		System.out.println("V toStringVodici() metodi");
		String str = new String();

		for (int i=0; i<seznamVodicev.size(); i++) {
			str += "Vodic : " + (i+1) + "\n";
			str += seznamVodicev.get(i).toString() + "\n\n";
		}
		System.out.println("Velikost seznama vodicev: " + seznamVodicev.size());

		return str;	
	}
	
	public String toStringIzleti() {
		String str = new String();
		
		for(int i=0; i<seznamIzletov.size(); i++) {
			str += "Izlet: " + (i+1) + "\n";
			str += seznamIzletov.get(i).toString() + "\n\n";
		}
		
		return str;
	}

	public String toStringKrizarjenja() {
		String str = new String();
		
		for(int i=0; i<seznamKrizarjenj.size(); i++) {
			str += "Krizarjenje: " + (i+1) + "\n";
			str += seznamKrizarjenj.get(i).toString() + "\n\n";
		}
		
		return str;
	}

	public String toStringPocitnice() {
		String str = new String();
		
		for(int i=0; i<seznamPocitnic.size(); i++) {
			str += "Pocitnice: " + (i+1) + "\n";
			str += seznamPocitnic.get(i).toString() + "\n\n";
		}
		
		return str;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*
	public String toString(){
		return "Cena: " + cena + ", Datum zacetka: " + datum_zacetka.get(Calendar.DAY_OF_MONTH)+ "."+ datum_zacetka.get(Calendar.MONTH)+ "." + datum_zacetka.get(Calendar.YEAR) + ", Datum konca: " + datum_konca.get(Calendar.DAY_OF_MONTH)+ "."+ datum_konca.get(Calendar.MONTH)+ "." + datum_konca.get(Calendar.YEAR) + ", Stevilo mest: " + stevilo_mest + "\n";
	}
	*/
	public String toString(){
		String str = new String();
		
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy");
		
		str = "\nIzpis podatkov o paketih: ";
		str += "\nCena: " + cena;
		str += "\nDatum zacetka: " + df.format(datum_zacetka.getTime());
		str += "\nDatum konca: " + df.format(datum_konca.getTime());
		str += "\nStevilo prostih mest: " + stevilo_mest + "\n";
		str += "\n-------Podatki o potnikih---------";
		for (int i=0; i<prijavljeniPotniki.size(); i++) {
			str += "\nPotnik na indeksu: " + i + ":\n";
			str += prijavljeniPotniki.get(i).toString();
		}
		
		return str;
	}

	/**
	 * @return
	 */
	public double izracunajCeno(){
		return cena;
	}

	//Ce se popotniki na oddih prijavijo kot skupina(vsaj 10 clanov) prejmejo na vsakega clana 5% popusta, 
	//zmanjsajo se tudi skupni administracijski stroski v visini 12eur.
	/**
	 * @param velikostSkupine
	 * @return
	 */
	public double izracunajCeno(int velikostSkupine){
		if(velikostSkupine >= minPopustPotnikov){
			final double cena_paketa = cena*velikostSkupine - velikostSkupine*((popustSkupinaProcent*cena)/100) - popustVelikaSkupina;
			return cena_paketa;
		}
		else return cena*velikostSkupine;
	}
	//izracuna ceno paketa za druzine, pri cemer placajo druzine za vsakega otroka 50% cene odraslega.
	/**
	 * @param steviloOdraslih
	 * @param steviloOtrok
	 * @return
	 */
	public double izracunajCeno(int steviloOdraslih, int steviloOtrok){
		if(steviloOtrok > 0){
			final double cena_druzine = steviloOdraslih*cena + (steviloOtrok*(cena*popustOtrociProcent));
			return cena_druzine;
		}
		else return cena*steviloOdraslih;		
	}

	/* 
	 * izjema PaketZasedenException se prozi vedno, ko zelimo dodati rezervacijo, 
	 * povprasevanje ali placilo ter ni vec prostih mest (stRezerviranih+stPlacanih < prostaMesta
	 */
	
	public void test() {
		System.out.println("St mest: " + stevilo_mest + "\n");
		System.out.println("Prijavljeni potniki size(): " + prijavljeniPotniki.size() + "\n");
	}

	public void prijaviPotnika(Potnik potnik) throws PaketZasedenException {
		System.out.println("St mest: " + stevilo_mest + "\n");
		System.out.println("Prijavljeni potniki size(): " + prijavljeniPotniki.size() + "\n");
		if (this.stevilo_mest == prijavljeniPotniki.size())
		{
			throw new PaketZasedenException();
		}
		prijavljeniPotniki.add(potnik);

	}

	public void odjaviPotnika(Potnik potnik)
	{
		prijavljeniPotniki.remove(potnik);
	}

	public Integer steviloRezerviranihOddihov()
	{
		Integer rezervirani = 0 ;
		for (Potnik potnik : prijavljeniPotniki) 
		{
			if (potnik.getStanjePlacila() == Placilo.rezerviral)
			{
				rezervirani ++;
			}
		}

		return rezervirani;
	}

	public Integer steviloProdanihOddihov()
	{
		Integer prodani = 0 ;
		for (Potnik potnik : prijavljeniPotniki) 
		{
			if (potnik.getStanjePlacila() == Placilo.placal)
			{
				prodani ++;
			}
		}

		return prodani;
	}
	
	@SuppressWarnings("serial")
	public class PaketZasedenException extends Exception
	{

		/**
		 * 
		 */

		@Override
		public String toString() {

			return "Napaka! Ta paket je ze zaseden!"+super.toString();
		}

	}	
}