/*
 * Razred Oddih razsirite z naslednjimi podrazredi:
 * Izlet, ki je dopolnjen z atributoma zbirno mesto ter ura odhoda.
 */
package si.unimb.ruk.prijatelj.logika.oddihi;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Paket> getPonudbaPaketov(){
		return super.getPonudbaPaketov();
	}
	
	public void setPonudbaPaketov(List<Paket> ponudbaPaketov){
		super.setPonudbaPaketov(ponudbaPaketov);
	}
}
