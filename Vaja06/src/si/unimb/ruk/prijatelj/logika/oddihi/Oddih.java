/*
 * Vključitveni polimorfizem je posledica tega da lahko eno samo ime predstavlja objekte različnih razredov,
 * ki so povezani z nekim skupnim nadrazredom (ali vmesnikom)
 * 
 * Abstraktni razred ima vsaj eno abstraktno metodo  (ni določena implementacija) vrniPonudbo
 * Abs razred neposredno ne more imeti primerkov
 * 
 * istantiacija ni možna - ne moremo ustvart primerkov abstraktnega razreda
 * abstraktna metoda nima telesa, signaturo zaklučuje podpičje
 * 
 * podrazred abs razreda lahko instaciramo le če ta implementira vse abs metode sicer je tudi podrazred abstrakten
 * 
 * new ne moremo uporabit pri abstrakt razredih
 */

package si.unimb.ruk.prijatelj.logika.oddihi;
/*
 * V razred Oddih vključite atribute naziv, destinacija, vodič, datum začetka oddiha, 
 * datum konca oddiha, cena ter število mest
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import si.unimb.ruk.prijatelj.logika.osebe.Oseba;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic;

/**
 * @author Joze
 *
 */
public abstract class Oddih  implements Serializable{
	protected String naziv;
	protected Destinacija destinacija;
	protected Oseba vodic;
	protected List<Paket> ponudbaPaketov;
	protected String opisPonudbe;
	
	// privzeti konstruktor
	
	/**
	 * 
	 */
	public Oddih() {
		//this("Morje", "Palma", new GregorianCalendar(2012,5,5), new GregorianCalendar(2012,6,6), 300.4, 4);
		naziv = "";
		destinacija = new Destinacija();
		vodic = new Vodic();
		ponudbaPaketov = new ArrayList<Paket>();
	}
	
	// konstruktorja razreda Destinacija in Oddih naj prjmeta parameter naziv
	/**
	 * @param naziv
	 */
	public Oddih(String naziv) {
		this.naziv = naziv;
	}
		
	// konstruktorja razreda Destinacija in Oddih naj prjmeta parameter naziv
	/**
	 * @param naziv
	 * @param destinacija
	 * @param vodic
	 * @param ponudbaPaketov
	 */
	public Oddih(String naziv, Destinacija destinacija, Oseba vodic, List<Paket> ponudbaPaketov) {
		this(naziv);
		this.destinacija = destinacija;
		this.vodic = vodic;
		this.ponudbaPaketov = ponudbaPaketov;
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
	public List<Paket> getPonudbaPaketov() {
		return ponudbaPaketov;
	}

	/**
	 * @param ponudbaPaketov
	 */
	public void setPonudbaPaketov(List<Paket> ponudbaPaketov) {
		this.ponudbaPaketov = ponudbaPaketov;
	}
	
	public String vrniPonudbo()
	{
		return opisPonudbe;
	}
	
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        String str = new String();
        
        
		str = "Naziv: " + naziv +"\n";
		str += "\nPodatki o vodicu: \n";
		str = str + vodic.toString() + "\n";
		
		for (int i = 0; i < ponudbaPaketov.size(); i++) {
			str = str + ponudbaPaketov.get(i).toString();
		}
		
		return str;
	}
}
