/*
 * Razred Oddih razširite z naslednjimi podrazredi:
Pocitnice, ki mu dodate atributoma naziv hotela, število zvezdic hotela,prevoz (naštevalni tip z vrednostmi 
“letalski”, “avtobusni”, “vlak”, “lastni”) ter atributom naštevalnega tipa ponudba z vrednostmi 
(“nočitev”, “pol penzion”, “polni penzion”).
 */
package si.unimb.ruk.prijatelj.logika.oddihi;

public class Pocitnice extends Oddih{
	private String nazivHotela;
	private int stZvezdic;
	private Prevoz prevoz;
	private Ponudba ponudba;
	
	public enum Prevoz{letalski, avtobusni, vlak, lastni}
	public enum Ponudba{nocitev, pol_penzion,polni_penzion}
	
	/**
	 * 
	 */
	public Pocitnice() {
	
	}
	
	/**
	 * @param naziv
	 */
	public Pocitnice(String naziv) {
		super(naziv);
	}
	
	/**
	 * @return
	 */
	public String getNazivHotela() {
		return nazivHotela;
	}
	
	/**
	 * @param nazivHotela
	 */
	public void setNazivHotela(String nazivHotela) {
		this.nazivHotela = nazivHotela;
	}
	
	/**
	 * @return
	 */
	public int getStZvezdic() {
		return stZvezdic;
	}
	
	/**
	 * @param stZvezdic
	 */
	public void setStZvezdic(int stZvezdic) {
		this.stZvezdic = stZvezdic;
	}
	
	/**
	 * @return
	 */
	public Prevoz getPrevoz() {
		return prevoz;
	}
	
	/**
	 * @param prevoz
	 */
	public void setPrevoz(Prevoz prevoz) {
		this.prevoz = prevoz;
	}
	
	/**
	 * @return
	 */
	public Ponudba getPonudba() {
		return ponudba;
	}
	
	/**
	 * @param ponudba
	 */
	public void setPonudba(Ponudba ponudba) {
		this.ponudba = ponudba;
	}
	
	/* (non-Javadoc)
	 * @see si.unimb.ruk.prijatelj.logika.oddihi.Oddih#toString()
	 */
	public String toString() {
		String str = new String();
		str = super.toString();
		
		str += "\nNaziv hotela: " + getNazivHotela() ;
		str += "\nStevilo zvezdic: " + getStZvezdic() + "\n";
		
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
		str += "\nNaziv ladjarja je: " + prevoz;
		str += "\nMesto odhoda je: " + ponudba;
		
		return str;
	}
	
}
