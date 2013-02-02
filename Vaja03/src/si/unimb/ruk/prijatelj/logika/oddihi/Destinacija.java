package si.unimb.ruk.prijatelj.logika.oddihi;

/*
 * Razred Destinacija naj ima atribute: naziv, lokacija, država.
 */



/**
 * @author Joze
 *
 */
public class Destinacija {
	private String naziv;
	private String lokacija;
	private String drzava;
	
	// privzeti konstruktor
	/**
	 * 
	 */
	public Destinacija() {
		//this("Pocitnice1", "Hurgada", "Egipt");
		naziv = "";
		lokacija = "";
		drzava = "";
	}
	
	// konstruktorja razreda Destinacija in Oddih naj prjmeta parameter naziv
	/**
	 * @param naziv
	 */
	public Destinacija(String naziv) {
		this.naziv=naziv;
	}
	
	// konstruktorja razreda Destinacija in Oddih naj prjmeta parameter naziv
	/**
	 * @param naziv
	 * @param lokacija
	 * @param drzava
	 */
	public Destinacija(String naziv, String lokacija, String drzava) {
		this(naziv);
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
		str = "Naziv: "+naziv+", lokacija:"+lokacija+", drzava:"+drzava;
		return str;
	}
	
}
