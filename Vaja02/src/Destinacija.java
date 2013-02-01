import java.text.SimpleDateFormat;

public class Destinacija {
	private String naziv;
	private String lokacija;
	private String drzava;
	
	/**
	 * 
	 */
	public Destinacija() {
		naziv = "";
		lokacija = "";
		drzava = "";
	}
	
	/**
	 * @param naziv
	 */
	public Destinacija(String naziv) {
		this.naziv=naziv;
	}
	
	/**
	 * @param naziv
	 * @param lokacija
	 * @param drzava
	 */
	public Destinacija(String naziv, String lokacija, String drzava) {
		this(naziv); // kliecemo konstruktor, da se koda ne podvaja
		this.lokacija = lokacija;
		this.drzava = drzava;
	}
	
	/**
	 * @return
	 */
	public String getNaziv() {
		return naziv;
	}
	
	/**
	 * @param naziv
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	/**
	 * @return
	 */
	public String getLokacija() {
		return lokacija;
	}
	
	/**
	 * @param lokacija
	 */
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
		
	/**
	 * @return
	 */
	public String getDrzava() {
		return drzava;
	}
	
	/**
	 * @param drzava
	 */
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = new String();
		str = "\nIzpis podatkov o destinacijah:\n";
		str += "Naziv destinacije: " + naziv  + "\n";
		str += "Lokacija destinacije: " + lokacija + "\n";
		str += "Drzava destinacije: " + drzava + "\n";
		
		return str;
	}
	
}
