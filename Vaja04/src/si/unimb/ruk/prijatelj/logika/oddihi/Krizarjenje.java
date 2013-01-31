/*
 * Razred Oddih razsirite z naslednjimi podrazredi:
 * Krizarjenje, ki je dopolnjen z atributoma naziv ladjarja ter mesto odhoda.
 */
package si.unimb.ruk.prijatelj.logika.oddihi;

public class Krizarjenje extends Oddih{
	private String nazivLadjarja;
	private String mestoOdhoda;
	
	public Krizarjenje() {
	}
	
	public Krizarjenje(String naziv) {
		super(naziv);
	}

	public String getNazivLadjarja() {
		return nazivLadjarja;
	}

	public void setNazivLadjarja(String nazivLadjarja) {
		this.nazivLadjarja = nazivLadjarja;
	}

	public String getMestoOdhoda() {
		return mestoOdhoda;
	}

	public void setMestoOdhoda(String mestoOdhoda) {
		this.mestoOdhoda = mestoOdhoda;
	}
	
	public String toString() {
		String str = new String();
		str = super.toString();
		
		str += "\nNaziv ladjarja: " + getNazivLadjarja() + "\n";
		str += "\nMesto odhoda: " + getMestoOdhoda() + "\n";
		
		return str;
	}
}
