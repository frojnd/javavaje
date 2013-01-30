/*
 * Razred Oddih razsirite z naslednjimi podrazredi:
 * Izlet, ki je dopolnjen z atributoma zbirno mesto ter ura odhoda.
 */
package si.unimb.ruk.prijatelj.logika.oddihi;


public class Izlet extends Oddih{

	private String zbirnoMesto;
	private int uraOdhoda;
	
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

	public int getUraOdhoda() {
		return uraOdhoda;
	}

	public void setUraOdhoda(int uraOdhoda) {
		this.uraOdhoda = uraOdhoda;
	}
	
	public String toString() {
		return super.toString();
	}
}
