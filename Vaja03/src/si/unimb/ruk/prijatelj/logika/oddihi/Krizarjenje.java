/*
 * Razred Oddih razsirite z naslednjimi podrazredi:
 * Krizarjenje, ki je dopolnjen z atributoma naziv ladjarja ter mesto odhoda.
 */
package si.unimb.ruk.prijatelj.logika.oddihi;

public class Krizarjenje extends Oddih{
	private String nazivLadjarja;
	private String mestoOdhoda;
	
	/**
	 * 
	 */
	public Krizarjenje() {
	}
	
	/**
	 * @param naziv
	 */
	public Krizarjenje(String naziv) {
		super(naziv);
	}

	/**
	 * @return
	 */
	public String getNazivLadjarja() {
		return nazivLadjarja;
	}

	/**
	 * @param nazivLadjarja
	 */
	public void setNazivLadjarja(String nazivLadjarja) {
		this.nazivLadjarja = nazivLadjarja;
	}

	/**
	 * @return
	 */
	public String getMestoOdhoda() {
		return mestoOdhoda;
	}

	/**
	 * @param mestoOdhoda
	 */
	public void setMestoOdhoda(String mestoOdhoda) {
		this.mestoOdhoda = mestoOdhoda;
	}
	
	/* (non-Javadoc)
	 * @see si.unimb.ruk.prijatelj.logika.oddihi.Oddih#toString()
	 */
	public String toString() {
		String str = new String();
		str = super.toString();
		
		str += "\nNaziv ladjarja: " + getNazivLadjarja() + "\n";
		str += "\nMesto odhoda: " + getMestoOdhoda() + "\n";
		
		return str;
	}
	
	/* (non-Javadoc)
	 * @see si.unimb.ruk.prijatelj.logika.oddihi.Oddih#vrniPonudbo()
	 */
	public String vrniPonudbo() {
		String str = new String();
		
		str = "\nVrniPonudbo(): ";
		str += "\nNaziv oddiha: " + naziv;
		str += "\nDestinacija: " + destinacija;
		str += "\nVodic: " + vodic;
		str += "\nIzbrani paket iz ponudbe paketov: " + ponudbaPaketov;
		str += "\nOpis ponudbe je sledec: " + opisPonudbe;
		str += "\nNaziv ladjarja je: " + nazivLadjarja;
		str += "\nMesto odhoda je: " + mestoOdhoda;
		
		return str;
	}
}
