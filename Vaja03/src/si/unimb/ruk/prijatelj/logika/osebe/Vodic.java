package si.unimb.ruk.prijatelj.logika.osebe;

import java.util.Vector;

/**
 * @author Joze
 *
 */
public class Vodic extends Oseba{
	
	private boolean licencaGorskegaVodnika;
	private Vector<Jezik> govori;
	
	// nastevni tip za jezike
	public enum Jezik{Slovensko, Nemsko, Italjansko, Spansko, Anglesko}

	public Vodic() {
		licencaGorskegaVodnika = false;
		govori = new Vector<Vodic.Jezik>();
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

	public Vector<Jezik> getGovori() {
		return govori;
	}

	public void setGovori(Vector<Jezik> govori) {
		this.govori = govori;
	}
	
	@Override
	public String toString() {
		String str = new String();
		str = super.toString();
		str = str + "\n Ima licenco gorskega vodnika: ";
		if (licencaGorskegaVodnika)
		{
			str = str + "DA";
		}
		else
		{
			str = str + "NE";
		}
		
		str = str + "\n Govori: ";
		
		for (int i = 0; i < govori.size(); i++) {
			str = str + govori.get(i) + "\n";
		}
		return str;
	}
	
}
