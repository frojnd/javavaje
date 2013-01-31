package si.unimb.ruk.prijatelj.logika.osebe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Joze
 *
 */
public class Vodic extends Oseba{
	
	private boolean licencaGorskegaVodnika;
	private List<Jezik> govori = new ArrayList<Vodic.Jezik>();
	
	// nastevni tip za jezike
	public enum Jezik{Slovensko, Nemsko, Italijansko, Spansko, Anglesko}

	public Vodic() {
		licencaGorskegaVodnika = false;
	}
	
	public Vodic(String ime, String priimek)
	{
		super(ime, priimek);
	}
	
	public boolean isLicencaGorskegaVodnika() {
		return licencaGorskegaVodnika;
	}

	public void setLicencaGorskegaVodnika(boolean licencaGorskegaVodnika) {
		this.licencaGorskegaVodnika = licencaGorskegaVodnika;
	}

	public List<Jezik> getGovori() {
		return govori;
	}

	public void setGovori(List<Jezik> govori) {
		this.govori = govori;
	}
	
	public String toString() {
		String str = new String();
		str = super.toString();
		str = str + "\nIma licenco gorskega vodnika: ";
		if (licencaGorskegaVodnika)
		{
			str = str + "DA";
		}
		else
		{
			str = str + "NE";
		}
		
		str = str + "\nGovori: ";
		
		for (int i = 0; i < govori.size(); i++) {
			str = str + govori.get(i) + " ";
		}
		return str;
	}
	
}
