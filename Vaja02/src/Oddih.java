
import java.util.ArrayList;
import java.util.List;

public class Oddih {
	private String naziv;
	private Destinacija destinacija;
	private Oseba vodic;
	private List<Paket> ponudbePaketov = new ArrayList<Paket>();

	/**
	 * 
	 */
	public Oddih() {
		naziv = "";
		destinacija = new Destinacija();
		vodic = new Oseba();
	}
	
	/**
	 * @param naziv
	 */
	public Oddih(String naziv) {
		this.naziv = naziv;
	}
	
	/**
	 * @param naziv
	 * @param destinacija
	 * @param vodic
	 * @param ponudbePaketov
	 */
	public Oddih(String naziv, Destinacija destinacija, Oseba vodic, List<Paket> ponudbePaketov) {
		this(naziv);
		this.destinacija = destinacija;
		this.vodic = vodic;
		this.ponudbePaketov = ponudbePaketov;
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
	public Destinacija getDestinacija() {
		return destinacija;
	}

	/**
	 * @param destinacija
	 */
	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	/**
	 * @return
	 */
	public Oseba getVodic() {
		return vodic;
	}
	
	/**
	 * @param vodic
	 */
	public void setVodic(Oseba vodic) {
		this.vodic = vodic;
	}
	
	/**
	 * @return
	 */
	public List<Paket> getPonudbePaketov() {
		return ponudbePaketov;
	}

	/**
	 * @param ponudbePaketov
	 */
	public void setPonudbePaketov(List<Paket> ponudbePaketov) {
		this.ponudbePaketov = ponudbePaketov;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = new String();
		
		str = "\nNaziv: " + naziv;
		str += vodic.toString();
		str += destinacija.toString();
		str += "\nPonudbe paketov: \n";
		
		for (int i=0; i<ponudbePaketov.size(); i++) {
			str += ponudbePaketov.get(i).toString();
		}
		
		return str;
		
	}

}
