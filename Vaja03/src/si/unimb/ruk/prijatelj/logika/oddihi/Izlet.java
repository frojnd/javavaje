/*
 * Razred Oddih razsirite z naslednjimi podrazredi:
 * Izlet, ki je dopolnjen z atributoma zbirno mesto ter ura odhoda.
 */
package si.unimb.ruk.prijatelj.logika.oddihi;


public class Izlet extends Oddih{

	private String zbirnoMesto;
	private String uraOdhoda;
	
	/**
	 * 
	 */
	public Izlet() {
	}
	
	/**
	 * @param naziv
	 */
	public Izlet(String naziv)
	{
		super(naziv);
	}

	/**
	 * @return
	 */
	public String getZbirnoMesto() {
		return zbirnoMesto;
	}

	/**
	 * @param zbirnoMesto
	 */
	public void setZbirnoMesto(String zbirnoMesto) {
		this.zbirnoMesto = zbirnoMesto;
	}

	/**
	 * @return
	 */
	public String getUraOdhoda() {
		return uraOdhoda;
	}

	/**
	 * @param uraOdhoda
	 */
	public void setUraOdhoda(String uraOdhoda) {
		this.uraOdhoda = uraOdhoda;
	}
	
	/* (non-Javadoc)
	 * @see si.unimb.ruk.prijatelj.logika.oddihi.Oddih#toString()
	 */
	public String toString() {
		String str = new String();
		str = super.toString();
		
		str += "\nZbirno mesto: " + getZbirnoMesto();
		str += "\nUra odhoda: " + getUraOdhoda() + "\n";
		
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
		str += "\nNaziv ladjarja je: " + zbirnoMesto;
		str += "\nMesto odhoda je: " + uraOdhoda;
		
		return str;
	}
}
