import java.text.SimpleDateFormat;


/*
 * Razred Destinacija naj ima atribute: naziv, lokacija, država.
 */

public class Destinacija {
	private String naziv;
	private String lokacija;
	private String drzava;
	
	// privzeti konstruktor
	public Destinacija() {
		//this("Pocitnice1", "Hurgada", "Egipt");
		naziv = "";
		lokacija = "";
		drzava = "";
	}
	
	// konstruktorja razreda Destinacija in Oddih naj prjmeta parameter naziv
	public Destinacija(String naziv) {
		this.naziv=naziv;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	public String getLokacija() {
		return lokacija;
	}
	
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
		
	public String getDrzava() {
		return drzava;
	}
	
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	public void izpisDestinacije() {
		System.out.println("Naziv destinacije: " + naziv );
		System.out.println("Lokacija destinacije: " + lokacija );
		System.out.println("Drzava destinacije: " + drzava );
	}
	
	
}
