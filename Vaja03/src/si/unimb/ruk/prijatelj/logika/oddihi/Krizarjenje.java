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
	
	@Override
	public String toString() {
		return super.toString();
	}
}
