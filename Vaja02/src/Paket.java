import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Paket extends Oddih {
	private GregorianCalendar zacetekOddiha;
	private GregorianCalendar konecOddiha;
	private double cena;
	private int stMest;
	private final int minPopustPotnikov = 10;
	private final int popustVelikaSkupina = 12;
	private final int popustSkupinaProcent = 5;
	private final double popustOtrociProcent = 0.5;
	
	public Paket() {
		
	}
	
	/**
	 * @param zacetekOddiha
	 * @param konecOddiha
	 * @param cena
	 * @param stMest
	 */
	public Paket(GregorianCalendar zacetekOddiha, GregorianCalendar konecOddiha, double cena, int stMest) {
		this.zacetekOddiha = zacetekOddiha;
		this.konecOddiha = konecOddiha;
		this.cena = cena;
		this.stMest = stMest;
	}
	
	/**
	 * 
	 * @return
	 */
	public GregorianCalendar getZacetekOddiha() {
		return zacetekOddiha;
	}
	
	/**
	 * @param zacetekOddiha
	 */
	public void setZacetekOddiha(GregorianCalendar zacetekOddiha) {
		this.zacetekOddiha = zacetekOddiha;
	}
	
		
	/**
	 * @return
	 */
	public GregorianCalendar getKonecOddiha() {
		return konecOddiha;
	}
	
	/**
	 * @param konecOddiha
	 */
	public void setKonecOddiha(GregorianCalendar konecOddiha) {
		this.konecOddiha = konecOddiha;
	}
	
		
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
	public int getStMest() {
		return stMest;
	}
	
	/**
	 * @param stMest
	 */
	public void setStMest(int stMest) {
		this.stMest = stMest;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = new String();
		
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
		
        str = "\nIzpis podatkov o paketih: ";
        str += "\nZacetek oddiha: " + df.format(zacetekOddiha.getTime());
        str += "\nKonec oddiha: " + df.format(konecOddiha.getTime());
        str += "\nCena oddiha: " + cena;
        str += "\nSt. prostih mest: " + stMest;
		
		return str;
	}
	
	// vrne obicajno prodajno ceno paketa za posameznika
	/**
	 * @return
	 */
	public double izracunajCeno(){
		return cena;
	}
	
	// ce se popotniki na oddih prijavijo kot skupina(vsaj 10 clanov) prejmejo na vsakega 
	// clana 5% popusta, zmanjsajo se tudi skupni administracijski stroski v visini 12€.
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
	
	// izracuna ceno paketa za druzine, pri cemer placajo druzine za vsakega otroka 50% cene odraslega
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
}
