/*
 * Razred Oddih razsirite z naslednjimi podrazredi:
 * Izlet, ki je dopolnjen z atributoma zbirno mesto ter ura odhoda.
 */
package si.unimb.ruk.prijatelj.logika.oddihi;


public class Izlet extends Oddih{

	private String zbirnoMesto;
	private String uraOdhoda;
	
	public Izlet() {
	}
	
	public Izlet(String naziv)
	{
		super(naziv);
	}

	public String getZbirnoMesto() {
		return zbirnoMesto;
	}

	public void setZbirnoMesto(String zbirnoMesto) {
		this.zbirnoMesto = zbirnoMesto;
	}

	public String getUraOdhoda() {
		return uraOdhoda;
	}

	public void setUraOdhoda(String uraOdhoda) {
		this.uraOdhoda = uraOdhoda;
	}
	
	public String toString() {
		String str = new String();
		str = super.toString();
		
		str += "\nZbirno mesto: " + getZbirnoMesto();
		str += "\nUra odhoda: " + getUraOdhoda() + "\n";
		
		return str;
	}
}
